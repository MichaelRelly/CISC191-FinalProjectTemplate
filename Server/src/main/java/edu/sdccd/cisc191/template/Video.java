package edu.sdccd.cisc191.template;

public class Video implements Media {
    public int playingTime;
    public String title;
    private Enum<VideoType> type;
    private String director;

    public Video(String title, String director,int playingTime, Enum<VideoType> type) {
        this.title = title;
        this.playingTime = playingTime;
        this.director = director;
        this.type = type;
    }

    public String getType(){
        return type.toString();
    }

    public int getPlayingTime() {
        return playingTime;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public void displayContent() {
        System.out.print(
                type.toString() + ": " + title + " (" + playingTime + " mins) \n"
                        + "    " + director + "\n\n\n"
        );

    }
}
