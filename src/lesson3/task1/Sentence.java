package lesson3.task1;

/**
 * Created by Oleksii.Sergiienko on 20.12.2016.
 */
public class Sentence {
    //Создать  объект  класса Текст,  используя  классы  Предложение,  Слово.
    // Методы: дополнить текст, вывести на консоль текст, заголовок текста.
    private static int hashCounter = 0;

    private final String value;
    private final int hash = hashCounter++;

    Sentence() {
        value = ".";
    }

    Sentence(Word... words) {
        StringBuilder s = words.length == 0 ? new StringBuilder(" ") : new StringBuilder();
        for (Word w : words) {
            s.append(w.toString() + " ");
        }
        s.replace(s.length() - 1, s.length() - 1, ".")
                .replace(0, 1, String.valueOf(Character.toUpperCase(s.toString().charAt(0))));

        value = s.toString();
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object toSentence) {
        if(toSentence==null){return false;}
        return (toSentence instanceof Sentence )&& value.equals(toSentence.toString());
    }


}
