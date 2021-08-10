package netflix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Movie extends StreamingVideo {

    protected String releaseYear;
    protected String runtime;
    protected String prodComp;

    public Movie(String txtFile) throws FileNotFoundException {
        File movieFile = new File(txtFile);
        Scanner fileScanner = new Scanner(movieFile);
        title = fileScanner.nextLine().trim().split(":")[1].trim();
        rating = fileScanner.nextLine().trim().split(":")[1].trim();
        description = fileScanner.nextLine().trim().split(":")[1].trim();
        releaseYear = fileScanner.nextLine().trim().split(":")[1].trim();
        runtime = fileScanner.nextLine().trim().split(":")[1].trim();
        prodComp = fileScanner.nextLine().trim().split(":")[1].trim();
        cast = new ArrayList();
        String[] castLine = fileScanner.nextLine().trim().split(":");
        String[] actors = castLine[1].trim().split(";");
        cast = Arrays.asList(actors);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Movie Title: ").append(title).append("\n");
        info.append("Viewer rating: ").append(rating).append("\n");
        info.append("Description: ").append(description).append("\n");
        info.append("Release Year: ").append(releaseYear).append("\n");
        info.append("Runtime: ").append(runtime).append("\n");
        info.append("Production company: ").append(prodComp).append("\n");
        info.append("Casting: ");
        int counter = 0;
        for (String actor : cast) {
            info.append(actor);
            counter++;
            if(!(counter == cast.size())){
                info.append(", ");
            }
        }
        return info.toString();
    }

}
