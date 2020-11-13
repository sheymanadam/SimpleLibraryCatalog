import org.marc4j.MarcReader;
import org.marc4j.MarcStreamReader;
import org.marc4j.MarcStreamWriter;
import org.marc4j.marc.Record;
import org.marc4j.marc.DataField;
import org.marc4j.marc.Subfield;
import org.marc4j.MarcWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class MARC {

    public void importMarcRecords(String inputMarc) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(inputMarc);
            out = new FileOutputStream("outputfile.mrc");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        MarcReader reader = new MarcStreamReader(in);
        MarcWriter writer = new MarcStreamWriter(out);
        while (reader.hasNext()) {
            Record record = reader.next();
            DataField datafield = (DataField) record.getVariableField("245");
            List<Subfield> subfields = datafield.getSubfields();
            Iterator<Subfield> i = subfields.iterator();
            
            while (i.hasNext()) {
                Subfield subfield = (Subfield) i.next();
                char code = subfield.getCode();
                if ( code == 'a' ) {
                    String data = subfield.getData();
                    if ( data.startsWith("J") ) {
                        writer.write(record);
                    } 
                }  
            }         
        }
    }
} 
