package edu.sdccd.cisc191.template;

public class DVD extends Media{

    // The one property of DVD not also common to other subclasses of Media
    private String director;


    // DVD constructor
    public DVD(String title, String director,int playingTime) {
        super(title,director,playingTime,MediaType.DVD);
        this.director = director;
    }

    // getter for director
    public String getDirector()
    {
        return director;
    }


    @Override
    // Display the properties of the DVD in question
    public void displayContent() {
        System.out.print(
                this.getClass().getSimpleName() + ": " + super.title + " (" + super.durationInMinutes + " mins) \n"
                        + "    " + director + "\n\n\n"
        );
    }
}