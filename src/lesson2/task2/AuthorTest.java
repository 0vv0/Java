package lesson2.task2;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Created by Oleksii.Sergiienko on 1/12/2017.
 */
public class AuthorTest {
    @Test
    public void getNick() throws Exception {
        Author author;
        author = new Author(null, null, null, -100);
        assert author.getNick().equals("");
        author = new Author("", null, null, -100);
        assert author.getNick().equals("");
        author = new Author("   ", null, null, -100);
        assert author.getNick().equals("   ");
        author = new Author("The Author!#!", null, null, -100);
        assert author.getNick().equals("The Author!#!");
    }

    @Test
    public void getName() throws Exception {
        Author author;
        author = new Author(null, null, null, -100);
        assert author.getName().equals("");
        author = new Author("", "", null, -100);
        assert author.getName().equals("");
        author = new Author("   ", "   ", null, -100);
        assert author.getName().equals("   ");
        author = new Author("The Author!#!", "John Joshua", null, -100);
        assert author.getName().equals("John Joshua");
    }

    @Test
    public void getSurname() throws Exception {
        Author author;
        author = new Author(null, null, null, -100);
        assert author.getSurname().equals("");
        author = new Author("", "", "", -100);
        assert author.getSurname().equals("");
        author = new Author("   ", "   ", "   ", -100);
        assert author.getSurname().equals("   ");
        author = new Author("The Author!#!", "John Joshua", "Petrovich\n\t", -100);
        assert author.getSurname().equals("Petrovich\n\t");
    }

    @Test
    public void getYearOfBirth() throws Exception {
        Author author;
        author = new Author(null, null, null, -100);
        assert author.getYearOfBirth()==0;
        author = new Author("", "", "", 999);
        assert author.getYearOfBirth()==0;
        author = new Author("   ", "   ", "   ", 1001);
        assert author.getYearOfBirth()==1001;
        author = new Author("The Author!#!", "John Joshua", "Petrovich\n\t", LocalDate.now().getYear());
        assert author.getYearOfBirth()== LocalDate.now().getYear();
    }

    @Test
    public void test_toString() throws Exception {
        Author author;
        author = new Author(null, null, null, -100);
        assert !Objects.isNull(author.toString());
    }
}