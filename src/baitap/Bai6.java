package baitap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Bai6
{
    public static void countFrequency()
    {
        File file = new File("src/baitap/files/bai6.txt");
        BufferedReader bufferedReader = null;
        StringBuilder temp = new StringBuilder();
        try
        {
            bufferedReader = new BufferedReader(new FileReader(file));
            int ch;
            //Đọc từng byte một trong file
            while ((ch = bufferedReader.read()) != -1)
            {
                temp.append((char) ch);//Ép kiểu về char và gắn vào string
            }
            //Chuyển string thành list để duyệt dễ hơn
            List<String> countString = Arrays.asList(String.valueOf(temp).split("\\s+"));
            //Tạo map để đếm tần suất
            Map<String, Integer> countMap = new HashMap<>();
            countString.forEach(word ->
            {   //Nếu map đã có từ này, thì tăng giá trị thêm 1
                if (countMap.containsKey(word))
                {
                    countMap.put(word, countMap.get(word) + 1);
                } else
                {   //Nếu chưa có thì đặt cặp key value mới, value = 1
                    countMap.put(word, 1);
                }
            });
            int maxFrequency = 0;//Kiểm tra tần suất xuất hiện cao nhất
            //Vòng lặp 1 để kiểm tra xem tần suất xuất hiện cao nhất là bao nhiêu
            for (Map.Entry<String, Integer> entry : countMap.entrySet())
            {
                if (entry.getValue() > maxFrequency)
                {
                    maxFrequency = entry.getValue();
                }
            }
            //Vòng lặp 2 để tìm ra những từ có tần suất bằng với maxFrequency thì in ra
            for (Map.Entry<String, Integer> entry : countMap.entrySet())
            {
                if (entry.getValue() == maxFrequency)
                {
                    System.out.println("Từ xuất hiện nhiều nhất: " + entry.getKey());
                    System.out.println("Tần suất: " + entry.getValue());
                }
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            try
            {
                if (bufferedReader != null)
                {   //Đóng stream
                    bufferedReader.close();
                }
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
