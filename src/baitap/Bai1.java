package baitap;

import java.io.*;
import java.util.Scanner;

public class Bai1
{
    public static final Scanner scanner = new Scanner(System.in);//Dùng chung

    public static String readBai1()
    {
        File file = new File("src/baitap/files/bai1.txt");
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
