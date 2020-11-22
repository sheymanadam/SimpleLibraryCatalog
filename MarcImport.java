
import org.marc4j.MarcReader;
import org.marc4j.MarcStreamReader;
import org.marc4j.marc.Record;
import org.marc4j.marc.DataField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class MarcImport{

    public boolean read(String marcFileName){

        try{
            InputStream in = new FileInputStream("import/" + marcFileName); //(currentDir + "/" + marcFileName);
            MarcReader reader = new MarcStreamReader(in);
            while (reader.hasNext()) {
                Record record = reader.next();
                DataField title = (DataField) record.getVariableField("245");
                System.out.println(title);
            }
            in.close();
        }catch(FileNotFoundException e){
            System.out.println(marcFileName + " not found. Files must be put in an import folder under this class file.");
            return false;
        }catch(IOException e){
            System.out.println("IO Error");
        }
        return true;
    }

}