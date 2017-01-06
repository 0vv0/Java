package ua.kiev.prog.summaryTask;

/**
 * Created by Oleksii.Sergiienko on 12/27/2016.
 */
public class Runner {
    public static void main(String[] args) {
        IPerson mom = new Parent("Silvia", "Sergiienko");
        IPerson dad = new Parent("Nicolai", "Sergiienko");
        Pupil oleksii = new Pupil("Oleksii", "Sergiienko", mom, dad);
        ITeach teacher = new Teacher("Bohdan", "Vanchuhov");
        TaskList taskList = new TaskList().add(
                new Task("How many oceans?"),
                new Task("What is the capital of Ukraine?")
        );
        Answers answers = new Answers(oleksii);
        for(Task task:taskList){
            answers.addAnswer(task, oleksii.getAnswer(task));
        }

        Marks marks = new Marks(oleksii);
        for(TaskWithAnswer taskWithAnswer:answers){
            marks.setMark(taskWithAnswer, teacher.mark(taskWithAnswer));
        }

        System.out.println(mom);
        System.out.println(dad);
        System.out.println(oleksii.toString());
        System.out.println(teacher);
        System.out.println(taskList);
        System.out.println(answers);
        System.out.println(marks);
    }
}
