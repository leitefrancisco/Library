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
import library.models.Reader;
import library.utils.AlreadyInQueueException;
import library.utils.AlreadyWithTheBookException;
import library.utils.InvalidFileException;
/**
 *
 * @author Xiquinho
 */
public class AvailabilityController extends BaseController<Availability> {

    @Override
    public Availability[] loadFile() throws InvalidFileException, IOException{
        Availability[] avalabilities = getFileHandler().readFile();
        for (Availability ava : avalabilities) {
            for(String s : ava.getWaitReadersId()){ // []
                Reader r = ModelsInMemory.getReaderById(s);
                if(r != null)
                    ava.getQueue().enqueue(r);
            }
        }
        ModelsInMemory.setAvailabilities(avalabilities);
        return getAll();
    }
    
    @Override
    protected BaseFileHandler<Availability> getFileHandler() {
       return new AvailabilityFileHandler();
    }

    @Override
    public Availability[] getAll() {
         return ModelsInMemory.getAvailabilities();
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
    
    public void addReaderToQueue(String bookId, String readerId) throws IOException, InvalidFileException, AlreadyInQueueException, AlreadyWithTheBookException {
        
        Availability availability = ModelsInMemory.getAvailabity(bookId);
        BorrowController bc = new BorrowController();
        
        Reader reader = ModelsInMemory.getReaderById(readerId);
        
        if(reader != null && availability != null){
            if(availability.getQueue().isInQueue(reader)){
                throw new AlreadyInQueueException(reader.getFullName() + " is already in the queue for " + ModelsInMemory.getBookById(bookId).getTitle());
            }
            if(bc.readerAlreadyWithBook(bookId, readerId)){
                throw new AlreadyWithTheBookException(reader.getFullName() + " have the book  " + ModelsInMemory.getBookById(bookId).getTitle()+ " already and haven't returned it yet, so you cannot add him/her to the queue");
            }
            availability.getQueue().enqueue(reader);
            
            edit(availability);
            loadFile();
        }
    }

    public void removeFirstReaderFromQueue(String bookId) throws IOException, InvalidFileException {
        Availability availability = ModelsInMemory.getAvailabity(bookId);
        availability.getQueue().dequeue(); 
        edit(availability);
        loadFile();
    }
}
