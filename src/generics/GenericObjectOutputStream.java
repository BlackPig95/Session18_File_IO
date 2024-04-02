package generics;

import java.io.*;
import java.util.List;

public class GenericObjectOutputStream
{
    public static <T extends Serializable> void writeObjectStream(String path, List<T> tList)
    {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            try
            {
                if (fileOutputStream != null)
                {
                    fileOutputStream.close();
                }
                if (objectOutputStream != null)
                {
                    objectOutputStream.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
