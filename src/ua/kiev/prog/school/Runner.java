package ua.kiev.prog.school;

import ua.kiev.prog.school.instances.*;
import ua.kiev.prog.school.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
class Runner {
    public static void main(String[] args) {

        Person mom = new Parent("Silvia", "Sergiienko", "");
        Person dad = new Parent("Nicolai", "Sergiienko", "");
        Pupil oleksii = new StablePupil("Oleksii", "Sergiienko", mom, dad);
        Pupil olesia = new StablePupil("Olesia", "Sergiienko", mom, dad);
        Teacher teacher = new RandomTeacher("Bohdan", "Vanchuhov");

        Task task1 = teacher.createTask("Who is on duty today?");
        Task task2 = teacher.createTask("Java is OOP?");
        Task task3 = teacher.createTask("What is the capital of Ukraine?");

        Journal journalOfJavaOOPCourse = new ClassJournal(teacher);
        journalOfJavaOOPCourse.add(oleksii).add(olesia);

        List<Task> oleksiisTasks = new ArrayList<>();
        List<Task> olesiasTasks = new ArrayList<>();

        System.out.println(task1);
        System.out.println(task2);
        System.out.println(task3);

        oleksiisTasks.add(task1);
        oleksiisTasks.add(task2);
        System.out.println(oleksiisTasks);

        olesiasTasks.add(task1);
        olesiasTasks.add(task3);
        System.out.println(olesiasTasks);

        journalOfJavaOOPCourse.add(oleksii, oleksiisTasks);
        journalOfJavaOOPCourse.add(olesia, olesiasTasks);
        System.out.println();
        System.out.println(journalOfJavaOOPCourse);

        journalOfJavaOOPCourse.setMark(oleksii, oleksii.giveAnswer(task1), teacher.mark(oleksii.giveAnswer(task1)) );
        System.out.println();
        System.out.println(journalOfJavaOOPCourse);

        journalOfJavaOOPCourse.setMark(oleksii, oleksii.giveAnswer(task2), teacher.mark(oleksii.giveAnswer(task2)) );
        System.out.println();
        System.out.println(journalOfJavaOOPCourse);

        journalOfJavaOOPCourse.add(olesia, olesiasTasks );
        System.out.println();
        System.out.println(journalOfJavaOOPCourse);


        Journal newJournal = journalOfJavaOOPCourse.filterByMark(new Predicate<Mark>() {
            @Override
            public boolean test(Mark mark) {
                return mark == Mark.UNMARKED;
            }
        });
        System.out.println();
        System.out.println(newJournal);
    }
}
