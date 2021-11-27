/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import library.models.Book;
import library.models.Borrow;
import library.models.Reader;
import library.utils.DateFormatUtil;

/**
 *
 * @author f.meireles
 */
public class FileHandler {
    
//    public FileHandler(){
//        
//    }
//    
//    public Book[] csvBookReader() throws FileNotFoundException, IOException {
//        
//        ArrayList<Book> books = new ArrayList<>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("MOCK_DATA.csv"),"UTF-8"));
//        
//        String line = null;
//        
//        br.readLine();
//        
//        while ((line = br.readLine()) != null) {
//            
//            ArrayList <String> genreList = new ArrayList<>();
//            
//            String[] data = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
//            
//            
//            String id = data[0];
//            String authorFirstName = data[1];
//            String authorLastName = data[2];
//            String title = data[3].replace("\"", "");
//            String [] genres = data[4].split("\\|");
//            
//            
//            
//            
//            
//            
//            Book book = new Book(id,0,authorFirstName, authorLastName, title, genres);
//            books.add(book);
//        }
//        return csvReadAvailability(books.toArray(new Book[books.size()]));
//    }
//    
//    private Book[] csvReadAvailability(Book[] books) throws UnsupportedEncodingException, FileNotFoundException, IOException{
//        
//        BufferedReader brAmt = new BufferedReader(new InputStreamReader(new FileInputStream("Availability.csv"),"UTF-8"));
//        String lineAmt = null;
//        
//        while((lineAmt = brAmt.readLine()) != null){
//            
//            String[] amtFile = lineAmt.split(",");
//            
//            Book book = Book.findBook(amtFile[0], books);
//            if(book !=null){
//                book.setAmount(Integer.parseInt(amtFile[1]));
//            }
//            // load queue
////                book.setQueue(Queue.load(amtFile[2]));
//            
//        }
//        return books;
//        
//    }
//    
//    public void csvNewReaderWriter(Reader reader) throws IOException{
//        File file = new File("Readers.csv");
//        
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
//        String line = null;
//        br.readLine();
//        String id="";
//        
//        while ((line = br.readLine()) != null) {
//            
//           
//            
//            String[] data = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
//            id = data[0];
//            
//        }
//        br.close();
//        
//        int intId = 0;
//        if(!id.equals("")){
//            intId = Integer.parseInt(id);
//        }
//        
//        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
//        bw.write((intId+1)+ "," + reader.getFirstName()+ "," + reader.getLastName() + ",\"" + reader.getAddress()+"\","+"1");
//        bw.newLine();
//        bw.close();
//    }
//    
//    public Reader[] csvReaderReader() throws IOException {
//        ArrayList<Reader> readers = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("readers.csv"),"UTF-8"));
//        String line = null;
//        reader.readLine();
//        while ((line = reader.readLine()) != null) {
//            
//            String[] data = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
//            String id = data[0];
//            String readerFirstName = data[1];
//            String readerLastName = data[2];
//            String address = data[3];
//            String active = data[4];
//            
//            
//            Reader r = new Reader(id,readerFirstName, readerLastName,address,active);
//            readers.add(r);
//            
//        }
//        return readers.toArray(new Reader[readers.size()]);
//    }
//    
//    public Borrow[] csvBorrowReader(Book[]books ,Reader[]readers) throws ParseException, FileNotFoundException, UnsupportedEncodingException, IOException{
//        
//        ArrayList<Borrow> borrows = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Borrows.csv"), "UTF-8"));
//        String line = null;
//        reader.readLine();
//        
//        while ((line = reader.readLine()) != null) {
//            
//            String[] data = line.split(",", 10);
//            
//            String id = data[0];
//            int readerId = Integer.parseInt(data[1]);
//            String bookId = data[2];
//            
//            
//            Reader r = null;
//            
//            for(int i = 0; i<readers.length;i++){
//                if(Integer.parseInt(readers[i].getId())==readerId){
//                    r=readers[i];
//                    break;
//                }
//            }
//            Book book = null;
//            for(int i = 0; i<books.length;i++){
//                if(books[i].getId().equalsIgnoreCase(bookId)){
//                    book = books[i];
//                    break;
//                }
//            }
//            System.out.println(data[4]);
//            Date borrowDate = DateFormatUtil.fromString(data[3]);
//            Date returnDate = DateFormatUtil.fromString(data[4]);
//            Borrow b = new Borrow(id,r, book,borrowDate,returnDate);
//            borrows.add(b);
//            
//            
//            
//            
//        }
//        return borrows.toArray(new Borrow[borrows.size()]);
//    }

//    private void writeBorrows(Borrow[] borrows) throws IOException {
//        
//        File file = new File("Borrows.csv");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
//        
//        
//        
//        
//        bw.write("borrow_id,reader_id,book_id,borrow_date,return_date");
//        
//        
//        bw.newLine();
//        for (Borrow borrow : borrows) {
//            bw.write(borrow.getId()+ "," + borrow.getReader().getId()+ "," + borrow.getBook().getId() + "," + DateFormatUtil.asString(borrow.getBorrowDate()) +"," + DateFormatUtil.asString(borrow.getReturnDate()) );
//            bw.newLine();
//        }
//        bw.close();
//    }
//    
//    public void addBorrow(Borrow borrow) throws IOException {
//        
//        File file = new File("Borrows.csv");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
//        
//        bw.write(borrow.getId()+ "," + borrow.getReader().getId()+ "," + borrow.getBook().getId() + "," + DateFormatUtil.asString(borrow.getBorrowDate()) +"," + DateFormatUtil.asString(borrow.getReturnDate()) );
//        bw.newLine();
//        
//        
//        bw.close();
//    }
//        
//    public void editBorrow(Borrow editedBorrow) throws IOException, ParseException {
//        
//        
//        
//        Book[] books = csvBookReader();
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
//    }
//        
//    private void addReader(Reader reader){
//        
//    }
    
}
