package org.example;

public class example_Long {
    public static void main (String[] args) {
        int lightspeed;
        long days;
        long seconds;
        long distance;

        lightspeed = 186000; //Приблизительная скорость света в милях в секунду
        days=1000; //количество дней
        seconds=days*24*60*60; //преобразовать дни в секунды
        distance=lightspeed*seconds; // рассчитать расстояние

        System.out.print ("За " +days);
        System.out.print(" дней свет пройдет около ");
        System.out.print(distance+" миль.");
        }
}
