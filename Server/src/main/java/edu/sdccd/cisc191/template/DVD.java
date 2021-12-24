package edu.sdccd.cisc191.template;

public class DVD extends Video{

    // The one property of DVD not also common to other subclasses of Video
    private String director;


    // DVD constructor
    public DVD(String title, String director,int playingTime) {
        super(title,director,playingTime,VideoType.DVD);
        this.director = director;
    }

    // getter for director
    public String getDirector() {
        return director;
    }


    @Override
    // Display the properties of the DVD in question
    public void displayContent() {
        System.out.print(
                this.getClass().getSimpleName() + ": " + super.title + " (" + super.playingTime + " mins) \n"
                        + "    " + director + "\n\n\n"
        );
    }
}