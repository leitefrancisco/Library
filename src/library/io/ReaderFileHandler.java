/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.io;

import java.util.ArrayList;
import library.models.Reader;

/**
 *This class takes care of the Reader File, based in the file Handler
 * @author Francisco
 */
public class ReaderFileHandler extends BaseFileHandler<Reader> {
    /**
     * returns the correct line to be written in the file
     * @param element
     * @return
     */
    @Override
    protected String getCsvLine(Reader element) {
        return element.getCsvLine();
    }
    /**
     * returns the head of the file to validate the file
     * @return
     */
    @Override
    protected String getHeader() {
        return "id,reader_first_name,reader_last_name,address,active_reader";
    }
    /**
     * this method will split the line and return one Reader object
     * @param line
     * @return
     */
    @Override
    protected Reader loadData(String line) {
        String[] data = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
        String id = data[0];
        String readerFirstName = data[1];
        String readerLastName = data[2];
        String address = data[3].replace("\"", "");
        String active = data[4];
        
        return new Reader(id,readerFirstName, readerLastName,address,active);
    }
    
    @Override
    protected String getFileName() {
        return "Readers.csv";
    }
    /**
     * cast an Array List and returns it as an Array
     * @param data
     * @return
     */
    @Override
    protected Reader[] castToArray(ArrayList<Reader> data) {
        return data.toArray(new Reader[data.size()]);
    }
    
    
    
    
}
