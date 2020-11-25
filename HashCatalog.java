
import java.util.HashMap;

class HashCatalog implements LibraryCatalog{
    HashMap<String, HashMap<String, String>> Catalog;
    public void LibraryCatalog(){
        Catalog = new HashMap<String, HashMap<String, String>>();

    }

    @Override
    public boolean deleteBook(String loc){
        System.out.println("Delete book with loc of "+loc);
        return true;
    }

    @Override
    public Book searchBook(String title){
        Book book = new Book();
        System.out.println("Got "+title);
        return book;
    }

    @Override
    public boolean addBook(Book book) {
        System.out.println("HELLO WORLD");
        return false;
    }
}