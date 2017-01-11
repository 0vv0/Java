package lesson7.task3;

/**
 * Created by Oleksii.Sergiienko on 12/28/2016.
 */
class Runner {
    //  Создать класс Names (List<String> names), который умеет выполнять следующие действия:
//1. Отсортировать имена в алфавитном порядке.
//2. Отсортировать имена в алфавитном порядке по убыванию.
//3. Найти наименьшее имя в алфавитном порядке (использовать метод Collections.min(...)).
//4. Отсортировать имена по количеству букв.
//5. Отсортировать имена по количеству букв, а в группах, где количество букв одинаковое,
// - в алфавитном порядке по убыванию.
    public static void main(String[] args) {
        Names names = new Names();
        try {
            System.out.printf(names.min());
        } catch (NullPointerException e){
            System.out.printf(e.toString());
        }
        finally {
            System.out.printf("\n\n");
        }


        names = new Names("Ivan", "Irene");
        names.add("Said").add("David").add("Anatolii").add("Anton").add("Andrew");

        System.out.printf("Unsorted:\n" + names.toString());
        System.out.printf("The first is:\n" + names.min() + "\n");
        System.out.printf("The last is:\n" + names.max() + "\n\n");
        System.out.printf("Unsorted:\n" + names.toString());

        System.out.printf("Sorted:\n" + names.sort(true).toString());
        System.out.printf("Sorted back:\n" + names.sort(false).toString());

        System.out.printf("Unsorted:\n" + names.toString());

        System.out.printf("Sorted by length:\n" + names.sort1ToLongest().toString());
        System.out.printf("Sorted by length back:\n" + names.sortLongestTo1().toString());

        System.out.printf("Unsorted:\n" + names.toString());

        System.out.printf("Sorted by length + AZ:\n" + names.sort1ToInfinityAZ().toString());
        System.out.printf("Sorted by length + ZA:\n" + names.sort1ToInfinityZA().toString());
        System.out.printf("Unsorted:\n" + names.toString());

    }
}
