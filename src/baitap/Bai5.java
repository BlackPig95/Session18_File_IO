package baitap;

import baitap.entity.CountryBai5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bai5
{
    public static List<CountryBai5> readCSV()
    {
        List<CountryBai5> listCountry = new ArrayList<>();
        String Path_file = "src/baitap/files/bai5.csv";
        FileReader fileReader = null;
        try
        {
            fileReader = new FileReader(Path_file);
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try
        {
            //Gán từng line của file vào một String
            String line = bufferedReader.readLine();
            while (line != null)//Đọc đến khi hết các dòng trong file
            {//Tạo object mới để gán giá trị
                CountryBai5 country = new CountryBai5();
                //Phân tách String ra thành mảng để gán giá trị cho object country
                String[] arrayCountry = line.split(",");
                country.id = arrayCountry[0];
                country.code = arrayCountry[1];
                country.name = arrayCountry[2];
                listCountry.add(country);
                //Sau khi gán xong giá trị, đọc dòng tiếp theo
                line = bufferedReader.readLine();
            }
            return listCountry;
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
