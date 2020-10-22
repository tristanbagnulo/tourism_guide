package au.edu.unsw.infs3634.tourismguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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

        //Initialise RecyclerView
        mRecyclerView = findViewById(R.id.rvList);
        //Boilerplate - (increases functionality)
        mRecyclerView.setHasFixedSize(true);

        //Implement a click listener to launch the Detail Activity
        MyAdapter.OnClickListener listener = new MyAdapter.OnClickListener(){
            @Override
            public void onClick (View v, String name){
                Log.d("String in onClick MainA","Extra data "+name);
                launchDetailActivity(name);
            }
        };
        //Initialise the adapter
        myAdapter= new MyAdapter(this, Sight.getSights(), listener);

        //Link Adapter and Recycler View
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    //This method opens DetailActivity and passes a String which holds the name of the sight
    //that was clicked in the RecyclerView.
    private void launchDetailActivity(String message){
        Log.d("String in lDA","Extra data "+message);
        Intent intent = new Intent (this, DetailActivity.class);
        intent.putExtra(DetailActivity.INTENT_MESSAGE, message);
        startActivity(intent);
    }

    //This adds a menu to the top of the Recyclerview. It supports the search function
    //wherein a user types a word or phrase that they want to see.
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

    //This supports the sorting function of the app. Basically, it sorts by the sorting factor
    //that was selected in from the main activity display.
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
}