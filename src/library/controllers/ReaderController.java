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
 * This class is the controller responsible for the Reader Object
 * @author Francisco
 */
public class ReaderController extends BaseController<Reader>{
    /**
     * calls the file handler loads the file and updates the cache memory
     * @return
     * @throws InvalidFileException
     * @throws IOException 
     */
    @Override
    public Reader[] loadFile() throws InvalidFileException, IOException {
        Reader[] readers = getFileHandler().readFile();
        ModelsInMemory.setReaders(readers);
        return getAll();
    }
    /**
     * returns the file handler responsible for the Reader Object
     * @return 
     */
    @Override
    protected BaseFileHandler<Reader> getFileHandler() {
        return new ReaderFileHandler();
    }
    /**
     * return all the readers in memory
     * @return 
     */
    @Override
    public Reader[] getAll() {
        return ModelsInMemory.getReaders();
    }
    /**
     * calls the file handler and  gets all the active readers
     * @return 
     */
    public Reader[] getActiveReaders() {
        return ModelsInMemory.getActiveReaders();
    }
 /**
     * calls the file handler and  gets all the inactive readers
     * @return 
     */
    public Reader[] getInactiveReaders() {
      return ModelsInMemory.getInactiveReaders();
    }
    /**
     * with the information creates a new reader  with a new random ID and add "1" as the active because all new readers are active readers
     * @param firstName
     * @param lastName
     * @param address
     * @throws IOException
     * @throws InvalidFileException 
     */
    public void addNewReader(String firstName, String lastName, String address) throws IOException, InvalidFileException {
        Reader r = new Reader(java.util.UUID.randomUUID().toString(), firstName, lastName, address, "1");
        add(r);
        loadFile();
    }
    /**
     * call the handler and gets a reader by its Id
     * @param readerId
     * @return 
     */
    public Reader getReaderById(String readerId) {
        return ModelsInMemory.getReaderById(readerId);
    }
    /**
     * call the handler, deactivates the reader and refresh the memory
     * @param selectedReader
     * @throws IOException
     * @throws InvalidFileException 
     */
    public void deactivateReader(Reader selectedReader) throws IOException, InvalidFileException {
        selectedReader.setActive("0");
        getFileHandler().editLine(selectedReader);
        loadFile();
    }
    /**
     * call the handler, activates the reader and refresh the memory
     * @param selectedReader
     * @throws IOException
     * @throws InvalidFileException 
     */
    public void activateReader(Reader selectedReader) throws IOException, InvalidFileException {
        selectedReader.setActive("1");
        getFileHandler().editLine(selectedReader);
        loadFile();
    }
    /**
     * edits the new information for a specific reader
     * @param r
     * @param newFirstName
     * @param newLastName
     * @param newAddress
     * @throws InvalidFileException
     * @throws IOException 
     */
    public void editReaderInfo(Reader r, String newFirstName, String newLastName, String newAddress) throws InvalidFileException, IOException {
        r.setFirstName(newFirstName);
        r.setLastName(newLastName);
        r.setAddress(newAddress);
        r.setFullName();
        getFileHandler().editLine(r);
        loadFile();
    }
    /**
     * calls the handler and return the reader by its name
     * @param readerName
     * @return 
     */
    public Reader[] getReadersByName(String readerName) {
        return ModelsInMemory.getReadersByName(readerName);
    }
    
}
