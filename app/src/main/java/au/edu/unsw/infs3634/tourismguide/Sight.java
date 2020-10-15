package au.edu.unsw.infs3634.tourismguide;

import java.util.ArrayList;

public class Sight {

    //Instantiate the variables
    private String name;
    private String type;
    private String location;
    private double rating;
    private String imageLocation;


    //Constructor
    public Sight(String name, String type, String location, double rating, String imageLocation){
        this.name = name;
        this.type = type;
        this.location = location;
        this.rating = rating;
        this.imageLocation = imageLocation;
    }

    //Add getters and setters to allow access to the data
    //Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //Type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //Location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    //Rating
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    //Image location
    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    //Store data into an Array list which will be accessible by other classes
    public static ArrayList <Sight> getSights(){
        ArrayList<Sight> sights = new ArrayList<>();
            sights.add(new Sight("Bondi Beach", "Outdoor","Bondi, NSW", 4.6, "bondibeach"));
            sights.add(new Sight("Sydney Opera House","Famous Building","City of Sydney, NSW",4.7, "sydneyoperahouse"));
            sights.add(new Sight("Sydney Harbour Bridge","Famous building","City of Sydney, NSW",4.7,"sydneyharbourbridge"));
            sights.add(new Sight("Port Jackson Bay","View","Port Jackson Bay, NSW",4.4,"portjacksonbay"));
            sights.add(new Sight("Darling Harbour","View","City of Sydney, NSW",4.6,"darlingharbour"));
            sights.add(new Sight("Royal Botanic Garden Sydney","Outdoor","City of Sydney, NSW",4.7,"royalbotanicgardensydney"));
            sights.add(new Sight("Taronga Zoo Sydney","Attraction","Mosman, NSW",4.5,"tarongazoosydney"));
            sights.add(new Sight("Sydney Tower Eye","Attraction","City of Sydney, NSW",4.3,"sydneytowereye"));
            sights.add(new Sight("SEA LIFE Sydney Aquarium","Attraction","City of Sydney, NSW",4.3,"sealifesydneyaquarium"));
            sights.add(new Sight("Manly Beach","Outdoor","Manly, NSW",4.6,"manlybeach"));
        return sights;
    }
}
