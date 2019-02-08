
package paintcalculator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class RoomWriter {
    public void writeRooms(String fileName, List<Room> list) throws FileNotFoundException, IOException{
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        
        for(Room room : list)
        {
            oos.writeObject(room);
        }
        oos.close();
    }
}
