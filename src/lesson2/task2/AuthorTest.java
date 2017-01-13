package lesson2.task2;

import org.junit.Test;

/**
 * Created by default on 1/12/2017.
 */
public class AuthorTest {
    private Author author = new Author(null, null, null, 0);
    ;

    @Test
    public void getNick() throws Exception {
        assert author.getNick().equals("");
    }

    @Test
    public void getName() throws Exception {
        assert author.getName().equals("");
    }

    @Test
    public void getSurname() throws Exception {
        assert author.getSurname().equals("");
    }

    @Test
    public void getYearOfBirth() throws Exception {
        assert author.getYearOfBirth() == 0;
    }

}