
import org.marc4j.MarcReader;
import org.marc4j.MarcStreamReader;
import org.marc4j.marc.Record;
import org.marc4j.marc.DataField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class MarcImport{

    public int read(String marcFileName){
        int recCount = 0;
        try{
            InputStream in = new FileInputStream("import/" + marcFileName); //(currentDir + "/" + marcFileName);
            MarcReader reader = new MarcStreamReader(in);
            while (reader.hasNext()) {
                
                try{
                    Record record = reader.next();
                    DataField title = (DataField) record.getVariableField("245");
                    System.out.println(title);
                }catch(Exception e){
                    System.out.println("There was an error processing this record. Skipping it." + e.getMessage());
                    continue;
                }
                recCount++;
            }
            in.close();
        }catch(FileNotFoundException e){
            System.out.println(marcFileName + " not found. Files must be put in an import folder under this class file.");
            return 0;
        }catch(IOException e){
            System.out.println("IO Error " + e.getMessage());
            return 0;
        }catch(Exception e){
            System.out.println("WHAT HAPPENED? " + e.getMessage());
        }
        return recCount;
    }

}