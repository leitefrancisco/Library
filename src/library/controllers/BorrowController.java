/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.controllers;

import java.io.IOException;
import java.util.ArrayList;
import library.io.BaseFileHandler;
import library.io.BorrowFileHandler;
import library.models.Book;
import library.models.Borrow;
import library.models.Reader;
import library.utils.DateFormatUtil;
import library.utils.InvalidFileException;

/**
 *This class is the controller for the Borrow model , it will take the requests from the view to get
 * the objects in the model and will call the file handler to save the objects in the cache memory (Models In Memory)
 * @author Francisco
 */
public class BorrowController extends BaseController<Borrow>{
    /**
     * calls the file handler and reads the CSV, saves all the borrows in the Cache Memory (Models In Memory)
     * @return
     * @throws InvalidFileException
     * @throws IOException
     */
    @Override
    public Borrow[] loadFile() throws InvalidFileException, IOException {
        Borrow[] b = getFileHandler().readFile();
        ModelsInMemory.setBorrows(b);
        return getAll();
    }
    /**
     * gets all the borrows in the cache memory
     * @return 
     */
    @Override
    public Borrow[] getAll() {
        return ModelsInMemory.getBorrows();
    }
    /**
     * returns the file handler responsible for the borrows
     * @return 
     */
    @Override
    protected BaseFileHandler<Borrow> getFileHandler() {
        return new BorrowFileHandler();
    }
    /**
     * gets only the borrows that were not returned yet
     * @return 
     */
    public Borrow[] getBorrowsToReturn() {
        return ModelsInMemory.getBorrowsToReturn();
    }
    /**
     * get a borrow by the book id (not used but might be used in the future)
     * @param bookId
     * @return 
     */
    private Borrow[] getBorrowsByBookId(String bookId){
        return ModelsInMemory.getBorrowsByBookId(bookId);
    }
    /**
     * returns the borrows that contains a specific title 
     * @param title
     * @return 
     */
    public Borrow[] getBorrowsByBookTitle(String title) {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        Book [] books = new BookController().getBooksByTitle(title);
        Borrow[] borrows = this.getAll();
        
        for(Book book : books){
            for(Borrow borrow : borrows){
                if(borrow.getBookId().equals(book.getId()))
                    borrowsToReturn.add(borrow);
            }
        }
        
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
   /**
    * returns the borrows  that contains the reader name searched
    * @param readerName
    * @return 
    */
    public Borrow[] getBorrowsByReaderName(String readerName) {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        Reader[] readers = new ReaderController().getReadersByName(readerName);
        Borrow[] borrows = this.getAll();
        
        for(Reader reader: readers){
            for(Borrow borrow : borrows){
                if(borrow.getReaderId().equals(reader.getId()))
                    borrowsToReturn.add(borrow);
            }
        }
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
    /**
     * gets the borrows that contains both the reader name and the book title searched
     * @param bookTitle
     * @param readerName
     * @return 
     */
    public Borrow[] getBorrowsByBookAndReader(String bookTitle, String readerName) {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        Reader[] readers = new ReaderController().getReadersByName(readerName);
        Borrow[] borrows = this.getAll();
        Book [] books = new BookController().getBooksByTitle(bookTitle);
        
        
        for(Borrow borrow: borrows){
            for(Book book : books){
                if(borrow.getBookId().equals(book.getId())){
                    for(Reader reader : readers){
                        if(borrow.getReaderId().equals(reader.getId())){
                            borrowsToReturn.add(borrow);
                        }
                    }
                }    
            }
        }
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
    /**
     * calls the file handle to create a new borrow and make the book unavailable
     * and refreshes the memory
     * @param readerId
     * @param bookId
     * @throws IOException
     * @throws InvalidFileException 
     */
    public void addNewBorrow(String readerId, String bookId) throws IOException, InvalidFileException {
        Borrow borrow = new Borrow(java.util.UUID.randomUUID().toString(),readerId, bookId, DateFormatUtil.today(), null);
        add(borrow);
        new AvailabilityController().decrease(bookId);
        loadFile();
    }
    /**
     * calls the file handler edit the line to return the book
     * updates the availability of the book 
     * refreshes the memory
     * @param borrowId
     * @throws IOException
     * @throws InvalidFileException 
     */
    public void returnBook(String borrowId) throws IOException, InvalidFileException {
        Borrow b = ModelsInMemory.getBorrowById(borrowId);
        b.setReturnDate(DateFormatUtil.today());
        getFileHandler().editLine(b);
        new AvailabilityController().increase(b.getBookId());
        loadFile();
    }
    /**
     * return the borrows for a specific reader
     * @param readerId
     * @return 
     */
    public Borrow[] getBorrowsByReaderId(String readerId) {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        Borrow[] borrows = this.getAll();
        
        for(Borrow borrow : borrows){
            if(borrow.getReaderId().equals(readerId))
                borrowsToReturn.add(borrow);
        }
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
    /**
     * returns whether the reader already have the book so it won't be able to be added in the queue for the same book
     * @param bookId
     * @param readerId
     * @return 
     */
    boolean readerAlreadyWithBook(String bookId, String readerId) {
        for(Borrow b : getAll()){
            if(b.getBookId().equals(bookId)&&b.getReaderId().equals(readerId)&&b.getReturnDate()==null)
                return true;
        }
        return false;
    }
}



