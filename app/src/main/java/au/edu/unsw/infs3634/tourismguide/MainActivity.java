package au.edu.unsw.infs3634.tourismguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create an ImageView object
        ImageView image = findViewById(R.id.ivImage);
        //Re-create the ArrayList in MainActivity
        ArrayList<Sight> sights = Sight.getSights();

        //Assign a given variable from within a given Sight object to the variable "st"
        String st = sights.get(1).getImageLocation();

        //Testing with a log (will appear in Logcat)
        Log.d("TestingTAG", st);


        int imageResource = getResources().getIdentifier("@drawable/"+st,null,getPackageName());
        image.setImageResource(imageResource);
    }
}