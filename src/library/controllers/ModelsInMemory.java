/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package library.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import library.models.Availability;
import library.models.Book;
import library.models.Borrow;
import library.models.Reader;

/**
 *
 * @author f.meireles
 */
class ModelsInMemory {
    
    private static Book[] books;
    private static String[] genres;
    private static Reader[] readers;
    private static Borrow[] borrows;
    private static Availability[] availabilities;
    
    
    static void setBooks(Book[] b) {
        books = b;
        populateBookGenres();
    }
    
    static void setReaders(Reader[] r) {
        readers = r;
    }
    
    static void setBorrows(Borrow[] b) {
        borrows = b;
    }
    
    static void setAvailabilities(Availability[] a) {
        availabilities = a;
    }
    
    static Availability getAvailabity(String bookId) {
        for(Availability a : availabilities){
            if(a.getId().equals(bookId)){
                return a;
            }
        }
        return null;
    }
    
    static Availability[] getAvailabilities() {
        return availabilities;
    }
    
    
    static Reader getReaderById(String id){
        if(id==null) return null;
        
        for(int i = 0; i<readers.length;i++){
            if (readers[i].getId().equals(id)){
                return readers[i];
            }
        }
        return null;
    }
    static Book getBookById(String bookId) {
        
        for(int i = 0; i<books.length;i++){
            if (books[i].getId().equals(bookId)){
                return books[i];
            }
        }
        return null;
    }
    
    static void populateBookGenres(){
        
        HashSet<String> genresSet = new HashSet<>();
        
        for(Book b: books){
            String [] genres = b.getGenres();
            for (int i = 0 ; i<genres.length ;i++){
                genresSet.add(genres[i]);
            }
        }
        
        String[] sortedArray = new String[genresSet.size()+1];
        genresSet.toArray(sortedArray);
        
        
        sortedArray[sortedArray.length-1] = sortedArray[0];
        
        sortedArray[0]="Select Genre";
        
        for (int i = 2; i<sortedArray.length; i++){
            
            String key = sortedArray[i];
            int pos = i;
            
            while(pos > 1 && sortedArray[pos-1].compareToIgnoreCase(key) > 0){
                sortedArray[pos]=sortedArray[pos-1];
                pos --;
            }
            sortedArray[pos]=key;
        }
        
        genres = sortedArray;
        
    }
    
    
    static Book[] getBooks() {
        return books;
    }
    static String[] getGenres(){
        return genres;
    }
    
    static Borrow[] getBorrows(){
        return borrows;
    }
    
    
    
    
    static Book[] getBooksByTitle(String title) {
        ArrayList<Book> resultBooks = new ArrayList<>();
        
        
        for (int i = 0 ; i<books.length ; i++){
            
            Book b = books[i];
            
            if(b.getTitle().toLowerCase().contains(title.toLowerCase().trim())){
                
                resultBooks.add(b);
            }
        }
        return resultBooks.toArray(new Book[resultBooks.size()]);
    }
    
    static Book[] getBooksByAuthor(String author) {
        
        ArrayList<Book> resultBooks = new ArrayList<>();
        
        for (int i = 0 ; i<books.length ; i++){
            
            Book b = books[i];
            
            if(b.getAuthorFullName().toLowerCase().contains(author.toLowerCase().trim())){
                
                resultBooks.add(b);
            }
        }
        return resultBooks.toArray(new Book[resultBooks.size()]);
    }
    
    static Book[] getBooksByGenre(String selectedGenre) {
        ArrayList<Book> resultBooks = new ArrayList<>();
        
        
        for (int i = 0 ; i<books.length ; i++){
            boolean containsGenre = false;
            ArrayList <String> genres =  new ArrayList<>(Arrays.asList(books[i].getGenres()));
            
            
            if(genres.contains(selectedGenre)){
                resultBooks.add(books[i]);
            }
            
            
        }
        return resultBooks.toArray(new Book[resultBooks.size()]);
    }
    
    static Reader[] getReaders() {
        return readers;
    }
    
    static Borrow[] getBorrowsToReturn() {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        
        
        for (int i = 0; i<borrows.length; i++){
            if (borrows[i].getReturnDate()==null){
                borrowsToReturn.add(borrows[i]);
            }
        }
        
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
    
//    static Borrow[] getBorrowsByBookTitle(String title) {
//
////        for (int i = 0; i<borrows.length; i++){
////            if (borrows[i].getBookId().getTitle().toLowerCase().contains(title.toLowerCase())){
////                borrowsToReturn.add(borrows[i]);
////            }
////        }
//
//        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
//    }
//
//    static Borrow[] getBorrowsByReaderName(String readerName) {
//        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
//
//
//        for (int i = 0; i<borrows.length; i++){
//            if (borrows[i].getReaderId().getFullName().toLowerCase().contains(readerName.toLowerCase())){
//                borrowsToReturn.add(borrows[i]);
//            }
//        }
//
//        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
//    }
//
//    static Borrow[] getBorrowsByBookAndReader(String bookTitle, String readerName) {
//        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
//
//
//        for (int i = 0; i<borrows.length; i++){
//            if (borrows[i].getBookId().getTitle().toLowerCase().contains(bookTitle.toLowerCase()) && borrows[i].getReaderId().getFullName().toLowerCase().contains(readerName.toLowerCase())){
//                borrowsToReturn.add(borrows[i]);
//            }
//        }
//
//        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
//    }
    
    static Borrow[] getBorrowsByReaderId(String readerId) {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        
        
        for (int i = 0; i<borrows.length; i++){
            if (borrows[i].getReaderId().equals(readerId)){
                borrowsToReturn.add(borrows[i]);
            }
        }
        
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
    
    static Reader[] getActiveReaders() {
        ArrayList<Reader> activeReaders = new ArrayList<>();
        for (int i = 0; i < readers.length; i++) {
            if(readers[i].getActive().equals("1")){
                activeReaders.add(readers[i]);
            }
        }
        
        
        return activeReaders.toArray(new Reader[activeReaders.size()]);
    }
    
    static Reader[] getInactiveReaders() {
        ArrayList<Reader> inactiveReaders = new ArrayList<>();
        for (int i = 0; i < readers.length; i++) {
            if(readers[i].getActive().equals("0")){
                inactiveReaders.add(readers[i]);
            }
        }
        
        return inactiveReaders.toArray(new Reader[inactiveReaders.size()]);
        
        
    }
    
    static Borrow[] getBorrowsByBookId(String bookId) {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        
        
        for (int i = 0; i<borrows.length; i++){
            if (borrows[i].getBookId().equals(bookId)){
                borrowsToReturn.add(borrows[i]);
            }
        }
        
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
    
    static Borrow getBorrowById(String borrowId) {
        for (int i = 0; i<borrows.length; i++){
            if (borrows[i].getId().equals(borrowId)){
                return borrows[i];
            }
        }
        
        return null;
    }
    
    
    
    
    
    
    
}
//    public static Reader[] getQueueOfBook(String bookId){
//        ArrayList<Reader> readers = new ArrayList<>();
//        Book book = getBookById(bookId);
//
//        Queue queue = book.getQueue();
//        if(queue==null){
//            return readers.toArray(new Reader[readers.size()]);
//        }
//
//        Reader current=null;
//        do {
//            current = getReaderById(queue.Dequeue());
//            if(current!=null){
//                readers.add(current);
//            }
//        }while(current!=null);
//
//        if(book.getQueue().First()==null){
//            System.out.println("Fodeu");
//        }
//
//
//        return readers.toArray(new Reader[readers.size()]);
//    }


