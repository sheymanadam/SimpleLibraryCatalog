
import org.marc4j.MarcReader;
import org.marc4j.MarcStreamReader;
import org.marc4j.marc.DataField;
import org.marc4j.marc.Subfield;
import org.marc4j.marc.Record;
import org.marc4j.marc.VariableField;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.*;

class MarcImport{
    InputStream in = null;

    public MarcReader getRecordStream(String marcFileName){
     
        try{
            in = new FileInputStream("import/" + marcFileName); //(currentDir + "/" + marcFileName);
            MarcReader reader = new MarcStreamReader(in);
            return reader;
        }catch(FileNotFoundException e){
            System.out.println("Could not find the file " + marcFileName);
        }
        return null;
    }
    public void closeStream(){
        try{
            in.close();
        }catch(IOException e){
            System.out.println("There was an error closing the stream.");
        }
    }

    public HashMap<String, String> getBookData(Record r){

        /*
            050 = LOC call number
            100 = author
            245 = a title c author/editor
            520 = description
        */
        String[] tags = {"050","245", "520"};
        HashMap<String, String> book = new HashMap<String, String>();
        List fields = r.getVariableFields(tags);
        DataField field;
        for(int idx = 0; idx < fields.size(); idx++){
            field = (DataField)fields.get(idx);
            List subFields = field.getSubfields();
            Iterator i = subFields.iterator();
            
            while(i.hasNext()){
                Subfield subfield = (Subfield)i.next();
                if(field.getTag().equals("245")){
                    if(subfield.getCode() == 'a'){
                        book.put("title", subfield.getData());
                    }else if(subfield.getCode() == 'c'){
                        book.put("author", subfield.getData());
                    }
                }

                if(field.getTag().equals("520")){
                    book.put("description", subfield.getData());
                }
                if(field.getTag().equals("050")){
                    book.put("loc_call_number", subfield.getData());
                }
                
        
            }
        }
        return book;
    }


}