import org.marc4j.MarcReader;
import org.marc4j.marc.Record;
import java.util.*;

class SimpleLibraryCatalog{

    public static void main(String args[]){

        //createBookTree("2213.mrc"); 

         processLibrary();
       
    }

    /*
        This is an example function. I've commented what each part does.
        Just cut and paste what you need. 
        The important spot is the record stream.
    */
    public static void createBookTree(String fileName){
        int count = 0; //For counting records

        HashMap<String, String> book;  
           
        MarcImport mi = new MarcImport();
        
        //First we get a record stream
        MarcReader mr = mi.getRecordStream(fileName);
        
        //Now we iterate over the stream, getting a record one at a time.
        while(mr.hasNext()){
            Record record = mr.next();
            /*
                We take the record of a book.
                This has more than we need. So we
                will send it over to get a nicely formatted
                book as a dictionary.  You can then take each item
                and add it to your data structure.
            */
            book = mi.getBookData(record);

            //I am printing out the available values.
            //Delete these print statements and put the key and value into your data structure.
            System.out.println(book.get("title"));
            System.out.println(book.get("author"));
            System.out.println(book.get("loc_call_number") + "\n");
            System.out.println(book.get("description"));
            //book.get("available"); true or false string
            //book.get("user_id"); id string from user record.
            
            //Do this if you only want a certain number of records.
            //Here we will stop at 500. Default is to bring them ALL in (>2000)
            if(count == 500) break;
            count++;
        }
    }

    public static void printMainMenu(){
            String menu = 
                "\n-------Main Menu--------\n"
            +   "add user: Add a new patron\n"
            +   "delete user: Delete a patron\n"
            +   "search user: Search for a patron\n"
            +   "add book: Add a new book\n"
            +   "delete book: Delete a book\n"
            +   "search book: Search for a book\n"
            +   "help: Print this menu\n"
            +   "\n";

            System.out.println(menu);
    }

    /*
        Work horse for processing user input.
        
    */
    public static void processLibrary(){     
        
        String answer = "";
        printMainMenu();
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
                    //book.addBook();
                    break;
                case "delete book":
                    //book.deleteBook();
                    break;
                case "search book":
                    //book.searchBook();
                    break;
                default:
                    printMainMenu();
            }

        }
        scan.close();
    }
}

