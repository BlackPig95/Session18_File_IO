package generics;

import java.io.*;
import java.util.List;

public class GenericObjectInputStream
{
    public static <T> List<T> readObjectStream(String path)
    {
        InputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try
        {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<T>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            try
            {
                if (fileInputStream != null)
                {
                    fileInputStream.close();
                }
                if (objectInputStream != null)
                {
                    objectInputStream.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
