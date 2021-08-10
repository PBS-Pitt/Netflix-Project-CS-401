package netflix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Netflix {

    public static void main(String[] args) throws FileNotFoundException {
        new Netflix();
    }
    List<Movie> movies = new ArrayList();
    List<Show> shows = new ArrayList();

    public Netflix() {
// reading all movies and tv series from text file (simulating a database)
        List<StreamingVideo> listOfStreamingVideos = readStreamVideoDatabase();
        showMainMenu();
    }

    private List<StreamingVideo> readStreamVideoDatabase() {
        List<StreamingVideo> streamVideoList = new ArrayList();

        File databaseFile = new File("/Users/Pau/NetBeansProjects/netflix/src/netflix/StreamVideoDatabase.txt");
        try {
            Scanner fileScanner = new Scanner(databaseFile);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] items = line.trim().split("=");
                if (items[0].trim().equalsIgnoreCase("tv_show")) {
                    streamVideoList.add(new Show(items[1].trim()));
                    shows.add(new Show(items[1].trim()));
                } else {
                    streamVideoList.add(new Movie(items[1].trim()));
                    movies.add(new Movie(items[1].trim()));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Netflix.class.getName()).log(Level.SEVERE, null, ex);
        }
        return streamVideoList;
    }

    private void showMainMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Netflix App:\n\n");
        sb.append("1) Movies").append("\n");
        sb.append("2) TV Shows").append("\n");
        sb.append("3) Exit").append("\n\n");
        sb.append("Please select an option:\n\n");
        sb.toString();

        int userAnswer = Integer.parseInt(JOptionPane.showInputDialog(sb));

        if (userAnswer == 1) {
            showMoviesMenu();
        }
        if (userAnswer == 2) {
            showTVShowMenu();
        }
        if (userAnswer == 3) {
            System.exit(0);
        }
    }

    private void showMoviesMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of Movies:\n\n");
        int counter = 1;
        for (Movie current : movies) {
            sb.append(counter).append(") ").append(movies.get(counter - 1).title).append("\n");
            counter++;
        }
        sb.append(counter).append(") Exit").append("\n\n");
        sb.append("Please select an option:\n\n");
        sb.toString();

        int userAnswer = Integer.parseInt(JOptionPane.showInputDialog(sb));

        if (userAnswer == 1) {
            showSpecificMovieInfo(movies.get(0));
        }
        if (userAnswer == 2) {
            showSpecificMovieInfo(movies.get(1));
        }
        if (userAnswer == 3) {
            showMainMenu();
        }

    }

    private void showSpecificMovieInfo(Movie movie) {
        JOptionPane.showMessageDialog(null, movie);
    }

    private void showTVShowMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of TV Shows:\n\n");
        int counter = 1;
        for (Show current : shows) {
            sb.append(counter).append(") ").append(shows.get(counter - 1).title).append("\n");
            counter++;
        }
        sb.append(counter).append(") Exit").append("\n\n");
        sb.append("Please select an option:\n\n");
        sb.toString();

        int userAnswer = Integer.parseInt(JOptionPane.showInputDialog(sb));

        if (userAnswer == 1) {
            showSpecificTVShowMenu(shows.get(0));
        }
        if (userAnswer == 2) {
            showSpecificTVShowMenu(shows.get(1));
        }
        if (userAnswer == 3) {
            showMainMenu();
        }

    }

    private void showSpecificTVShowMenu(Show tvShow) {
        int userAnswer = Integer.parseInt(JOptionPane.showInputDialog(tvShow));
        for (int i = 0; i < tvShow.numSeasons; i++) {
            if (userAnswer-1 == i) {
                showSpecificTVShowSeason(tvShow.listOfSeasons.get(i), tvShow);
            }
            if (userAnswer == (tvShow.numSeasons + 1)) {
                showTVShowMenu();
            }
        }

    }

    private void showSpecificTVShowSeason(Season tvShowSeason, Show tvShow) {
        int userAnswer = Integer.parseInt(JOptionPane.showInputDialog(tvShowSeason));
        for (int i = 0; i < tvShowSeason.listOfEp.size(); i++) {
            if (userAnswer-1 == i) {
                showSpecificTVShowSeasonEpisode(tvShowSeason.listOfEp.get(i));
            }
            if (userAnswer == (tvShowSeason.listOfEp.size() + 1)) {
                showSpecificTVShowMenu(tvShow);
            }
        }
    }

    private void showSpecificTVShowSeasonEpisode(Episode episode) {
        JOptionPane.showMessageDialog(null, episode);
    }

}
