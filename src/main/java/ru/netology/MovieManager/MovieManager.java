package ru.netology.MovieManager;

public class MovieManager {
    private String[] movie = new String[0];

    private final int limit;

    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void addMovie(String newMovie) {
        String[] tmp = new String[movie.length + 1];
        System.arraycopy(movie, 0, tmp, 0, movie.length);
        tmp[tmp.length - 1] = newMovie;
        movie = tmp;
    }

    public String[] findAll() {
        return movie;
    }

    public String[] findLast() {
        int resultLength;
        if (limit < movie.length) {
            resultLength = limit;
        } else {
            resultLength = movie.length;
        }

        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movie[movie.length - 1 - i];
        }
        return result;
    }
}
