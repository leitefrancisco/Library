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
 *
 * @author Xiquinho
 */
public class BorrowFileHandler extends BaseFileHandler<Borrow>{

    @Override
    protected String getCsvLine(Borrow t) {
        return t.getCsvLine();
    }

    @Override
    protected String getHeader() {
        return"borrow_id,reader_id,book_id,borrow_date,return_date";
    }

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

    @Override
    protected String getFileName() {
        return"Borrows.csv";
    }

    @Override
    protected Borrow[] castToArray(ArrayList<Borrow> data) {
        return data.toArray(new Borrow[data.size()]);
    }
    
}
