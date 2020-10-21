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
    private ImageView imageLocation;
    private TextView rating;
    private TextView description;
    private Button moreInfo;

    private static ArrayList<Sight> sights = new ArrayList<Sight>;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        moreInfo = findViewById(R.id.btMoreInfo);
        }



    public void openWebsite(View view){
        int position = getPosition();
        Sight sight = sights.get(1);//position);
        Intent browserIntent = new Intent (Intent.ACTION_VIEW, Uri.parse(sight.getWebSearch()));
        startActivity(browserIntent);
    }

    public int getPosition()






}