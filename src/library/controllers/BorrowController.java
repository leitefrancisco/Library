/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import library.io.BaseFileHandler;
import library.io.BorrowFileHandler;
import library.models.Book;
import library.models.Borrow;
import library.utils.DateFormatUtil;
import library.utils.InvalidFileException;

/**
 *
 * @author Xiquinho
 */
public class BorrowController extends BaseController<Borrow>{
    
    @Override
    public Borrow[] loadFile() throws InvalidFileException, IOException {
        Borrow[] b = getFileHandler().readFile();
        ModelsInMemory.setBorrows(b);
        return getAll();
    }
    
    @Override
    public Borrow[] getAll() {
        return ModelsInMemory.getBorrows();
    }
    
    @Override
    protected BaseFileHandler<Borrow> getFileHandler() {
        return new BorrowFileHandler();
    }
    
    public Borrow[] getBorrowsToReturn() {
        return ModelsInMemory.getBorrowsToReturn();
    }
    
    private Borrow[] getBorrowsByBookId(String bookId){
        return ModelsInMemory.getBorrowsByBookId(bookId);
    }
    
    public Borrow[] getBorrowsByBookTitle(String text) {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        Book [] books = new BookController().getBooksByTitle(text);
        Borrow[] borrows = this.getAll();
        
        
        for(Book book : books){
            for(Borrow borrow : borrows){
                if(borrow.getBookId().equals(book.getId()))
                    borrowsToReturn.add(borrow);
            }
        }
        
        
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
    
    public Borrow[] getBorrowsByReaderName(String text) {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
    
    public Borrow[] getBorrowsByBookAndReader(String text, String text0) {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        Book [] books = new BookController().getBooksByTitle(text);
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
    
    /*
    Borrow borrow = new Borrow("",readerId, book.getId(), null, null);
    try {
    bc.addNewBorrow(borrow);
    */
    
    public void addNewBorrow(String readerId, String bookId) throws IOException, InvalidFileException {
        Borrow borrow = new Borrow(java.util.UUID.randomUUID().toString(),readerId, bookId, DateFormatUtil.today(), null);
        add(borrow);
        new AvailabilityController().decrease(bookId);
        loadFile();
    }
    
    public void returnBook(String borrowId) throws IOException, InvalidFileException {
        Borrow b = ModelsInMemory.getBorrowById(borrowId);
        b.setReturnDate(DateFormatUtil.today());
        getFileHandler().editLine(b);
        new AvailabilityController().increase(b.getBookId());
        loadFile();
        
    }
    
    public Borrow[] getBorrowsByReaderId(String readerId) {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        Borrow[] borrows = this.getAll();
        
        for(Borrow borrow : borrows){
            if(borrow.getReaderId().equals(readerId))
                borrowsToReturn.add(borrow);
        }
        
        
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
    
    
    
    
    
    
    
    
    
}
//    public BorrowController() {
//
//    }
//
//    public Borrow [] getBorrows(Book[] books, Reader[] readers) throws ParseException, UnsupportedEncodingException, IOException{
//        FileHandler fh = new FileHandler();
//        return fh.csvBorrowReader(books,readers);
//    }
//
//    public boolean writeBorrow(String readerId, Book book) throws IOException, ParseException{
//
//
//
//        FileHandler fh = new FileHandler();
//
//        Borrow b = new Borrow(
//                "",
//                ModelsInMemory.getReaderById(readerId),
//                book, DateFormatUtil.today(),
//                null);
//        if(ModelsInMemory.getBorrows().length==0){
//            b.setId("1");
//        }
//        else{
//            int id = ModelsInMemory.getBorrows().length+1;
//            b.setId(String.valueOf(id));
//        }
//        fh.addBorrow(b);
//
//        return false;
//    }
//
//
//
//    public void editBorrow(Borrow borrow) throws IOException, ParseException {
//        FileHandler fh = new FileHandler();
//
//        borrow.setReturnDate(DateFormatUtil.today());
//        // decrease availability
//        // get avaialablility of borrow.getBookId()
//        // fhav.editAvailability(avaialablility)
//
//        fh.editBorrow(borrow);
//
//    }


