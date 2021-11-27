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
 * @author Xiquinho#
 * This base controller is used to tel
 * 
 */
public abstract class BaseController<T> {
    
    public abstract T[] loadFile() throws InvalidFileException, IOException;
    
    public void writeFile(T[] t) throws IOException{
        getFileHandler().writeFile(t);
    }
    
    public void add(T t) throws IOException {
        getFileHandler().addNewLine(t);
    }
    
    public void edit(T t) throws IOException, InvalidFileException {
        getFileHandler().editLine(t);
    }
    public abstract T[] getAll();
    
    protected abstract BaseFileHandler<T> getFileHandler();
    
}
