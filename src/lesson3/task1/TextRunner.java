package lesson3.task1;

/**
 * Created by Oleksii.Sergiienko on 21.12.2016.
 */
public class TextRunner {
    public static void main(String[] args) {
        Text text= new Text();
        System.out.println(text.toString());

        Word hello = new Word("hello");
        Word word = new Word(("word"));
        System.out.println(hello.toString());
        System.out.println(word.toString());

        Sentence sentence = new Sentence(hello, word);
        System.out.println(sentence.toString());

        text.add(sentence);
        System.out.println(text.toString());

    }
}
