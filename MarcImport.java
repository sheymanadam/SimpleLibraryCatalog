
import org.marc4j.MarcReader;
import org.marc4j.MarcStreamReader;
import org.marc4j.marc.Record;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

class MarcImport{

    public boolean read(String marcFileName){

        try{
            InputStream in = new FileInputStream("import/" + marcFileName); //(currentDir + "/" + marcFileName);
            MarcReader reader = new MarcStreamReader(in);
            while (reader.hasNext()) {
                Record record = reader.next();
                System.out.println(record.toString());
            }
        }catch(FileNotFoundException e){
            System.out.println(marcFileName + " not found. Files must be put in an import folder under this class file.");
            return false;
        }
        return true;
    }

}