package lesson3.task1;

/**
 * Created by Oleksii.Sergiienko on 20.12.2016.
 */
public class Word {
    private static int hashCounter = 0;

    private final String value;
    private final int hash = hashCounter++;

    Word() {
        value = " ";
    }

    Word(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {
                throw new IllegalArgumentException("Non-letter symbols not allowed");
            }
        }
        value = word;
    }

    Word(char... chars){
        StringBuilder sb = new StringBuilder();
        for(char c:chars){
            sb.append(c);
        }
        value = sb.toString();
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
    public boolean equals(Object toWord) {
        if(toWord==null){return false;}
        return (toWord instanceof Sentence )&& value.equals(toWord.toString());
    }

}
