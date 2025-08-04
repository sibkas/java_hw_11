package ru.netology.MovieManagerTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.MovieManager.MovieManager;

public class MovieManagerTest {

    @Test
    public void shouldAddMoviesAndFindAll() {
        MovieManager manager = new MovieManager();
        manager.addMovie("1");
        manager.addMovie("2");
        String[] expected = {"1", "2"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("1");
        manager.addMovie("2");
        manager.addMovie("3");
        manager.addMovie("4");
        String[] expected = {"4", "3", "2"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenNoMovies() {
        MovieManager manager = new MovieManager();
        Assertions.assertArrayEquals(new String[]{}, manager.findAll());
        Assertions.assertArrayEquals(new String[]{}, manager.findLast());
    }

    @Test
    public void shouldWorkWithOneMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("1");
        Assertions.assertArrayEquals(new String[]{"1"}, manager.findAll());
        Assertions.assertArrayEquals(new String[]{"1"}, manager.findLast());
    }

    @Test
    public void shouldReturnAllWhenMoviesLessThanLimit() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie("1");
        manager.addMovie("2");
        manager.addMovie("3");
        Assertions.assertArrayEquals(new String[]{"3", "2", "1"}, manager.findLast());
    }

    @Test
    public void shouldReturnCorrectWhenMoviesEqualLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("1");
        manager.addMovie("2");
        manager.addMovie("3");
        Assertions.assertArrayEquals(new String[]{"3", "2", "1"}, manager.findLast());
    }

    @Test
    public void shouldReturnLastWhenMoviesMoreThanLimit() {
        MovieManager manager = new MovieManager(2);
        manager.addMovie("1");
        manager.addMovie("2");
        manager.addMovie("3");
        Assertions.assertArrayEquals(new String[]{"3", "2"}, manager.findLast());
    }

    @Test
    public void shouldUseDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("1");
        manager.addMovie("2");
        manager.addMovie("3");
        manager.addMovie("4");
        manager.addMovie("5");
        manager.addMovie("6");

        String[] expected = {"6", "5", "4", "3", "2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
