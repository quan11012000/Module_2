package ss16_IO_text_file.thuc_hanh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileExample {
    public void readFileText(String filePath){
        // doc file theo duong dan
        try{
            File file = new File(filePath);
            // kiem tra neu file ton tai thi nem ra ngoai  le
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while((line = bufferedReader.readLine())!=null){
                System.out.println(line);
                sum+=Integer.parseInt(line);
            }
            bufferedReader.close();
            System.out.println("tong "+ sum);
        }catch(Exception e){
            //TH file khong ton tai or noi dung file co loi thi hien thi thong bao loi
            System.err.println("File khong ton tai or noi dung filed co loi ");
        }
    }
    public static void main(String[] args) {
        System.out.println("Nhap duong dan file");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readFileText(path);
    }
}
