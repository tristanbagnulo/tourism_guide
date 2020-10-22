package au.edu.unsw.infs3634.tourismguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
    private TextView description;
    private Button moreInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Initialise the views
        name = findViewById(R.id.tvName);
        location = findViewById(R.id.tvLocation);
        image = findViewById(R.id.ivImage);
        rating = findViewById(R.id.tvRating);
        moreInfo = findViewById(R.id.btMoreInfo);
        description = findViewById(R.id.tvDescription);

        Intent intent= getIntent();
        String sightName= intent.getStringExtra(INTENT_MESSAGE);




        //Declare variables for the views in activity_detail.xml
        //Search to find the correct Sight object given the sight name

        ArrayList<Sight> sights = Sight.getSights();
        for(Sight sight : sights) {
            if (sight.getName().equals(sightName)) {
                name.setText(sight.getName());
                location.setText(sight.getLocation());
                rating.setText(String.valueOf(sight.getRating()));
                //description.setText(sight.getDescription());
                image.setImageResource(sight.getImageLocation());

                moreInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWebsite();
                    }
                });
            } else {
                name.setText("Test name");
                location.setText("Test Location");
                rating.setText(String.valueOf(5.0));
                //description.setText(sight.getDescription());
                image.setImageResource(R.drawable.ic_filter);
                moreInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWebsite();
                    }
                });
            }
        }
    }

    public void openWebsite(){
        //int position = getPosition();
        //Sight sight = sights.get(1);//position);
        Intent browserIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("http://www.google.com/search?q="+"yoooo"));
        startActivity(browserIntent);
    }
}
