package ua.kiev.prog.school;

import ua.kiev.prog.school.instances.Parent;
import ua.kiev.prog.school.instances.NamedPerson;
import ua.kiev.prog.school.instances.RandomTeacher;
import ua.kiev.prog.school.instances.StablePupil;
import ua.kiev.prog.school.interfaces.Teacher;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
class Runner {
    public static void main(String[] args) {

        NamedPerson mom = new Parent("Silvia", "Sergiienko", "");
        NamedPerson dad = new Parent("Nicolai", "Sergiienko", "");
        StablePupil oleksii = new StablePupil("Oleksii", "Sergiienko", mom, dad);
        Teacher teacher = new RandomTeacher("Bohdan", "Vanchuhov");




    }
}
