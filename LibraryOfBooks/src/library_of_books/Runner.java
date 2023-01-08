/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package library_of_books;

/**
 * Just a tester class.
 *
 * @author  CBurgi
 * 
 * @see     main()
 */
public class Runner {

    /**
     * Testing methods of Authors, Books, and Libraries
     * 
     * @param args  the command line arguments
     * 
     * @see         Author
     * @see         Book
     * @see         Library
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Testing methods of authors, books, and libraries
        
        Author a1 = new Author("Clark", "Toms");
        Book b1 = new Book("tester1", a1);
        
        System.out.println(a1.getFirstName());
        System.out.println(a1.getLastName());
        
        b1.addToBook("Tester sentence1. Test sentence2. Testtesttest3");
        b1.search("1");
        b1.deleteSentenceFromBook("Test sentence 2");
        b1.searchByIndex(0);
        
        Author a2 = new Author("John", "Markus");
        Book b2 = new Book("tester2", a2);
        
        System.out.println(b2.id);
        b2.addAuthor(a1);
        
        
        Library lib1 = new Library("library1");
        
        lib1.addBook(b1);
        lib1.addBook(b2);
        
        System.out.println(lib1.searchByTitle("tester1")[0].getTitle());
        System.out.println(lib1.searchByAuthor(a1)[0].getAuthors()[0].getFirstName());
        
        Author[] aBoth = {a1, a2};
        System.out.println(lib1.searchByMultipleAuthors(aBoth)[0].getAuthors()[0].getFirstName() + ", " + lib1.searchByMultipleAuthors(aBoth)[0].getAuthors()[1].getFirstName());
        
        System.out.println(lib1.getName());
        System.out.println(lib1.getNumBooks());
        
        lib1.deleteByTitle(b1.getTitle());
        lib1.deleteByMultipleAuthors(b2.getAuthors());
        
        b2.deleteAuthor(a1);
    }
    
}
