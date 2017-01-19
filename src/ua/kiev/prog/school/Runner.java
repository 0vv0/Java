package ua.kiev.prog.school;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
class Runner {
    public static void main(String[] args) {

        NamedPerson mom = new Parent("Silvia", "Sergiienko", "");
        NamedPerson dad = new Parent("Nicolai", "Sergiienko", "");
        Pupil oleksii = new Pupil("Oleksii", "Sergiienko", mom, dad);
        Teacher teacher = new RandomTeacher("Bohdan", "Vanchuhov");
        TaskList taskList = new TaskList().add(
                new Task("What is Interface in Java?"),
                new Task("What is Static Method in Java?")
        );
        Answers oleksiiAnswers = new Answers();
        for(Task task:taskList){
            oleksiiAnswers.addAnswer(task, oleksii.getAnswer(task));
        }

        Marks marks = new Marks();
        for(TaskWithAnswer taskWithAnswer:oleksiiAnswers){
            marks.setMark(taskWithAnswer, teacher.mark(taskWithAnswer));
        }

        System.out.println(mom);
        System.out.println(dad);
        System.out.println(oleksii.toString());
        System.out.println(teacher);
        System.out.println(taskList);
        System.out.println(oleksiiAnswers);
        System.out.println(marks);
    }
}
