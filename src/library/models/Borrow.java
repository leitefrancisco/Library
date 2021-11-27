/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models;

import java.util.Date;
import library.utils.DateFormatUtil;

/**
 *
 * @author Xiquinho
 */
public class Borrow extends BaseModel{
    private String readerId;
    private String bookId;
    private Date borrowDate;
    private Date returnDate;
    
    public Borrow(String id, String readerId, String bookId, Date borrowDate, Date returnDate) {
        super(id);
        this.readerId = readerId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

   
    

   

    public String getReaderId() {
        return readerId;
    }

    public String getBookId() {
        return bookId;
    }
    
    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return "Borrow{" + "id=" + getId() + ", reader=" + readerId + ", book=" + bookId + ", borrowDate=" + borrowDate + ", returnDate=" + returnDate + '}';
    }

    public void setReturnDate(Date date) {
        this.returnDate = date;
    }
       // borrow_id,reader_id,book_id,borrow_date,return_date
    public String getCsvLine() {
        return getId()+","+readerId+","+bookId+","+DateFormatUtil.asString(borrowDate)+","+DateFormatUtil.asString(returnDate);
    }

    public void setBorrowDate(Date today) {
        this.borrowDate = today;
    }
    
    
    
    
}
