/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_of_books;

/**
 * Stores a first name and last name (String). Authors are added to books.
 * 
 * @author  CBurgi
 * 
 * @see     Book
 */
public class Author {
    
    public Author(String fName, String lName){
        setName(fName, lName);
    }
    
    private String firstName;
    private String lastName;
    
    /**
     * Sets an Author's names based on the Strings passed in.
     * 
     * @param fName     The first name of the Author.
     * @param lName     The last name of the Author.
     * 
     * @see             Author
     * @see             getFirstName()
     * @see             geLastName()
     */
    public void setName(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;
    }
    
    /**
     * Returns the first name of an Author.
     * 
     * @return  String
     * 
     * @see     Author
     * @see     setName()
     * @see     getLastName()
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * Returns the last name of an Author.
     * 
     * @return  String
     * 
     * @see     Author
     * @see     setName()
     * @see     getLastName()
     */
    public String getLastName(){
        return lastName;
    }
    
}
