
import java.util.HashMap;

class HashCatalog implements LibraryCatalog{
    HashMap<String, HashMap<String, String>> catalog;

    public HashCatalog(){
        catalog = new HashMap<String, HashMap<String, String>>();
    }

    @Override
    public boolean deleteBook(String loc){
        System.out.println("Delete book with loc of "+loc);
        return true;
    }

    @Override
    public Book searchBook(String title){
        Book book = new Book();
        
        /* Set<Integer> keys = catalog.keySet();
        for(Integer key: keys){
        
        } */
        

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
        
        try{
            if(hashBook.containsKey(book.loc)){
                //This will be an exception later on.
                System.out.println("This book already exists");
            }else{
                  catalog.put(book.loc, hashBook);
            }
        }catch(NullPointerException e){
            System.out.println("I got a null pointer in addBook.");
            return false;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        //curBookId++;
        return true;
    }
}