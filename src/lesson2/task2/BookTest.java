package lesson2.task2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Oleksii.Sergiienko on 1/12/2017.
 */
public class BookTest {
    @Test
    public void getId() throws Exception {
        Book book;
        book = new Book.Builder().build();
        assert book.getId()==0;
        assert book.getId()==0;
        assert new Book.Builder().build().getId()==1;
        book=new Book.Builder().build();
        assert book.getId()==2;
    }

    @Test
    public void getTitle() throws Exception {
        Book book;
        book = new Book.Builder().build();
        assert book.getTitle().equals("");
    }

    @Test
    public void getAuthor() throws Exception {

    }

    @Test
    public void getPrintedBy() throws Exception {

    }

    @Test
    public void getYear() throws Exception {

    }

    @Test
    public void getVolume() throws Exception {

    }

    @Test
    public void isSoftBinding() throws Exception {

    }

}