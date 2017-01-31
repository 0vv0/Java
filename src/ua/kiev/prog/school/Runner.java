package ua.kiev.prog.school;

import sun.reflect.generics.tree.Tree;
import ua.kiev.prog.school.instances.*;
import ua.kiev.prog.school.interfaces.*;

import java.util.ArrayList;
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

        Question question1 = teacher.ask();
        Question question2 = teacher.ask("Java is OOP?");
        Question question3 = teacher.ask("What is the capital of Ukraine?");

        Journal journalOfJavaOOPCourse = new ClassJournal(teacher);
        journalOfJavaOOPCourse.add(oleksii).add(olesia);

        Set<Question> oleksiisQuestions = new TreeSet<>();
        Set<Question> olesiasQuestions = new TreeSet<>();

        System.out.println(question1);
        System.out.println(question2);
        System.out.println(question3);

        oleksiisQuestions.add(question1);
        oleksiisQuestions.add(question2);
        System.out.println(oleksiisQuestions);

        olesiasQuestions.add(question1);
        olesiasQuestions.add(question3);
        System.out.println(olesiasQuestions);

        journalOfJavaOOPCourse.add(oleksii, oleksiisQuestions);
        journalOfJavaOOPCourse.add(olesia, olesiasQuestions);
        System.out.println();
        System.out.println(journalOfJavaOOPCourse);

        journalOfJavaOOPCourse.setMark(oleksii, oleksii.giveAnswer(question1), teacher.mark(oleksii.giveAnswer(question1)) );
        System.out.println();
        System.out.println(journalOfJavaOOPCourse);

        journalOfJavaOOPCourse.setMark(oleksii, oleksii.giveAnswer(question2), teacher.mark(oleksii.giveAnswer(question2)) );
        System.out.println();
        System.out.println(journalOfJavaOOPCourse);

        journalOfJavaOOPCourse.add(olesia, olesiasQuestions);
        System.out.println();
        System.out.println(journalOfJavaOOPCourse);


        Journal newJournal = journalOfJavaOOPCourse.filterByMark(x -> x == Mark.UNMARKED);
        System.out.println();
        System.out.println(newJournal);
    }
}
