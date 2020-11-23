import org.marc4j.MarcReader;
import org.marc4j.marc.Record;

import java.util.*;

class SimpleLibraryCatalog{

    public static void main(String args[]){

       createBookTree("2213.mrc"); 
       
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
            //Delete this print statements in your actual function.
            System.out.println(book.get("title"));
            System.out.println(book.get("author"));
            System.out.println(book.get("loc_call_number") + "\n");
            System.out.println(book.get("description"));

            //Do this if you only want a certain number of records.
            //Here we will stop at 500.
            if(count == 500) break;
            count++;
        }
    }
}

