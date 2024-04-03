package baitap;


import baitap.entity.StudentBai7;

import java.io.*;
import java.util.List;

public class Bai7
{
    public static void writeStudentBai7(String destinationPath, List<StudentBai7> studentList)
    {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream(destinationPath);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studentList);
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

    public static List<StudentBai7> readStudentBai7(String filePath)
    {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try
        {
            {
                fileInputStream = new FileInputStream(filePath);
                objectInputStream = new ObjectInputStream(fileInputStream);
                return (List<StudentBai7>) objectInputStream.readObject();
            }
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
