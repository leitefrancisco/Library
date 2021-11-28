/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controllers;

import java.io.IOException;
import library.io.BaseFileHandler;
import library.io.BookFileHandler;
import library.models.Availability;
import library.models.Book;
import library.utils.InvalidFileException;


public class BookController extends BaseController<Book> {

    @Override
    public Book[] loadFile() throws InvalidFileException, IOException {
        
       Book[] books = getFileHandler().readFile();
       

       
       ModelsInMemory.setBooks(books);
       
       return getAll();
    }

    @Override
    protected BaseFileHandler<Book> getFileHandler() {
        return new BookFileHandler();
    }

    @Override
    public Book[] getAll() {
        return ModelsInMemory.getBooks();
    }

    public String[] getGenres() {
        return ModelsInMemory.getGenres();
    }

    public Book[] getBooksByTitle(String title) {
        return ModelsInMemory.getBooksByTitle(title);
    }

    public Book[] getBooksByAuthor(String author) {
        return ModelsInMemory.getBooksByAuthor(author);
    }

    public Book[] getBooksByGenre(String selectedGenre) {
        return ModelsInMemory.getBooksByGenre(selectedGenre);
    }

    public Book getBookById(String bookId) {
        return ModelsInMemory.getBookById(bookId);
    }

    

    
}