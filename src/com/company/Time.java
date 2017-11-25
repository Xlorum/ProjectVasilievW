package com.company;

import java.util.ArrayList;
import java.util.Collections;

//Класс для обработки времени
public class Time {
    int BTime;
    int ETime;
    String Z;
    static int jj = 1;
    static Time last = new Time(0,0,null);

    //Конструктор для хранения переменных разбитой строки
    public Time(int t1, int t2, String t0){
        BTime = t1;
        ETime = t2;
        Z = t0;
    }
    static ArrayList<Time> MTime = new ArrayList<>(); //Здесь мы храним заявки

    public static Time Min(){ //В этом методе мы делаем основные вычисления (нахождение самого раннего окончания заявки,а так же проверяем соблюдение основных правил (заявки не должны пересекаться)
        Time maxTime = new Time(9999999,999999, "1");
        for (Time t:MTime
             ) {
            if(maxTime.ETime > t.ETime && t.BTime > last.ETime){
                maxTime = t;
            }
        }
        if(maxTime.Z != "1"){
            int G = Integer.valueOf(maxTime.Z.split(",")[0].substring(1,maxTime.Z.split(",")[0].length()))-jj;
            last = maxTime;
            MTime.remove(G);//Удаляем уже либо ненужную, либо записанную заявку
            jj++;
        }
        return maxTime.Z == "1"?last:maxTime;
    }
    @Override //Переопределение метода
    public String toString(){
        return Z;
    }
}
