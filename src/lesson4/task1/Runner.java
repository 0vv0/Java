package lesson4.task1;

/**
 * Created by Oleksii.Sergiienko on 12/24/2016.
 */
public class Runner {
//    Создать классы Directory, File, которые имеют метод getSize().
//Файл имеет фиксированный размер, размер директории считается по содержимому.
// В директорию можно вкладывать как файл, так и другую директорию. Зацикливания недопустимы.
//
//    Создать иерархию директорий (клиентский код):
//    root
//|--- dir1
//|     |--- f1 (10 B)
//|     |--- f2 (20 B)
//|
//        |--- dir2
//|     |--- dir3
//|     |     |--- f3 (30 B)
//|     |
//        |     |--- f4 (40 B)
//|
//        |--- f5 (50 B)
//
//    Посчитать размер директории root.
//    Пример клиентского кода: https://gist.github.com/anonymous/c8cfbd4b0692d80376a6.
//
//    Иерархия директорий - это ИЕРАРХИЯ ОБЪЕКТОВ, а НЕ классов.
//    Реально создавать файлы и директории НЕ НУЖНО.

    public static void main(String[] args) {

        Directory root = new Directory("root");

        Directory dir1 = new Directory();
        dir1.add(new File("f1", 10));  //10
        dir1.add(new File("f1", 10));  //10
        dir1.add(new File("f2", 20));  //30
        root.add(dir1);

        root.add(new Directory("dir2"));

        Directory dir3 = new Directory("dir3");
        dir3.add(new File("f3", 30));  //60
        dir3.add(new File("f4", 40));  //100
        //dir3.add(dir1);
        root.add(dir3);

        root.add(new File("f5", 50));  //150

        try{
            //root.add(root);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        System.out.println(root.getSize());

    }

}

