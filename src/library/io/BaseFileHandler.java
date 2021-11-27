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
 *
 * @author Xiquinho
 * @param <T>
 */
public abstract class BaseFileHandler<T> {
    public T[] readFile() throws IOException, InvalidFileException{
        String fileName = getFileName();
        // se nao existe cria vazio
        if(!new File(fileName).exists()){
            writeFile(null);
        }
        // nome do arquivo
        // streams gerenicos
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
        String header = reader.readLine();
        validatedFile(header);
        // lemos os dados de determinado tipo T
         ArrayList<T> data = new ArrayList<>();
        String line = null;
         while ((line = reader.readLine()) != null) {
            T elem = loadData(line);
            data.add(elem);
         }
        // fechamos os streams 
        reader.close();
        
        return castToArray(data);
    }
    
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
    
    public void addNewLine(T t) throws IOException{
        File file = new File(getFileName());
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        bw.write(getCsvLine(t));
        bw.newLine();
        bw.close();
    }
    
    private void validatedFile(String header) throws InvalidFileException {
        String validHeader = getHeader();
        
        if(!header.equals(validHeader)){
            throw new InvalidFileException(getFileName());
        }
     
    }
    
    public void editLine(T t) throws IOException, InvalidFileException{
       T[] elements =  readFile();
        
//      Book[] books = csvBookReader();
//        Reader[] readers = csvReaderReader();
//        Borrow[] borrows = csvBorrowReader(books, readers);
//        Borrow[] newBorrows = new Borrow[borrows.length];
//        for(int i = 0; i< borrows.length ; i++){
//            Borrow b = borrows[i];
//            if( b.getId().equals(editedBorrow.getId())){
//                b = editedBorrow;
//            }
//            newBorrows[i] = b;
//        }
//        System.out.println("Borrows count: "+ newBorrows.length);
//        writeBorrows(newBorrows); 
        for (int i = 0; i < elements.length; i++) {
            if(((BaseModel)t).getId().equals(((BaseModel)elements[i]).getId())){
               elements[i] = t; 
            }
        }
            
        writeFile(elements);
    }

    
    protected abstract String getCsvLine(T t);
    protected abstract String getHeader();
    protected abstract T loadData(String line);
    protected abstract  String getFileName();
    protected abstract T[] castToArray(ArrayList<T> data);
    
   
    
}


//public class AvailabilityFileHandler extends BaseFileHandler<Availabity> {
//    protected Availabity[] loadData(BufferedReader br){
//        return null
//    }
//}
