
package paintcalculator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class RoomWriter {
    public void writePaintable(String fileName, List<Paintable> list) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        
        for(Paintable item : list)
        {
            oos.writeObject(item);
        }
        oos.close();
    }
}
