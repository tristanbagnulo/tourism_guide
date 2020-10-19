package au.edu.unsw.infs3634.tourismguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create an ImageView object
        //ImageView image = findViewById(R.id.ivImage);
        //Re-create the ArrayList in MainActivity
        ArrayList<Sight> sights = Sight.getSights();

        //Assign a given variable from within a given Sight object to the variable "st"
        //String st = sights.get(1).getImageLocation();

        //Testing with a log (will appear in Logcat)
        //Log.d("TestingTAG", st);

        //Initialise RecyclerView
        mRecyclerView = findViewById(R.id.rvList);
        //Boilerplate - (increases functionality)
        mRecyclerView.setHasFixedSize(true);

        //Initialise the adapter
        myAdapter= new MyAdapter(this, Sight.getSights(), this);

        //Link Adapter and Recycler View
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //int imageResource = getResources().getIdentifier("@drawable/"+st,null,getPackageName());
        //image.setImageResource(imageResource);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.sort_rating:
                myAdapter.sort(MyAdapter.SORT_METHOD_RATING);
                return true;
            case R.id.sort_name:
                myAdapter.sort(MyAdapter.SORT_METHOD_NAME);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }

}