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
    
    
    static Reader[] getReaders() {
        return readers;
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
    
    static Availability[] getAvailabilities() {
        return availabilities;
    }
    
    /**
     * availabilities has the same Id as their books so it is easy to find them having the book
     * this method will return the 
     * @param bookId
     * @return 
     */
    static Availability getAvailabity(String bookId) {
        for(Availability a : availabilities){
            if(a.getId().equals(bookId)){
                return a;
            }
        }
        return null;
    }
    
    /**
     * returns a reader by its Id 
     * @param id
     * @return 
     */
    static Reader getReaderById(String id){
        if(id==null) return null;
        
        for (Reader reader : readers) {
            if (reader.getId().equals(id)) {
                return reader;
            }
        }
        return null;
    }
    /**
     * returns one book by its ID
    */
    static Book getBookById(String bookId) {
        
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }
    /**
     *this method reads the genres from the books, saves it in a HashSet so there will be no duplicates
     * will save them to be used in the book search view so it is possible to nicely filter the books by their genres
     */
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
    /**
     * returns books if their titles contains the string passed as a parameter
     * @param title
     * @return 
     */
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
    /**
     * returns the books if their authors name contains the string passed as a parameter
     * @param author
     * @return 
     */
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
    /**
     * returns the books that contains the selected genre 
     * @param selectedGenre
     * @return 
     */
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
    
    /**
     * return the borrows that were not returned yet
     * @return 
     */
    static Borrow[] getBorrowsToReturn() {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        
        
        for (int i = 0; i<borrows.length; i++){
            if (borrows[i].getReturnDate()==null){
                borrowsToReturn.add(borrows[i]);
            }
        }
        
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
    /**
     * return the borrows of a specific reader
     * @param readerId
     * @return 
     */
    static Borrow[] getBorrowsByReaderId(String readerId) {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        
        
        for (int i = 0; i<borrows.length; i++){
            if (borrows[i].getReaderId().equals(readerId)){
                borrowsToReturn.add(borrows[i]);
            }
        }
        
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
    /**
     * return active readers
     * @return 
     */
    static Reader[] getActiveReaders() {
        ArrayList<Reader> activeReaders = new ArrayList<>();
        for (int i = 0; i < readers.length; i++) {
            if(readers[i].getActive().equals("1")){
                activeReaders.add(readers[i]);
            }
        }
        
        
        return activeReaders.toArray(new Reader[activeReaders.size()]);
    }
    /**
     * return only inactive readers
     * @return 
     */
    static Reader[] getInactiveReaders() {
        ArrayList<Reader> inactiveReaders = new ArrayList<>();
        for (int i = 0; i < readers.length; i++) {
            if(readers[i].getActive().equals("0")){
                inactiveReaders.add(readers[i]);
            }
        }
        
        return inactiveReaders.toArray(new Reader[inactiveReaders.size()]);
    }
    /**
     * get the borrows that contains a specific book
     * @param bookId
     * @return 
     */
    static Borrow[] getBorrowsByBookId(String bookId) {
        ArrayList<Borrow> borrowsToReturn = new ArrayList<>();
        
        
        for (int i = 0; i<borrows.length; i++){
            if (borrows[i].getBookId().equals(bookId)){
                borrowsToReturn.add(borrows[i]);
            }
        }
        
        return borrowsToReturn.toArray(new Borrow[borrowsToReturn.size()]);
    }
    /**
     * returns a borrow by its Id
     * @param borrowId
     * @return 
     */
    static Borrow getBorrowById(String borrowId) {
        for (int i = 0; i<borrows.length; i++){
            if (borrows[i].getId().equals(borrowId)){
                return borrows[i];
            }
        }
        
        return null;
    }
    /**
     * returns readers that contains the string searched in their name
     * @param readerName
     * @return 
     */
    static Reader[] getReadersByName(String readerName) {
        ArrayList<Reader> readersToReturn = new ArrayList<>();
        
        for (Reader r: readers) {
            if(r.getFullName().toLowerCase().contains(readerName.toLowerCase())){
                readersToReturn.add(r);
            }
        }
        return readersToReturn.toArray(new Reader[readersToReturn.size()]);
    }
}

