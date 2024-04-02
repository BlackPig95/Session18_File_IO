package baitap;

import java.io.*;

public class Bai4
{
    public static void reverseFile()
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
        StringBuilder copyString = new StringBuilder();
        try
        {   //Dùng bufferStream để hỗ trợ đọc ghi nhanh hơn
            bfr = new BufferedReader(new FileReader(sourceFile));
            bfw = new BufferedWriter(new FileWriter(destination));
            int c;
            while ((c = bfr.read()) != -1)
            {
                copyString.append((char) c);//Ép kiểu vì string concat dùng literal chứ không đọc byte
            }
            //Tạo mảng lưu các từ trong file cũ
            String[] reverseArray = String.valueOf(copyString).split("\\s+");
            //Clear Stringbuilder để dùng nối lại thành string đảo ngược
            copyString.setLength(0);
            //Dùng vòng lặp để đảo ngược string
            for (int i = reverseArray.length - 1; i >= 0; i--)
            {   //Thêm dấu cách vào sau mỗi từ được nối
                copyString.append(reverseArray[i]).append(" ");
            }
            //Viết string vào file mới
            bfw.write(String.valueOf(copyString));
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
