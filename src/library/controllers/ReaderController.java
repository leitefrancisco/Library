/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controllers;

import java.io.IOException;
import library.io.BaseFileHandler;
import library.io.ReaderFileHandler;
import library.models.Reader;
import library.utils.InvalidFileException;

/**
 *
 * @author usr
 */
public class ReaderController extends BaseController<Reader>{

    @Override
    public Reader[] loadFile() throws InvalidFileException, IOException {
        Reader[] readers = getFileHandler().readFile();
        ModelsInMemory.setReaders(readers);
        return getAll();
    }

    @Override
    protected BaseFileHandler<Reader> getFileHandler() {
        return new ReaderFileHandler();
    }
    
    @Override
    public Reader[] getAll() {
        return ModelsInMemory.getReaders();
    }

    public Reader[] getActiveReaders() {
        return ModelsInMemory.getActiveReaders();
    }

    public Reader[] getInactiveReaders() {
      return ModelsInMemory.getInactiveReaders();
    }

    public void addNewReader(Reader r) throws IOException, InvalidFileException {
        r.setId(String.valueOf(ModelsInMemory.getReaders().length+1));
        
    }

    public void addNewReader(String firstName, String lastName, String address) throws IOException, InvalidFileException {
        Reader r = new Reader(java.util.UUID.randomUUID().toString(), firstName, lastName, address, "1");
        add(r);
        loadFile();
    }

    public Reader getReaderById(String readerId) {
        return ModelsInMemory.getReaderById(readerId);
    }

    public void deactivateReader(Reader selectedReader) throws IOException, InvalidFileException {
        selectedReader.setActive("0");
        getFileHandler().editLine(selectedReader);
        loadFile();
    }
    
    public void activateReader(Reader selectedReader) throws IOException, InvalidFileException {
        selectedReader.setActive("1");
        getFileHandler().editLine(selectedReader);
        loadFile();
    }

    public void editReaderInfo(Reader r, String newFirstName, String newLastName, String newAddress) throws InvalidFileException, IOException {
        r.setFirstName(newFirstName);
        r.setLastName(newLastName);
        r.setAddress(newAddress);
        r.setFullName();
        getFileHandler().editLine(r);
        loadFile();
    }
    
}
