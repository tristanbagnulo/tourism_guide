package au.edu.unsw.infs3634.tourismguide;

import java.util.ArrayList;

public class Sight {

    //Instantiate the variables
    private String name;
    private String type;
    private String location;
    private double rating;
    private int imageLocation;
    private String webSearch;

    //Constructor
    public Sight(String name, String type, String location, double rating, int imageLocation){
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

    public int getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(int imageLocation) {
        this.imageLocation = imageLocation;
    }

    //Web search URL
    public String getWebSearch() {
        return webSearch;
    }

    public void setWebSearch(String webSearch) {
        this.webSearch = webSearch;
    }

    //Store data into an Array list which will be accessible by other classes
    public static ArrayList <Sight> getSights(){
        ArrayList<Sight> sights = new ArrayList<>();
            sights.add(new Sight("Bondi Beach", "Outdoor","Bondi, NSW", 4.6, R.drawable.bondibeach));
            sights.add(new Sight("Sydney Opera House","Famous Building","City of Sydney, NSW",4.7, R.drawable.sydneyoperahouse));
            sights.add(new Sight("Sydney Harbour Bridge","Famous building","City of Sydney, NSW",4.7,R.drawable.sydneyharbourbridge));
            sights.add(new Sight("Port Jackson Bay","View","Port Jackson Bay, NSW",4.4,R.drawable.portjacksonbay));
            sights.add(new Sight("Darling Harbour","View","City of Sydney, NSW",4.6,R.drawable.darlingharbour));
            sights.add(new Sight("Royal Botanic Garden Sydney","Outdoor","City of Sydney, NSW",4.7,R.drawable.royalbotanicgarden));
            sights.add(new Sight("Taronga Zoo Sydney","Attraction","Mosman, NSW",4.5,R.drawable.tarongazoo));
            sights.add(new Sight("Sydney Tower Eye","Attraction","City of Sydney, NSW",4.3,R.drawable.sydneytowereye));
            sights.add(new Sight("SEA LIFE Sydney Aquarium","Attraction","City of Sydney, NSW",4.3,R.drawable.sealifesydneyacquarium));
            sights.add(new Sight("Manly Beach","Outdoor","Manly, NSW",4.6,R.drawable.manlybeach));

        return sights;
    }
}
