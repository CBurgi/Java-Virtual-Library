/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_of_books;
import java.util.ArrayList;

/**
 * Stores a lost of Books of at most 1000, along with the number of books stored.
 * 
 * @author CBurgi
 * 
 * @see Book
 */
public class Library {
    
    public Library(String name){
        setName(name);
    }
    
    private String name;
    
    /**
     * Sets the name of the given Library to the Sting passed in.
     * 
     * @param name  The name of the Library.
     * 
     * @see         Library
     * @see         getName()
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Returns the name of the given Library.
     * 
     * @return  String
     * 
     * @see     Library
     * @see     setName()
     */
    public String getName(){
        return this.name;
    }
    
    private ArrayList<Book> books = new ArrayList<>();
    
    /**
     * Adds a new book to a given Library.
     * Only adds book if the number of books in the library is less than 1000.
     * 
     * @param newBook   The book to be added.
     * 
     * @see             Library
     * @see             Book
     * @see             getNumBooks()
     * @see             searchByTitle()
     * @see             searchByAuthor()
     * @see             searchByMultipleAuthor()
     * @see             deleteByTitle()
     * @see             deleteByAuthor()
     * @see             deleteByMultipleAuthors()
     */
    public void addBook(Book newBook){
        //since i am using an array list, this makes sure the array will
        //not exeed the allowed book range
        if (books.size()<1000){
            books.add(newBook);
        }
        else System.out.println("Max number of books reached.");
    }
    
    /**
     * Returns the number of Books in a Library.
     * 
     * @return  int
     * 
     * @see     Library
     * @see     Book
     * @see     addBook()
     * @see     searchByTitle()
     * @see     searchByAuthor()
     * @see     searchByMultipleAuthor()
     * @see     deleteByTitle()
     * @see     deleteByAuthor()
     * @see     deleteByMultipleAuthors()
     */
    public int getNumBooks(){
        return books.size();
    }
    
    /**
     * Searches through a library of Books using linear search and returns all Books 
     * with a title matching the String passed in.
     * Ignores case when searching.
     * If no books are found that match the passed title, returns null.
     * 
     * @param search    The title that will be searched (String)
     * @return          Array of Books, or null.
     * 
     * @see             Library
     * @see             Book
     * @see             addBook()
     * @see             getNumBooks()
     * @see             searchByAuthor()
     * @see             searchByMultipleAuthor()
     * @see             deleteByTitle()
     * @see             deleteByAuthor()
     * @see             deleteByMultipleAuthors()
     */
    public Book[] searchByTitle(String search){
        ArrayList<Book> these = new ArrayList<>();
        
        //runs through all books in the library and checks their titles
        for(Book n: books){
            if(n.getTitle().equalsIgnoreCase(search))
                these.add(n);
        }
        if(these.isEmpty()){
            System.out.println("Sorry, no books were found with that title!");
            return null;
        }
        return these.toArray(Book[]::new);
        
    }
    
    /**
     * Searches through a library of Books using linear search and returns all Books 
     * with an Author matching the Author passed in.
     * If no books are found that match the passed Author, returns null.
     * 
     * @param search    The Author that will be searched.
     * @return          Array of Books, or null.
     * 
     * @see             Library
     * @see             Book
     * @see             addBook()
     * @see             getNumBooks()
     * @see             searchByTitle()
     * @see             searchByMultipleAuthor()
     * @see             deleteByTitle()
     * @see             deleteByAuthor()
     * @see             deleteByMultipleAuthors()
     */
    public Book[] searchByAuthor(Author search){
        ArrayList<Book> these = new ArrayList<>();
        
        //runs through all books in the library and checks their Authors
        for(Book n: books){
            for(Author a:n.getAuthors()){
                if(a.equals(search)){
                    these.add(n);
                }
            }
            
        }
        if(these.isEmpty()){
            System.out.println("Sorry, no books were found with that Author!");
            return null;
        }
        return these.toArray(Book[]::new);
        
    }
    
    /**
     * Searches through a library of Books using linear search and returns all Books 
     * which have all passed Authors attached to them.
     * If no books are found that have all passed Authors, returns null.
     * 
     * @param search    The Authors that will be searched.
     * @return          Array of Books, or null.
     * 
     * @see             Library
     * @see             Book
     * @see             addBook()
     * @see             getNumBooks()
     * @see             searchByTitle()
     * @see             searchByAuthor()
     * @see             deleteByTitle()
     * @see             deleteByAuthor()
     * @see             deleteByMultipleAuthors()
     */
    public Book[] searchByMultipleAuthors(Author[] search){
        ArrayList<Book> these = new ArrayList<>();
        
        //runs through all books in the library and checks their Authors
        for(Book n: books){
            int matchingAs = 0;
            for(Author a: search){
                for(Author b: n.getAuthors()){
                    if(b.equals(a)){
                        matchingAs ++;
                    }
                }
            }
            
            if(matchingAs == search.length){
                these.add(n);
            }
            
        }
        if(these.isEmpty()){
            System.out.println("Sorry, no books were found with that Author!");
            return null;
        }
        return these.toArray(Book[]::new);
        
    }
    
    /**
     * Searches through a library of Books using linear search and deletes all Books 
     * with a title matching the String passed in.
     * Ignores case when searching.
     * 
     * @param search    The title that will be searched (String)
     * 
     * @see             Library
     * @see             Book
     * @see             addBook()
     * @see             getNumBooks()
     * @see             searchByAuthor()
     * @see             searchByMultipleAuthor()
     * @see             deleteByAuthor()
     * @see             deleteByMultipleAuthors()
     */
    public void deleteByTitle(String search){
        
        //runs through all books in the library and checks their titles
        for(Book n: books){
            if(n.getTitle().equalsIgnoreCase(search))
                books.remove(n);
        }
        
    }
    
    /**
     * Searches through a library of Books using linear search and deletes all Books 
     * with an Author matching the Author passed in.
     * If no books are found that match the passed Author, returns null.
     * 
     * @param search    The Author that will be searched.
     * 
     * @see             Library
     * @see             Book
     * @see             addBook()
     * @see             getNumBooks()
     * @see             searchByTitle()
     * @see             searchByMultipleAuthor()
     * @see             deleteByTitle()
     * @see             deleteByMultipleAuthors()
     */
    public void deleteByAuthor(Author search){
        //runs through all books in the library and checks their Authors
        for(Book n: books){
            for(Author a:n.getAuthors()){
                if(a.equals(search)){
                    books.remove(n);
                }
            }
            
        }
    }
    
    /**
     * Searches through a library of Books using linear search and deletes all Books 
     * which have all passed Authors attached to them.
     * If no books are found that have all passed Authors, returns null.
     * 
     * @param search    The Authors that will be searched.
     * 
     * @see             Library
     * @see             Book
     * @see             addBook()
     * @see             getNumBooks()
     * @see             searchByTitle()
     * @see             searchByAuthor()
     * @see             deleteByTitle()
     * @see             deleteByAuthor()
     */
    public void deleteByMultipleAuthors(Author[] search){
        //runs through all books in the library and checks their Authors
        for(Book n: books){
            int matchingAs = 0;
            for(Author a: search){
                for(Author b: n.getAuthors()){
                    if(b.equals(a)){
                        matchingAs ++;
                    }
                }
            }
            
            if(matchingAs == search.length){
                books.remove(n);
            }
            
        }
    }
    
}
