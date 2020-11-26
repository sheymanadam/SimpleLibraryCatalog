
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

class SimpleLibraryCatalog {
    static String FILENAME = "2213.mrc";

    public static void main(String args[]) {

        int count = 0; // For counting records
        Book book;

        MarcImport mi = new MarcImport(FILENAME);

        /*
            In this section, instantiate your object. Call it "libraryDataObject".
            This will allow the rest of the code to do its thing without changing any other
            variable. 

            Comment out the other data structers so that only yours is being used. We can only 
            Do one at a time.
        */
        
        // Tree
        // HashMap (Brian's)
        HashCatalog libraryDataObject = new HashCatalog();
        // Linked list.

        // Now we iterate over the stream, getting a record one at a time.
        while (mi.hasNext()) {

            /*
             * Get the next book. This has more than we need. So we will send it over to get
             * a nicely formatted book as a dictionary. You can then take each item and add
             * it to your data structure.
             */
            book = mi.getNextRecord();

            /*
                The following are available in the returned book object.
                Use them to populate your data structure. Then after the while loop
                you can invoke the input loop in order to interact with your 
                user.

                 book.title;
                 book.author;
                 book.loc;
                 book.description;
                 book.available; true or false string
                 patronId; id string from user record.
            */ 
            libraryDataObject.addBook(book);
    
            // Do this if you only want a certain number of records.
            // Here we will stop at 500. Default is to bring them ALL in (>2000)
            if (count == 100)
                break;
            count++;
        }

        /* 
            Pass your object here.  If you name your data structure object
            The same as I have here, you won't need to change anything here.
        */
        try {
            processLibrary(libraryDataObject);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        mi.closeStream();
    }

    public static void printMainMenu() {
        String menu = "\n-------Main Menu--------\n" + "add user: Add a new patron\n" + "delete user: Delete a patron\n"
                + "search user: Search for a patron\n" + "add book: Add a new book\n" + "delete book: Delete a book\n"
                + "search book: Search for a book\n" + "help: Print this menu\n" + "\n";

        System.out.println(menu);
    }

    /*
     * Work horse for processing user input.
     * 
     */
    public static void processLibrary(Object object) throws NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        String answer = "";
        printMainMenu();
       
        Class<?> clazz = object.getClass();
                
        Class[] cArg1 = new Class[1];
        cArg1[0] = String.class;

        Method searchBook = clazz.getMethod("searchBook", cArg1);
        Method deleteBook = clazz.getMethod("deleteBook", cArg1);

        Class[] cArg2 = new Class[1];
        cArg2[0] = Book.class;

        Method addBook = clazz.getMethod("addBook", cArg2);
                
        Scanner scan = new Scanner(System.in);  
        while(answer.equals("quit") != true){
            System.out.print("Enter command:> ");
            answer = scan.nextLine();
            switch(answer.toLowerCase()){
                case "help":
                    printMainMenu();
                    break;
                case "add patron":
                    //addPatron();
                    break;
                case "delete patron":
                    //deletePatron();
                    break;
                case "search patron":
                    //searchPatron();
                    break;
                case "add book":
                    Book book = new Book();
                    addBook.invoke(object, book);  
                    break;
                case "delete book":
                    System.out.print("Enter title to search for:>> ");
                    String deleteTitle = scan.nextLine(); 
                    searchBook.invoke(object, deleteTitle);
                    System.out.print("Now, enter call number for book to delete:>> ");
                    String loc = scan.nextLine();   
                    deleteBook.invoke(object, loc);  
                    break;
                case "search book":
                    System.out.print("Enter title to search for:>> ");
                    String title = scan.nextLine();   
                    searchBook.invoke(object, title);
                    break;
                default:
                    printMainMenu();
            }

        }
        scan.close();
    }
}

