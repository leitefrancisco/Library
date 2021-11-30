/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.io;

import java.util.ArrayList;
import library.models.Book;

/**
 *This class takes care of the Book File, based in the file Handler
 * @author Francisco
 */
public class BookFileHandler extends BaseFileHandler<Book> {
    /**
     * returns the correct line to be written in the file
     * @param element
     * @return 
     */
    @Override
    protected String getCsvLine(Book element) {
        return element.getCsvLine();
    }
     /**
     * returns the head of the file to validate the file
     * @return 
     */
    @Override
    protected String getHeader() {
        return "id,author_first_name,author_last_name,book_title,genre";
    }
    /**
     * this method will split the line and return one Book object
     * @param line
     * @return 
     */
    @Override
    protected Book loadData(String line) {
        
        String[] data = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
        String id = data[0];
        String authorFirstName = data[1];
        String authorLastName = data[2];
        String title = data[3].replace("\"", "");
        String [] genres = data[4].split("\\|");
        return new Book(id,0,authorFirstName, authorLastName, title, genres);
    }
    /**
     * returns the name of the file so the base file handler will handle the correct
     * CSV File
     * @return 
     */
    @Override
    protected String getFileName() {
        return "MOCK_DATA.csv";
    }
    /**
     * cast an Array List and returns it as an Array
     * @param data
     * @return 
     */
    @Override
    protected Book[] castToArray(ArrayList<Book> data) {
        return data.toArray(new Book[data.size()]);
    }
    
}
