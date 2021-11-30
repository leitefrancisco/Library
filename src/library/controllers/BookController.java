/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controllers;

import java.io.IOException;
import library.io.BaseFileHandler;
import library.io.BookFileHandler;
import library.models.Book;
import library.utils.InvalidFileException;

/**
 *This class is the controller for the Book model , it will take the requests from the view to get
 * the objects in the model and will call the file handler to save the objects in the cache memory (Models In Memory)
 * @author Francisco
 */
public class BookController extends BaseController<Book> {
    /**
     * load the book CSV and save all the books in the cache memory (Models In Memory)
     * @return
     * @throws InvalidFileException
     * @throws IOException 
     */
    @Override
    public Book[] loadFile() throws InvalidFileException, IOException {
        
       Book[] books = getFileHandler().readFile();
       
       ModelsInMemory.setBooks(books);
       
       return getAll();
    }
    /**
     * returns the file handler responsible for the books
     * @return 
     */
    @Override
    protected BaseFileHandler<Book> getFileHandler() {
        return new BookFileHandler();
    }
    /**
     * return all the books in the cache
     * @return 
     */
    @Override
    public Book[] getAll() {
        return ModelsInMemory.getBooks();
    }
    /**
     * return all the genres that exists in the book CSV ( no duplicate )
     * @return 
     */
    public String[] getGenres() {
        return ModelsInMemory.getGenres();
    }
    /**
     * return a book by the title
     * @param title
     * @return 
     */
    public Book[] getBooksByTitle(String title) {
        return ModelsInMemory.getBooksByTitle(title);
    }
    /**
     * return a book by the author
     * @param author
     * @return 
     */
    public Book[] getBooksByAuthor(String author) {
        return ModelsInMemory.getBooksByAuthor(author);
    }
    /**
     * return an array of books by their genre
     * @param selectedGenre
     * @return 
     */
    public Book[] getBooksByGenre(String selectedGenre) {
        return ModelsInMemory.getBooksByGenre(selectedGenre);
    }
    /**
     * return a book by its Id
     * @param bookId
     * @return 
     */
    public Book getBookById(String bookId) {
        return ModelsInMemory.getBookById(bookId);
    }
}