package edu.sdccd.cisc191.template;

public class Media implements Playable, Comparable<Media> {
    // Properties of objects of class Media
    public int durationInMinutes;
    public String title;
    private Enum<MediaType> type;
    private String producer;

    // Constructor for objects of class Media
    public Media(String title, String producer,int durationInMinutes, Enum<MediaType> type) {
        this.title = title;
        this.durationInMinutes = durationInMinutes;
        this.producer = producer;
        this.type = type;
    }

    // Getter for type
    public String getType()
    {
        return type.toString();
    }

    // Getter for playingTime
    public int getDurationInMinutes()
    {
        return durationInMinutes;
    }

    // Getter for title
    public String getTitle()
    {
        return title;
    }

    // Getter for director
    public String getDirector()
    {
        return producer;
    }

    // Print properties of the Media in question
    public void displayContent()
    {
        System.out.print(
                type.toString() + ": " + title + " (" + durationInMinutes + " mins) \n"
                        + "    " + producer + "\n\n\n"
        );

    }

    @Override
    public int compareTo(Media o) {
        int retVal = this.title.compareToIgnoreCase(o.title);
        int typeVal = this.type.toString().compareToIgnoreCase(o.type.toString());

        if (retVal != 0) {
            return retVal;
        } if (typeVal != 0) {
            return typeVal;
        } else {
            return this.producer.compareToIgnoreCase(o.producer);
        }
    }
}