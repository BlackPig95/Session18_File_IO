package baitap;

import java.io.*;
import java.util.Scanner;

public class Bai2
{
    public static void readAndCopyByte() throws FileNotFoundException
    {
        System.out.println("Enter source file path");
        String source = Bai1.scanner.nextLine();
        //Tạo object file nguồn để kiểm tra sự tồn tại
        File sourceFile = new File(source);
        if (!sourceFile.exists())
        {
            System.out.println("File nguồn không tồn tại");
            return;
        }
        System.out.println("Enter destination file path");
        String destination = Bai1.scanner.nextLine();
        //Tạo object file đích để kiểm tra sự tồn tại
        File destinationFile = new File(destination);
        if (destinationFile.exists())
        {
            System.out.println("File đích đã tồn tại, file này sẽ bị ghi đè");
        }
        BufferedReader bfr = null;
        BufferedWriter bfw = null;
        try
        {   //Dùng bufferStream để hỗ trợ đọc ghi nhanh hơn
            bfr = new BufferedReader(new FileReader(sourceFile));
            bfw = new BufferedWriter(new FileWriter(destination));
            int c;
            while ((c = bfr.read()) != -1)
            {
                bfw.write(c);//Viết từng byte vào buffer stream
            }
            bfw.flush();//Sau khi viết xong thì cập nhật vào file trong 1 lần
            System.out.println("Số byte trong file: " + destinationFile.length());//Đếm số byte trong file đích
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            try
            {
                if (bfr != null)
                {
                    bfr.close();
                }
                if (bfw != null)
                {
                    bfw.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
