package ciolty.VideoDBImplementation.entities;

import fileio.ShowInput;

import java.util.ArrayList;

public abstract class VideoData {
    private final String title;
    private final int year;
    private final ArrayList<String> cast;
    private final ArrayList<String> genres;
    protected int priority;

    /**
     * Should be implemented by Movie and Series
     * @return rating of video
     */
    public abstract double getRating();

    /**
     * @param rating
     */
    public abstract void setRating(double rating);

    /**
     * @return number of ratings
     */
    public abstract int getNumberOfRatings();

    /**
     * @param numberOfRatings
     */
    public abstract void setNumberOfRatings(int numberOfRatings);

    /**
     * Should be implemented by Movie and Series
     * @return duration of video
     */
    public abstract int getDuration();

    public VideoData() {
        this.title = null;
        this.year = 0;
        this.cast = null;
        this.genres = null;
    }

    public VideoData(final ShowInput inputData) {
        this.title = inputData.getTitle();
        this.year = inputData.getYear();
        this.cast = inputData.getCast();
        this.genres = inputData.getGenres();
    }

    public final String getTitle() {
        return title;
    }

    public final int getYear() {
        return year;
    }

    public final ArrayList<String> getCast() {
        return cast;
    }

    public final ArrayList<String> getGenres() {
        return genres;
    }
}
