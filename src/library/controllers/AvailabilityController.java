/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controllers;

import java.io.IOException;
import library.io.AvailabilityFileHandler;
import library.io.BaseFileHandler;
import library.models.Availability;
import library.utils.InvalidFileException;
/**
 *
 * @author Xiquinho
 */
public class AvailabilityController extends BaseController<Availability> {

    @Override
    public Availability[] loadFile() throws InvalidFileException, IOException{
        Availability[] a = getFileHandler().readFile();
        
        ModelsInMemory.setAvailability(a);
        return getAll();
    }
    
    @Override
    protected BaseFileHandler<Availability> getFileHandler() {
       return new AvailabilityFileHandler();
    }

    @Override
    public Availability[] getAll() {
         return ModelsInMemory.getAvailability();
    }

    void decrease(String bookId) throws IOException, InvalidFileException {
        Availability a = ModelsInMemory.getAvailabity(bookId);
        a.setAmtAvailable(a.getAmount()-1);
        getFileHandler().editLine(a);
        loadFile();
    
    }

    public Availability getById(String id) {
        return ModelsInMemory.getAvailabity(id);
    }

    void increase(String bookId) throws IOException, InvalidFileException {
        Availability a = ModelsInMemory.getAvailabity(bookId);
        a.setAmtAvailable(a.getAmount()+1);
        getFileHandler().editLine(a);
        loadFile();
    }
    
}
