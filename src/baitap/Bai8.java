package baitap;

import baitap.entity.ProductBai8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bai8
{
    //Lưu danh sách sản phẩm vào file chỉ định
    private static void writeProductToFile(String filePath, List<ProductBai8> productBai8List)
    {
        ObjectOutputStream objectOutputStream = null;
        try
        {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(productBai8List);

        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            try
            {
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

    //Trả về một object là list các sản phẩm đã lưu trong file
    private static List<ProductBai8> readProductFromFile(String filePath)
    {
        ObjectInputStream objectInputStream = null;
        try
        {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            return (List<ProductBai8>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            try
            {
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

    //Cho phép tìm kiếm sản phẩm lưu trong file
    public static ProductBai8 searchFromFile()
    {
        System.out.println("Nhập đường dẫn của file cần tìm kiếm");
        String filePath = Bai1.scanner.nextLine();
        //Lấy ra list sản phẩm
        List<ProductBai8> listProduct = readProductFromFile(filePath);
        System.out.println("Nhập mã sản phẩm muốn tìm kiếm");
        String idSearch = Bai1.scanner.nextLine();
        //Tìm kiếm dựa trên id trùng khớp
        return listProduct.stream().filter(p -> p.getId().equals(idSearch)).findAny().orElse(null);
    }

    //Hàm public cho giao diện người dùng lưu vào file
    public static void importToFile()
    {
        System.out.println("Nhập số lượng sản phẩm muốn thêm vào danh sách");
        int n = Integer.parseInt(Bai1.scanner.nextLine());
        System.out.println("Nhập thông tin các sản phẩm vào danh sách cần lưu");
        List<ProductBai8> listProduct = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            ProductBai8 productBai8 = new ProductBai8();
            productBai8.inputData();
            listProduct.add(productBai8);
        }
        System.out.println("Nhập đường dẫn của file mà bạn muốn dùng để lưu thông tin các sản phẩm này");
        String filePath = Bai1.scanner.nextLine();
        writeProductToFile(filePath, listProduct);//Sau khi nhập xong thông tin thì ghi vào file
        System.out.println("Ghi file thành công");
    }

    //Hàm public cho giao diện người dùng xem thông tin file đã lưu
    public static void displayInfoFromFile()
    {
        System.out.println("Nhập đường dẫn của file cần xem");
        String filePath = Bai1.scanner.nextLine();
        System.out.println(readProductFromFile(filePath));
    }
}
