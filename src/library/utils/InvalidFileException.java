/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.utils;

/**
 *This class is an exception that validates the file that the file handlers will deal with when writing and reading information 
 * @author Francisco
 */
public class InvalidFileException extends Exception {

    public InvalidFileException(String fileName) {
        
        super("The file "+fileName+ " is not valid");
        
    }
}