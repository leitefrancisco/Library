/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.io;

import java.util.ArrayList;
import library.models.Book;

/**
 *
 * @author Xiquinho
 */
public class BookFileHandler extends BaseFileHandler<Book> {
    
    @Override
    protected String getCsvLine(Book t) {
        return t.getCsvLine();
    }
    
    @Override
    protected String getHeader() {
        return "id,author_first_name,author_last_name,book_title,genre";
    }
    
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
    
    @Override
    protected String getFileName() {
        return "MOCK_DATA.csv";
    }
    
    @Override
    protected Book[] castToArray(ArrayList<Book> data) {
        return data.toArray(new Book[data.size()]);
    }
    
}
