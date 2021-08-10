package netflix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Show extends StreamingVideo {

    protected int numSeasons;
    protected List<Season> listOfSeasons;

    public Show(String txtFile) throws FileNotFoundException {

        File showFile = new File(txtFile);
        Scanner fileScanner = new Scanner(showFile);
        title = fileScanner.nextLine().trim().split(":")[1].trim();
        rating = fileScanner.nextLine().trim().split(":")[1].trim();
        description = fileScanner.nextLine().trim().split(":")[1].trim();
        String[] castLine = fileScanner.nextLine().trim().split(":");
        String[] actors = castLine[1].trim().split(";");
        cast = Arrays.asList(actors);
        numSeasons = Integer.parseInt(fileScanner.nextLine().trim().split(":")[1].trim());
        int seasonNum = Integer.parseInt(fileScanner.nextLine().trim().split(":")[1].trim());
        List<Episode> listEp = new ArrayList();
        listOfSeasons = new ArrayList();
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            if (!line.contains("Season")) {
                Episode ep = new Episode(line);
                listEp.add(ep);
            } else {
                Season s = new Season(seasonNum, listEp);
                listOfSeasons.add(s);
                seasonNum = Integer.parseInt(line.trim().split(":")[1].trim());
                listEp = new ArrayList();
            }
        }
        Season s = new Season(seasonNum, listEp);
        listOfSeasons.add(s);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("TV show: ").append(title).append("\n\n");
        int counter = 1;
        for (Season s : listOfSeasons) {
            info.append(counter).append(") Season ").append(s.seasonNumber).append("\n");
            counter++;
        }
        info.append(counter).append(") Previous Menu\n\n");
        info.append("Chose episode");
        return info.toString();
    }

}
