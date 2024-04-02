package baitap;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Bai3
{
    public static String readLongestWords()
    {
        File file = new File("src/baitap/files/bai3.txt");
        FileReader fileReader = null;
        StringBuilder result = new StringBuilder();
        try
        {
            fileReader = new FileReader(file);
            int ch;
            //Đọc từng byte một trong file
            while ((ch = fileReader.read()) != -1)
            {
                result.append((char) ch);//Ép kiểu về char và gắn vào string
            }
            System.out.println(result);
            return String.valueOf(result);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            try
            {
                if (fileReader != null)
                {   //Đóng stream
                    fileReader.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
