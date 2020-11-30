package ciolty.VideoDBImplementation.actions;

import ciolty.VideoDBImplementation.entities.MovieData;
import ciolty.VideoDBImplementation.entities.SeriesData;
import ciolty.VideoDBImplementation.entities.UserData;
import ciolty.VideoDBImplementation.entities.VideoData;
import ciolty.database.Filter;

import java.util.ArrayList;
import java.util.List;

public interface VideoAction extends MovieAction, SeriesAction {
    default List<VideoData> getAllVideosWithFilter(Filter filter) {
        List<VideoData> videos = new ArrayList<>();
        videos.addAll(getAllMoviesWithFilter(filter));
        videos.addAll(getAllSeriesWithFilter(filter));
        return videos;
    }

    default List<VideoData> getUnwatchedVideos(final UserData userData) {
        List<MovieData> unwatchedMovies = getUnwatchedMovies(userData);
        List<SeriesData> unwatchedSeries = getUnwatchedSeries(userData);

        List<VideoData> unwatchedVideos = new ArrayList<>();
        unwatchedVideos.addAll(unwatchedMovies);
        unwatchedVideos.addAll(unwatchedSeries);

        return unwatchedVideos;
    }

    default List<String> getUnwatchedVideosOfGenre(final UserData userData,
                                                           final String genre) {
        List<MovieData> unwatchedMovies = getUnwatchedMoviesOfGenre(userData, genre);
        List<SeriesData> unwatchedSeries = getUnwatchedSeriesOfGenre(userData, genre);
        List<String> unwatchedVideos = new ArrayList<>();

        unwatchedMovies.forEach(movie -> unwatchedVideos.add(movie.getTitle()));
        unwatchedSeries.forEach(series -> unwatchedVideos.add(series.getTitle()));

        return unwatchedVideos;
    }
}
