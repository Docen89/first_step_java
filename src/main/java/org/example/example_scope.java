package org.example;

public class example_scope {
    public  static void main (String[] args){
        int x; // переменная, известная всему коду внутри main
        x=10;
        if(x==10) { // начала новой области видимости
            int y = 20; // переменная, известная только этому блоку
            // x и у здесь известны
            System.out.println("x и y: " + "" + y);
            x = y * 2;
        }
         //y=100  ошибка! Переменная у здесь не известна.
        //переменная x по прежнему известна.
        System.out.println("Значение  x равно "+x);
    }
}
