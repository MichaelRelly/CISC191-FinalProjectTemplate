package edu.sdccd.cisc191.template;

public class Video implements Media, Comparable<Video> {
    // Properties of Video class
    public int playingTime;
    public String title;
    private Enum<VideoType> type;
    private String director;

    // Constructor for objects of class Video
    public Video(String title, String director,int playingTime, Enum<VideoType> type) {
        this.title = title;
        this.playingTime = playingTime;
        this.director = director;
        this.type = type;
    }

    // Getter for type
    public String getType(){
        return type.toString();
    }

    // Getter for playingTime
    public int getPlayingTime() {
        return playingTime;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for director
    public String getDirector() {
        return director;
    }

    @Override // override not necessary TODO
    // Print properties of the Video in question
    public void displayContent() {
        System.out.print(
                type.toString() + ": " + title + " (" + playingTime + " mins) \n"
                        + "    " + director + "\n\n\n"
        );

    }
}
