/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.tableModels;

import javax.swing.table.AbstractTableModel;
import library.controllers.BookController;
import library.controllers.ReaderController;
import library.models.Book;
import library.models.Borrow;
import library.utils.DateFormatUtil;

/**
 *
 * @author Xiquinho
 */
public class BorrowsTableModel extends AbstractTableModel{
        //https://docs.oracle.com/javase/tutorial/uiswing/components/table.html#data
    
    //method to get image, title, genre and director in the rent frame
    
    private String[] columnNames = {"Book","Reader Name","Borrow Date","Returned date","Borrow"};
    private Borrow[] borrows;
    

    public BorrowsTableModel(Borrow[] borrows) {
        this.borrows = borrows;
    }
    
    public Borrow[] getBorrows(){
        return this.borrows;
    }

    public void setBorrows(Borrow[] borrows) {
        this.borrows = borrows;
    }
    
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    @Override
    public int getRowCount() {
          return borrows.length;
    }
    
    @Override
    public int getColumnCount() {
       return columnNames.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //switch to return title, genre and director in the rent frame
        Borrow borrow = borrows[rowIndex];
        switch (columnIndex){
            case 0: {
                return  new BookController().getBookById(borrow.getBookId()).getTitle();
            }
            case 1:{
                return new ReaderController().getReaderById(borrow.getReaderId()).getFullName();
            }
            case 2:{
                return DateFormatUtil.asString(borrow.getBorrowDate());
            }
            case 3:{
               if(borrow.getReturnDate()==null){
                    return "Not Returned";
                }
                else{
                    return DateFormatUtil.asString(borrow.getReturnDate());
                }
            }
            case 4:{
                return borrow;
            }
            
        }
        return null;
    }
}
