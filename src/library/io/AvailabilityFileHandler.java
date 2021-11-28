/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.io;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.models.Availability;

/**
 *
 * @author Xiquinho
 */
public class AvailabilityFileHandler extends BaseFileHandler<Availability> {

       

    @Override
    protected String getFileName() {
        return "Availability.csv";
    }

    @Override
    protected String getHeader() {
        return "Book_Id,Amount_Available,queue";
    }

    @Override
    protected Availability loadData(String line) {
        String[] data = line.split(",", 10);
            String bookId = data[0];
            String amt = data[1];
            String queue = data[2];
            return new Availability(bookId, amt, queue);
    }

    @Override
    protected Availability[] castToArray(ArrayList<Availability> data) {
        return data.toArray(new Availability[data.size()]);
    }

    @Override
    protected String getCsvLine(Availability t) {
        return t.getCsvLine();
    }
    
}
