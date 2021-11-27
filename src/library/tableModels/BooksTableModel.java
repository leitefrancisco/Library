/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.tableModels;

import javax.swing.table.AbstractTableModel;
import library.controllers.AvailabilityController;
import library.models.Book;

/**
 *
 * @author f.meireles
 */
public class BooksTableModel extends AbstractTableModel {
    //https://docs.oracle.com/javase/tutorial/uiswing/components/table.html#data
    
    //method to get image, title, genre and director in the rent frame
    
    private String[] columnNames = {"Title --A-Z-- ","Author --A-Z-- ","Genre","Amount Available","id","movie"};
    private Book[ ] books;
    

    public BooksTableModel(Book[] books) {
        this.books = books;
    }
    
    public Book[] getBooks(){
        return this.books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
    
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    @Override
    public int getRowCount() {
          return books.length;
    }
    
    @Override
    public int getColumnCount() {
       return columnNames.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //switch to return title, genre and director in the rent frame
        Book book = books[rowIndex];
        switch (columnIndex){
            case 0: {
                return book.getTitle();
            }
            case 1:{
                return book.getAuthorFullName();
            }
            case 2:{
                String toReturn = " | ";
                for(String s : book.getGenres()){
                    toReturn += "  "+s+"  |";
                }
                return toReturn;
            }
            case 3:{
                return new AvailabilityController().getById(book.getId()).getAmount();
            }
            case 4:{
                return book.getId();
            }
            case 5:{
                return book;
            }
            
        }
        return null;
    }
    
    
    
    
}