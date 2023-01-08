/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_of_books;
import java.util.ArrayList;

/** 
 * Stores a title (String), a group of authors (Author), and the books contents (List of Strings). Can be added to a library.
 * 
 * @author  Cburgi
 * @version %I%, %G%
 * 
 * @see     Library
 * @see     Author
 */
public class Book {
    private static int num = 1;
    
    //Generec book
    public Book(){
        num++;
    }
    //Book with title
    public Book(String title){
        num++;
        
        setTitle(title);
    }
    //Book with title and author
    public Book(String title, Author author1){
        num++;
        
        setTitle(title);
        addAuthor(author1);
    }
    //sets id to the count of books
    public final int id = num;
    
    private String title = new String();
    private ArrayList<Author> authors = new ArrayList<Author>();
    private ArrayList<String> contents = new ArrayList<String>();
    
    /**
     * Sets the title of a book to one passed into the function.
     * Only sets title if string passes is greater than 4 and less than 51 characters.
     * If string passed does not meet thees requirements will set title to "No Title". 
     * 
     * @param title     The string that will be set to the title of the book
     * 
     * @see             Book
     * @see             setTitle()
     */
    
    public void setTitle(String title){
        //makes sure title is within allowed character range
        if( title.length()>=5 && title.length()<=50 )this.title = title;
        else this.title = "No Title";
    }
    
    /** 
     * Returns the title of a given book.
     * 
     * @return  String
     * 
     * @see     Book
     * @see     setTitle()
     */
    public String getTitle(){
        return title;
    }
    
    
    /**
     * Adds an author to the list of authors attached to a given book.
     * Only adds author if the book has less than 10 authors already attached to it.
     * 
     * @param newA  The author that will be added to the book.
     * 
     * @see         Author
     * @see         getAuthors()
     * @see         deleteAuthor()
     */
    public void addAuthor(Author newA){
        //since i am using an array list, this makes sure the array will
        //not exeed the allowed author range
        if (authors.size()<10){
            authors.add(newA);
        }
        else System.out.println("Max number of authors reached.");
        
    }
    
    /**
     * Removes the passed author if it is attached to the Book.
     * 
     * @param badA  The author to be deleted.
     * 
     * @see         Book
     * @see         addAuthor()
     * @see         getAuthors()
     */
    public void deleteAuthor(Author badA){
        for(Author a: authors){
            if(a.equals(badA)){
                authors.remove(a);
            }
        }
    }
    
    /**
     * Returns a list of Authors that is attached to a given book.
     * 
     * @return  List of Authors
     * 
     * @see     Author
     * @see     addAuthor()
     * @see     deleteAuthor()
     */
    public Author[] getAuthors(){
        
        return authors.toArray(Author[]::new);
    }
    
    /**
     * Splits the passed string into a group of sentences and adds them to the given Book.
     * Will add a period to the end of any non-sentence passed to it.
     * 
     * @param content   The content to be added to the Book
     * 
     * @see             Book
     * @see             deleteSentanceFromBook()
     * @see             deleteByIndex()
     * @see             getContents()
     * @see             search()
     * @see             searchByIndex()
     */
    public void addToBook(String content){
        String cGroup[] = content.split(". ");
        for(String s: cGroup){
            String sCon = s.concat(". ");
            contents.add(sCon);
        }
        
    }
    
    /**
     * Removes any instance of the passed String from a given Book.
     * Assumes the passed String is a sentence in the Book.
     * Adds the period the passed string if necessary.
     * 
     * @param badS      The sentence to be deleted from the Book.
     * 
     * @see             Book
     * @see             addToBook()
     * @see             deleteByIndex()
     * @see             getContents()
     * @see             search()
     * @see             searchByIndex()
     */
    public void deleteSentenceFromBook(String badS){
        if(!badS.endsWith(". ")){
            if(badS.endsWith(" ")){
                badS = badS.stripTrailing();
            }
            badS = badS.concat(". ");
        }
        
        for(String s: contents){
            if(s.equals(badS)){
                contents.remove(s);
            }
        }
    }
    
    /**
     * Removes the sentence from the given Book that is at the passed index.
     * Checks for index out of bounds.
     * 
     * @param index     Int
     * 
     * @see             Book
     * @see             addToBook()
     * @see             deleteSentenceFromBook()
     * @see             getContents()
     * @see             search()
     * @see             searchByIndex()
     */
    public void deleteByIndex(int index){
        if(index < contents.size() && index >= 0){
            contents.remove(index);
        }
    }
    
    /**
     * Returns all the sentences in a given Book.
     * 
     * @return  Array of Strings
     * 
     * @see     Book
     * @see             Book
     * @see             addToBook()
     * @see             deleteSentenceFromBook()
     * @see             deleteByIndex()
     * @see             search()
     * @see             searchByIndex()
     */
    public String[] getContents(){
        
        return contents.toArray(String[]::new);

    }
    
    /**
     * Searches through the contents of a given Book for the passed String and returns all
     * sentences which include that String.
     * Adds the index of the sentence the end of its String.
     * Case sensitive.
     * 
     * @param search    Will be used as the key to search the Book.
     * @return          Array of Strings
     * 
     * @see             Book
     * @see             addToBook()
     * @see             deleteSentenceFromBook()
     * @see             deleteByIndex()
     * @see             getContents()
     * @see             searchByIndex()
     */
    public String[] search(String search){
        ArrayList<String> matches = new ArrayList<>();
        
        for(String s: contents){
            if(s.contains(search)){
                matches.add(s.concat("(Index: " + contents.indexOf(s) + ")"));
            }
        }
        if(matches.isEmpty()){
            matches.add("Not in book.");
        }
        
        return matches.toArray(String[]::new);
    }
    
    /**
     * Returns the sentence from the given Book that is at the passed index.
     * Checks for index out of bounds.
     * 
     * @param index     Int
     * @return          String
     * 
     * @see             Book
     * @see             addToBook()
     * @see             deleteSentenceFromBook()
     * @see             deleteByIndex()
     * @see             getContents()
     * @see             search()
     */
    public String searchByIndex(int index){
        if(index < contents.size() && index >= 0){
            return contents.get(index);
        }
        
        return "No sentence at this index.";
    }
}
