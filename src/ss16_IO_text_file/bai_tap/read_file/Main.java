package ss16_IO_text_file.bai_tap.read_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = null;
        try{
            String line;
            br =new BufferedReader(new FileReader("src/ss16_IO_text_file/bai_tap/read_file/countries.csv"));
            while ((line=br.readLine())!=null){
                printCountry(parseCsvLine(line));
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split("\\t");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }
    private static void printCountry(List<String> country) {
        if (country.size() >= 3) {
            System.out.println(
                    "Country [id= "
                            + country.get(0)
                            + ", code= " + country.get(1).replaceAll("\"", "")
                            + " , name=" + country.get(2).replaceAll("\"", "")
                            + "]");
        }else {
            System.err.println("Dòng không hợp lệ: thiếu dữ liệu -> " + country);
        }
}}
