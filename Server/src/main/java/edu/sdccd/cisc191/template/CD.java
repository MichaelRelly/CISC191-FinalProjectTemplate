package edu.sdccd.cisc191.template;

public class CD extends Media
{

    // Properties of CD
    private String artist;
    private int numberOfTracks;

    // CD constructor
    public CD(String title, String artist, int numberOfTracks, int playingTime) {
        super(title,artist,playingTime,MediaType.CD);
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
    }

    // getter for Artist
    public String getArtist()
    {
        return artist;
    }

    // getter for numberOfTracks
    public int getNumberOfTracks()
    {
        return numberOfTracks;
    }

    @Override
    // Display the properties of the CD in question
    public void displayContent() {
        System.out.print(
                this.getClass().getSimpleName() + ": " + super.title + " (" + super.durationInMinutes + " mins) \n"
                        + "    " + artist + "\n"
                        + "    " + "# tracks: " + numberOfTracks + "\n\n\n"
        );
    }

}