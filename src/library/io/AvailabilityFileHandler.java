/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.io;

import java.util.ArrayList;
import library.models.Availability;

/**
 *This class takes care of the Availability File, based in the file Handler
 * @author Francisco
 */
public class AvailabilityFileHandler extends BaseFileHandler<Availability> {
    /**
     * returns the name of the file so the base file handler will handle the correct
     * CSV File
     * @return 
     */
    @Override
    protected String getFileName() {
        return "Availability.csv";
    }
    /**
     * returns the head of the file to validate the file
     * @return 
     */
    @Override
    protected String getHeader() {
        return "Book_Id,Amount_Available,queue";
    }
    /**
     * this method will split the line and return one availability object
     * @param line
     * @return 
     */
    @Override
    protected Availability loadData(String line) {
        String[] data = line.split(",", 10);
            String bookId = data[0];
            String amt = data[1];
            String queue = data[2];
            return new Availability(bookId, amt, queue);
    }
    /**
     * cast an Array List and returns it as an Array
     * @param data
     * @return 
     */
    @Override
    protected Availability[] castToArray(ArrayList<Availability> data) {
        return data.toArray(new Availability[data.size()]);
    }
    /**
     * returns the correct line to be written in the file
     * @param element
     * @return 
     */
    @Override
    protected String getCsvLine(Availability element) {
        return element.getCsvLine();
    }
    
}
