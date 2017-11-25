package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.company.Time.MTime;

public class Main {

    public static void main(String[] args) throws IOException {

        try{
            FileInputStream fstream = new FileInputStream("C://input.txt"); //Открываем входящий файл
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){ //Пробегаемся по строкам файла, разбиваем, переводим в часы в минуты
                String[] sTime = strLine.split(",");
                int Time1 = Integer.valueOf(sTime[1].split(":")[0].trim())*60;
                int Time2 = Integer.valueOf(sTime[1].split(":")[1].trim());
                int Time3 = Integer.valueOf(sTime[2].split(":")[0].trim())*60;
                int Time4 = Integer.valueOf(sTime[2].split(":")[1].trim().substring(0,sTime[2].split(":")[1].trim().length()-1));
                int BegTime = Time1 + Time2;
                int EndTime = Time3 + Time4;
                Time.MTime.add(new Time(BegTime,EndTime,strLine)); //Добавляем в Arraylist MTime
            }
            Time l;
            Time b = null;
            PrintWriter out = new PrintWriter("output.txt"); //Открываем файл для записи
            do{//прогоняем через метод Min в классе Time и записываем нужную строку в файл
                l = b;
                if(l != null){
                out.println(l);}
                b = Time.Min();
            }
            while(l != b);
            br.close(); //заканчиваем чтение
            out.close(); //заканчиваем запись
        }catch (IOException e){
            System.out.println("Ошибка");
        }

    }
}


