/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.io;

import java.util.ArrayList;
import library.models.Reader;

/**
 *
 * @author Xiquinho
 */
public class ReaderFileHandler extends BaseFileHandler<Reader> {

    @Override
    protected String getCsvLine(Reader t) {
       return t.getCsvLine();
    }

    @Override
    protected String getHeader() {
        return "id,reader_first_name,reader_last_name,address,active_reader";
    }

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

    @Override
    protected Reader[] castToArray(ArrayList<Reader> data) {
        return data.toArray(new Reader[data.size()]);
    }
    
    
    
    
}
