
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
    public String searchBook(String title){
        String book = "";
        Iterator<Map.Entry<String, HashMap<String, String>>> entrySet = 
            catalog.entrySet().iterator();

        while(entrySet.hasNext()){
            Map.Entry<String, HashMap<String, String>> entry = 
                entrySet.next();
            HashMap<String, String> hashBook = new HashMap<String, String>();
            hashBook = entry.getValue();
            if(hashBook.get("title").toLowerCase() == title.toLowerCase()){
                //book.title = hashBook.get("title");
                //book.author = hashBook.get("author");
                //book.description = hashBook.get("description");
                //book.loc = entry.getKey();
                //book.patronId = hashBook.get("patronId");
                //book.available = hashBook.get("available");
                book = entry.getKey()+" "
                +hashBook.get("title")+" "
                +hashBook.get("description")+" "
                +hashBook.get("author")+" "
                +hashBook.get("avalable")+" "
                +hashBook.get("patronId")+" ";
                return book;
            }
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