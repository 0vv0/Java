package lesson3.task2;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
public class Runner {
    public static void main(String[] args) {
        //Создать объект класса Планета, используя классы Материк, Океан, Остров.
        // Методы: вывести на консоль название материка, планеты, количество материков.


        Planet earth = new Planet();
        Area england = new Area("England", IArea.Type.Island);
        Area africa = new Area("Africa", IArea.Type.Continent);
        Area pacificOcean = new Area("Pacific Ocean", IArea.Type.Ocean);
        System.out.println(earth);

        earth.add(england).add(africa).add(pacificOcean);
        System.out.println("\n" + earth);

        earth.add(england).add(england).add(africa);
        System.out.println("\n" + earth);

        earth
                .add(new Area("North America", IArea.Type.Continent))
                .add(new Area("South America", IArea.Type.Continent));
        System.out.println("\n" + earth);
        System.out.println("Continents: " + earth.getContinentsCount());
        System.out.println("Oceans: " + earth.getOceansCount());
        System.out.println("Islands: " + earth.getIslandsCount());
    }
}
