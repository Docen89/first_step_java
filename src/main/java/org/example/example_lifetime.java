package org.example;

public class example_lifetime {
    public static void main (String[] args) {
        int x;
        for (x=0;x<3;x++) {
            int y=-1;//переменная  у инцилиазириуется при каждом входе в блок
            System.out.println("Теперь у равно "+ y); // всегда выводиться -1
            y=100;
            System.out.println("Теперь значение у равно "+y);

        }
    }
}
