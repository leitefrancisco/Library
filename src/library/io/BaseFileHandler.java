/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.io;

import library.utils.InvalidFileException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import library.models.BaseModel;

/**
 * This class is the Generic File handler that will be used in the other objects respective file handlers
 * this class is responsible to read and edit the CSV files that are used as Database
 * @author Francisco
 * @param <T>
 */
public abstract class BaseFileHandler<T> {
   /**
    * this class will read any CSV and will return an Array of objects of the type that the controller requires
    * @return
    * @throws IOException
    * @throws InvalidFileException 
    */
    public T[] readFile() throws IOException, InvalidFileException{
        String fileName = getFileName();
        // if the file doesn't exist will create it based on the file name passed by the respective file handler
        if(!new File(fileName).exists()){
            writeFile(null);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
        String header = reader.readLine();
        validatedFile(header);
        // lemos os dados de determinado tipo T
         ArrayList<T> data = new ArrayList<>();
        String line = null;
         while ((line = reader.readLine()) != null) {
             //will get one element at a time because each File handle will split the line differently and 
             //and it was not possible to convert an arrayList of T into an array(it needs the type) so the solution was to get one object at a time 
             //and create a "caster" to transform the array list into an array of the desired object
            T elem = loadData(line);
            data.add(elem);
         }
        // fechamos os streams 
        reader.close();
        return castToArray(data);
    }
    /**
     * writes an array of objects into a file, used when editing a specific line of the file
     * @param elements
     * @throws IOException 
     */
    public void writeFile(T[] elements) throws IOException{
        File file = new File(getFileName());
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
        bw.write(getHeader());
        bw.newLine();
        if(elements!=null) {
            for (T e : elements) {
                bw.write(getCsvLine(e));
                bw.newLine();
            }
        }
        bw.close();
    }
    /**
     * appends a new line at the end of the file with the object passed as a parameter
     * @param element
     * @throws IOException 
     */
    public void addNewLine(T element) throws IOException{
        File file = new File(getFileName());
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        bw.write(getCsvLine(element));
        bw.newLine();
        bw.close();
    }
    /**
     * validate the file by the header 
     * @param header
     * @throws InvalidFileException 
     */
    private void validatedFile(String header) throws InvalidFileException {
        String validHeader = getHeader();
        
        if(!header.equals(validHeader)){
            throw new InvalidFileException(getFileName());
        }
    }
    /**
     * edits a specific line in the file.
     * Reads the entire file and saves the data inside an array , edit the file in the for loop based in the id 
     * (this method is the reason why the class BASE MODEL was created, this way it is possible to compare objects by their ID)
     * and then write the whole file in the CSV again
     * @param element
     * @throws IOException
     * @throws InvalidFileException 
     */
    public void editLine(T element) throws IOException, InvalidFileException{
       
        T[] elements =  readFile();
        
        for (int i = 0; i < elements.length; i++) {
            if(((BaseModel)element).getId().equals(((BaseModel)elements[i]).getId())){
               elements[i] = element; 
            }
        }  
        writeFile(elements);
    }
    /**
     * gets the CSV Line of the object to write it correctly in the CSV File
     * @param element
     * @return 
     */
    protected abstract String getCsvLine(T element);
    /**
     * method to get the header in order to use it to validate the file
     * @return 
     */
    protected abstract String getHeader();
    /**
     * abstract method, each file handler will deal with the loadFile method differently 
     * to load the file
     * @param line
     * @return 
     */
    protected abstract T loadData(String line);
    /**
     * gets the file name from the determined file handler to use in the write/load and edit the file
     * @return 
     */
    protected abstract String getFileName();
    /**
     * returns the Generic Array casted as the object required so when we read the file in the read data method 
     * it returns a array of specific objects instead a generic array
     * @param data
     * @return 
     */    
    protected abstract T[] castToArray(ArrayList<T> data);    
}
