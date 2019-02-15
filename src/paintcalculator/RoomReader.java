/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintcalculator;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Exile
 */
public class RoomReader {
    public static List<Paintable> readPaintable(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException{
        List<Paintable> list = new ArrayList<Paintable>();
        
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        while(true)
        {
            try
            {
                Object obj = ois.readObject();
                Paintable item = (Paintable)obj;
                list.add(item);
            }
            catch(EOFException eof)
            {
                break;
            }
            
        }
        ois.close();
        return list;
    }
}
