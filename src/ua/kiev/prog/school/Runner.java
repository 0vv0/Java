package ua.kiev.prog.school;

import ua.kiev.prog.school.instances.*;
import ua.kiev.prog.school.interfaces.*;
import ua.kiev.prog.school.interfaces.Task.Mark;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
class Runner {
    public static void main(String[] args) throws IOException {

        Person mom = new Parent("Silvia", "Sergiienko", "");
        Person dad = new Parent("Nicolai", "Sergiienko", "");
        Pupil oleksii = new StablePupil("Oleksii", "Sergiienko", mom, dad);
        Pupil olesia = new StablePupil("Olesia", "Sergiienko", mom, dad);
        Teacher teacher = new RandomTeacher("Bohdan", "Vanchuhov");

        Task task1 = teacher.giveATask();
        Task task2 = teacher.giveATask(teacher.ask("Java is OOP"));
        Task task3 = new SimpleTask(teacher.ask("What is the capital of Ukraine"));

        ((SimpleTask) task1).write();
        ((SimpleTask) task2).write();
        ((SimpleTask) task3).write();

        Journal journal = new ClassJournal(teacher);
        journal.add(oleksii).add(olesia);

        Set<Task> taskList = new TreeSet<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        System.out.println(taskList);

        journal.add(oleksii, taskList);
        System.out.println();
        System.out.println(journal);

        taskList.forEach(x -> x.setAnswer(olesia.giveAnswer(x.getQuestion())));
        journal.add(olesia, taskList);
        System.out.println();
        System.out.println(journal);

        taskList.forEach(x -> x.setMark(teacher.mark(x).getMark()));
        journal.add(olesia, taskList);
        System.out.println();
        System.out.println(journal);

        Journal newJournal = journal.filterByTask(x -> x.getMark() == Mark.F);
        System.out.println();
        System.out.println(newJournal.toList());


    }
}
