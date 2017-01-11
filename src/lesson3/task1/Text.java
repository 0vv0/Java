package lesson3.task1;

import java.util.ArrayList;

/**
 * Created by Oleksii.Sergiienko on 20.12.2016.
 */
class Text {
    private static int hashCounter = 0;

    private final int hash = hashCounter++;
    private Sentence title = new Sentence();
    private final ArrayList<Sentence> value = new ArrayList<>();

    Text() {
    }

    Text(Sentence title) {
        if (title != null) {
            this.title = title;
        }
    }

    Text(Sentence title, Sentence... sentences) {
        this(title);
        for (Sentence s : sentences) {
            if (s != null) {
                this.value.add(s);
            }
        }
    }

    Text add(Sentence sentence) {
        if (sentence != null) {
            value.add(sentence);
        }
        return this;
    }

    Text add(Text text) {
        if (text != null) {
            value.addAll(text.get());
        }
        return this;
    }

    Text setTitle(Sentence theTitle) {
        if (theTitle != null) {
            title = theTitle;
        }
        return this;
    }


    Sentence getTitle() {
        return title;
    }

    String getText() {
        return getTheText();
    }

    ArrayList<Sentence> get() {
        return value;
    }

    @Override
    public String toString() {
        return title + "\n\n" + getTheText();
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Text)) {
            return false;
        }

        return title.equals(((Text) object).getTitle());
    }

    private String getTheText() {
        StringBuilder sb = new StringBuilder();
        for (Sentence s : value) {
            sb.append(s.toString());
        }
        return sb.toString();
    }

}
