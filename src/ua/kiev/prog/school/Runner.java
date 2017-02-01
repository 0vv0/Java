package ua.kiev.prog.school;

import ua.kiev.prog.school.instances.*;
import ua.kiev.prog.school.interfaces.*;
import ua.kiev.prog.school.interfaces.Task.Mark;

import java.util.Set;
import java.util.TreeSet;

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

        Task task1 = teacher.giveATask();
        Task task2 = teacher.giveATask(teacher.ask("Java is OOP"));
        Task task3 = new SimpleTask(teacher.ask("What is the capital of Ukraine"));

        Journal journalOfJavaOOPCourse = new ClassJournal(teacher);
        journalOfJavaOOPCourse.add(oleksii).add(olesia);

        Set<Task> oleksiisQuestions = new TreeSet<>();
        Set<Task> olesiasQuestions = new TreeSet<>();

        oleksiisQuestions.add(task1);
        oleksiisQuestions.add(task2);
        System.out.println(oleksiisQuestions);

        olesiasQuestions.add(task1);
        olesiasQuestions.add(task3);
        System.out.println(olesiasQuestions);

        oleksiisQuestions.forEach(x -> journalOfJavaOOPCourse.add(oleksii, x));
        olesiasQuestions.forEach(x -> journalOfJavaOOPCourse.add(olesia, x));

        System.out.println();
        System.out.println(journalOfJavaOOPCourse);


        Journal newJournal = journalOfJavaOOPCourse.filterByTask(x -> x.getMark() == Mark.UNMARKED);
        System.out.println();
        System.out.println(newJournal);
    }
}
