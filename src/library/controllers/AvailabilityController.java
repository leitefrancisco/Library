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
 *This class is the controller for the Availability model , it will take the requests from the view to get
 * the objects in the model and will call the file handler to save the objects in the cache memory (Models In Memory)
 * @author Francisco
 */
public class AvailabilityController extends BaseController<Availability> {
    /**
     * This method calls the the file handler, loads the file, with the Availabilities
     * gets the readers by the Id in the CSV Column and enqueue them into the queue of the availability object
     * and loads the array with all the objects into the Cache Memory ( Models In Memory )
     * @return
     * @throws InvalidFileException
     * @throws IOException 
     */
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
    /**
     * returns the file handler responsible for this object
     * @return 
     */
    @Override
    protected BaseFileHandler<Availability> getFileHandler() {
       return new AvailabilityFileHandler();
    }
    /**
     * returns all the availabilities in the cache memory
     * @return 
     */
    @Override
    public Availability[] getAll() {
         return ModelsInMemory.getAvailabilities();
    }
    /**
     * Decreases the availability to "0" and make the book unavailable
     * @param bookId
     * @throws IOException
     * @throws InvalidFileException 
     */
    void decrease(String bookId) throws IOException, InvalidFileException {
        Availability a = ModelsInMemory.getAvailabity(bookId);
        a.setAmtAvailable(a.getAmount()-1);
        getFileHandler().editLine(a);
        loadFile();
    }
    /**
     * gets the availability in the cache by the ID
     * @param id
     * @return 
     */
    public Availability getById(String id) {
        return ModelsInMemory.getAvailabity(id);
    }
    /**
     * increases the availability to 1 making the book available
     * @param bookId
     * @throws IOException
     * @throws InvalidFileException 
     */
    void increase(String bookId) throws IOException, InvalidFileException {
        Availability a = ModelsInMemory.getAvailabity(bookId);
        a.setAmtAvailable(a.getAmount()+1);
        getFileHandler().editLine(a);
        loadFile();
    }
    /**
     * add the Reader to the queue and refresh the memory, will throw exceptions, if reader is already in queue or if the reader already have the book 
     * but the program will keep running smoothly
     * @param bookId
     * @param readerId
     * @throws IOException
     * @throws InvalidFileException
     * @throws AlreadyInQueueException
     * @throws AlreadyWithTheBookException 
     */
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
    /**
     * will dequeue the first reader in the queue
     * @param bookId
     * @throws IOException
     * @throws InvalidFileException 
     */
    public void removeFirstReaderFromQueue(String bookId) throws IOException, InvalidFileException {
        Availability availability = ModelsInMemory.getAvailabity(bookId);
        availability.getQueue().dequeue(); 
        edit(availability);
        loadFile();
    }
}
