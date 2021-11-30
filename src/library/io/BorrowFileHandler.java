/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.io;

import java.util.ArrayList;
import java.util.Date;
import library.models.Borrow;
import library.utils.DateFormatUtil;

/**
 *This class takes care of the Borrow File, based in the file Handler
 * @author Francisco
 */
public class BorrowFileHandler extends BaseFileHandler<Borrow>{
    /**
     * returns the correct line to be written in the file
     * @param element
     * @return 
     */
    @Override
    protected String getCsvLine(Borrow element) {
        return element.getCsvLine();
    }
    /**
     * returns the head of the file to validate the file
     * @return 
     */
    @Override
    protected String getHeader() {
        return"borrow_id,reader_id,book_id,borrow_date,return_date";
    }
    /**
     * this method will split the line and return one Borrow object
     * @param line
     * @return 
     */
    @Override
    protected Borrow loadData(String line) {
                
        String[] data = line.split(",", 10);
            
            String id = data[0];
            String readerId = data[1];
            String bookId = data[2];
            Date borrowDate = DateFormatUtil.fromString(data[3]);
            Date returnDate = DateFormatUtil.fromString(data[4]);
            return new Borrow(id,readerId, bookId,borrowDate,returnDate);
    }
    /**
     * returns the name of the file so the base file handler will handle the correct
     * CSV File
     * @return 
     */
    @Override
    protected String getFileName() {
        return"Borrows.csv";
    }
    /**
     * cast an Array List and returns it as an Array
     * @param data
     * @return 
     */
    @Override
    protected Borrow[] castToArray(ArrayList<Borrow> data) {
        return data.toArray(new Borrow[data.size()]);
    }
    
}
