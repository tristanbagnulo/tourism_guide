package au.edu.unsw.infs3634.tourismguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3634.tourismguide";
    //public ArrayList<Sight> sights;

    private TextView name;
    private TextView location;
    private ImageView image;
    private TextView rating;
    private TextView details;
    private Button moreInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Declare variables that reference the views in activity_detail.xml
        name = findViewById(R.id.tvName);
        location = findViewById(R.id.tvLocation);
        image = findViewById(R.id.ivImage);
        rating = findViewById(R.id.tvRating);
        moreInfo = findViewById(R.id.btMoreInfo);
        details = findViewById(R.id.tvDetails);

        Intent intent= getIntent();
        //Take the name of the sight who's view was selected
        String sightName= intent.getStringExtra(INTENT_MESSAGE);



        //Search to find the correct Sight object given the sight name

        //Call the ArrayList which contains Sight objects from within the
        //Sight.java file
        ArrayList<Sight> sights = Sight.getSights();

        //Note go through it to find the Sight object within the ArrayList that matches with the
        //name you received from the click
        for(final Sight sight : sights) {
            Log.d( "sightName value", "|"+sightName+"|");
            Log.d("getName() value", "|"+sight.getName()+"|");
            if (sight.getName().equals(sightName)) {
                //Once you find it, go ahead and allocate that object's (sight's) data
                //the the views within the Details activity
                name.setText(sight.getName());
                location.setText("Location: "+sight.getLocation());
                rating.setText("Rating: "+ String.valueOf(sight.getRating()));
                details.setText("Details:\n"+ sight.getDetails());
                image.setImageResource(sight.getImageLocation());

                //This calls the openWebsite method
                moreInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWebsite(sight.getName());
                    }
                });


                break;
            //This is just for testing in case the name data didn't appear
            } else {
                name.setText("Test name");
                location.setText("Test Location");
                rating.setText(String.valueOf(5.0));
                //details.setText(sight.getDetails());
                image.setImageResource(R.drawable.ic_filter);
                moreInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWebsite("Random website");
                    }
                });
            }
        }
    }

    //This method basically starts up the browser using the build-ing Uri.parse class & method
    //which is one of the importable java classes. It will add a basic google search query
    //to the browser's search bar along with the name of the sight. This is in the form of a string
    //that was specified when the openWebsite method was called form within the onCreate class.
    public void openWebsite(String theName){
        Intent browserIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://www.google.com/search?q="+theName));
        startActivity(browserIntent);
    }
}
