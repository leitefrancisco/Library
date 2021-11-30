/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.controllers;

import java.io.IOException;
import library.io.BaseFileHandler;
import library.utils.InvalidFileException;

/**
 *
 * @author Francisco
 * This is a generic base controller is used as a base controller to avoid writing the same code over and over again
 * it is used to tell the classes that extends from it what methods will be necessary to edit the files that keeps the data of the system.
 * This class is used to call the File Handlers which is our Database, respecting the MVC Approach, the views will call the controllers and the
 * controllers will call the file handlers which would be one of our models
 * 
 */
public abstract class BaseController<T> {
    /**
     * this method will return the object of the controller that is using it,by calling its respective File Handler, for example if the 
     * BookController is using the method it will call the Book File Handler,  load the CSV and return an Array of Books
     * each Controller will determine how this method will be handle
     * @return
     * @throws InvalidFileException
     * @throws IOException 
     */
    public abstract T[] loadFile() throws InvalidFileException, IOException;
    /**
     * this method will be used to call the file handler method and will pass the objects to be written in the file
     * @param element
     * @throws IOException 
     */
    public void writeFile(T[] element) throws IOException{
        getFileHandler().writeFile(element);
    }
    /**
     * calls the respective file handle and the method to add a new line to the CSV
     * @param element
     * @throws IOException 
     */
    public void add(T element) throws IOException {
        getFileHandler().addNewLine(element);
    }
    /**
     * calls the respective file handler to edit a line in the CSV
     * @param element
     * @throws IOException
     * @throws InvalidFileException 
     */
    public void edit(T element) throws IOException, InvalidFileException {
        getFileHandler().editLine(element);
    }
    /**
     * abstract method to get all the objects of a determined type in the MODELS IN MEMORY Class, which is our cached memory
     * @return 
     */
    public abstract T[] getAll();
    /**
     * returns the respective file handler of a class
     * @return 
     */
    protected abstract BaseFileHandler<T> getFileHandler();
    
}
