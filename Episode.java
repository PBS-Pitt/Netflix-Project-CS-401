
package netflix;

public class Episode {
    
    protected int episodeNum;
    protected int seasonEpisodeNum;
    protected String title;
    protected String releaseDate;
    
    //"1;1;Pilot;3/24/2005"
    
    public Episode(String episodeLine){
        String[] items = episodeLine.trim().split(";");
        episodeNum = Integer.parseInt(items[0].trim());
        seasonEpisodeNum = Integer.parseInt(items[1].trim());
        title = items[2].trim();
        releaseDate = items[3].trim();         
    }
    
     @Override
    public String toString(){
        StringBuilder info = new StringBuilder();
        info.append("Episode Facts:\n\n");
        info.append("Episode Title: ").append(title).append("\n");
        info.append("Season Episode Number: ").append(seasonEpisodeNum).append("\n");
        info.append("Overall Episode Number: ").append(episodeNum).append("\n");
        info.append("Episode Release Date: ").append(releaseDate).append("\n");
        
        return info.toString();
    }
    
}
