package au.edu.unsw.infs3634.tourismguide;

import java.util.ArrayList;

public class Sight {

    //The purpose of this class is to create Sight objects which contain a number of variables
    //that are called when data about a specifi sight is needed. It is called both within the
    //DetailActivity and MyAdapter classes.

    //Instantiate the variables
    private String name;
    private String type;
    private String location;
    private double rating;
    private int imageLocation;
    private String details;

    //Constructor
    public Sight(String name, String type, String location, double rating, int imageLocation, String details){
        this.name = name;
        this.type = type;
        this.location = location;
        this.rating = rating;
        this.imageLocation = imageLocation;
        this.details = details;
    }

    //Add getters and setters to allow access to the data
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

    //Sight details
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    //Stores all the data into an Array list which will be accessible by other classes
    public static ArrayList <Sight> getSights(){
        ArrayList<Sight> sights = new ArrayList<>();
            sights.add(new Sight("Bondi Beach", "Outdoor","Bondi, NSW", 4.6, R.drawable.bondibeach,"Bondi Beach is a popular beach and the name of the surrounding suburb in Sydney, Australia. It is located 7 kilometres east of the Sydney CBD. 'Bondi' or 'Boondi' is an Aboriginal word meaning water breaking over rocks or noise of water breaking over rocks."));
            sights.add(new Sight("Sydney Opera House","Famous Building","City of Sydney, NSW",4.7, R.drawable.sydneyoperahouse,"The Sydney Opera House constitutes a masterpiece of 20th century architecture. Its significance is based on its unparalleled design and construction; its exceptional engineering achievements and technological innovation and its position as a world-famous icon of architecture."));
            sights.add(new Sight("Sydney Harbour Bridge","Famous building","City of Sydney, NSW",4.7,R.drawable.sydneyharbourbridge,"The Sydney Harbour Bridge is the world's widest and tallest (but not longest) steel arch bridge. It takes 30,000 litres of paint to give the Bridge just one coat. Some parts of the Bridge last 30 years before painting, while other pieces are repainted every five years. The road surface is replaced every 15 years or so."));
            sights.add(new Sight("Port Jackson Bay","View","Port Jackson Bay, NSW",4.4,R.drawable.portjacksonbay,"Port Jackson, consisting of the waters of Sydney Harbour, Middle Harbour, North Harbour and the Lane Cove and Parramatta Rivers, is the ria or natural harbour of Sydney, New South Wales, Australia. The harbour is an inlet of the Tasman Sea (part of the South Pacific Ocean)."));
            sights.add(new Sight("Darling Harbour","View","City of Sydney, NSW",4.6,R.drawable.darlingharbour,"Darling Harbour is a harbour adjacent to the city centre of Sydney, New South Wales, Australia that is made up of a large recreational and pedestrian precinct that is situated on western outskirts of the Sydney central business district."));
            sights.add(new Sight("Royal Botanic Garden Sydney","Outdoor","City of Sydney, NSW",4.7,R.drawable.royalbotanicgarden,"The Royal Botanic Garden consist of 29 hectares (72 acres) of closely cultivated land surrounded by 51 hectares (130 acres) of open parklands comprising The Sydney Domain. The Garden forms a large natural amphitheatre, wrapped around and sloping down towards the 'stage' of Farm Cove."));
            sights.add(new Sight("Taronga Zoo Sydney","Attraction","Mosman, NSW",4.5,R.drawable.tarongazoo,"One of Sydney's most famous attractions, the award-winning Taronga Zoo is home to over 4,000 animals, including Australian native wildlife, as well as rare and endangered exotic animals. Overlooking the magnificent Sydney Harbour, Taronga Zoo is just 12 minutes from the city by ferry."));
            sights.add(new Sight("Sydney Tower Eye","Attraction","City of Sydney, NSW",4.3,R.drawable.sydneytowereye,"The Sydney Tower Eye - often referred to by Sydneysiders as Sydney Tower, Centrepoint Tower, AMP Tower, Westfield Centrepoint Tower or Sydney Skytower, amongst other names - has been an integral part of the famous Sydney skyline for the past 30 years. "));
            sights.add(new Sight("SEA LIFE Sydney Aquarium","Attraction","City of Sydney, NSW",4.3,R.drawable.sealifesydneyacquarium,"SEA LIFE Sydney Aquarium is a public aquarium that features a large variety of Australian aquatic life, displaying more than 700 species comprising more than 13,000 individual fish and other sea and water creatures from most of Australia's water habitats."));
            sights.add(new Sight("Manly Beach","Outdoor","Manly, NSW",4.6,R.drawable.manlybeach,"Manly BeachManly Beach is a world famous Australian landmark. It is one of the most renowned beaches for surfing. The beach was named by Capt. Arthur Phillip after the indigenous people living there writing: 'Their confidence and manly behaviour made me give the name of Manly Cove to this place'."));
        return sights;
    }
}
