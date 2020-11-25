
import java.util.HashMap;
import java.util.Set;

class HashCatalog implements LibraryCatalog{
    HashMap<Integer, HashMap<String, String>> catalog;
    Integer curBookId = 0; //Will ultimately hold the last record id. Inc it will give us a new one when adding.

    public void LibraryCatalog(){
        catalog = new HashMap<Integer, HashMap<String, String>>();
    }

    @Override
    public boolean deleteBook(String loc){
        System.out.println("Delete book with loc of "+loc);
        return true;
    }

    @Override
    public Book searchBook(String title){
        Book book = new Book();
        
        Set<Integer> keys = catalog.keySet();
        for(Integer key: keys){
        
        }
        

        return book;
    }

    @Override
    public boolean addBook(Book book) {
        HashMap<String, String> hashBook = new HashMap<String, String>();
        hashBook.put("title", book.title);
        hashBook.put("description", book.description);
        hashBook.put("author", book.author);
        hashBook.put("available", "true");
        hashBook.put("patronId", "");
        System.out.println(hashBook);
        try{
            catalog.put(curBookId, hashBook);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        //curBookId++;
        return true;
    }
}