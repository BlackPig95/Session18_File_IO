package baitap;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainBaitap
{
    public static void main(String[] args)
    {
        //Bai1
//        String[] bai1 = Bai1.readBai1().split(" ");
//        System.out.println(Bai1.readBai1());
//        System.out.println("Số lượng từ: " + bai1.length);
        //Bai2
//        Bai2.readAndCopyByte();
        //Bai3
        //Nếu dùng dấu cách thường thì sẽ không loại bỏ được new line character
//        String[] bai3 = Bai3.readLongestWords().split("\\s+");
//        List<String> longestWords = new ArrayList<>();
//        int longest = 0;
//        for (String word : bai3)
//        {
//            if (word.length() == longest)
//            {
//                longestWords.add(word);
//            } else if (word.length() > longest)
//            {
//                longest = word.length();
//                longestWords.clear();
//                longestWords.add(word);
//            }
//        }
//        System.out.println("Các từ có độ dài lớn nhất: ");
//        System.out.println(longestWords);
        //Bai4
//        Bai4.reverseFile();
        //Bai5
//        Bai5.readCSV().forEach(country -> System.out.println(country));
        Bai6.countFrequency();
    }
}
