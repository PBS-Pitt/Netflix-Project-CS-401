package netflix;

import java.util.List;

public class Season {

    protected int seasonNumber;
    protected List<Episode> listOfEp;

    public Season(int seasonNumber, List<Episode> listOfEp) {
        this.seasonNumber = seasonNumber;
        this.listOfEp = listOfEp;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Season #").append(seasonNumber).append("\n\n");
        int counter = 1;
        for (Episode ep : listOfEp) {
            info.append(counter).append(") ").append(ep.title).append("\n");
            counter++;
        }
        info.append(counter).append(") Previous Menu\n\n");
        info.append("Chose episode");
        
        return info.toString();

    }

}
