package lesson7.task4;

/**
 * Created by Oleksii.Sergiienko on 12/28/2016.
 */
public class Person implements Comparable<Person>{
    private final String name;
    private final int age;
    private final Sex sex;

    enum Sex{
        Male, Female
    }

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public Sex getSex(){
        return sex;
    }


    @Override
    public int compareTo(Person o) {
        if(age==o.getAge()){
            return name.compareTo(o.getName());
        } else {
            return age>o.getAge()?1:-1;
        }
    }

    @Override
    public String toString() {
        return name.toUpperCase().charAt(0) + name.toLowerCase().substring(1) + "(" + sex + ", " + age + ")";
    }
}
