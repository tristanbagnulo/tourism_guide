package au.edu.unsw.infs3634.tourismguide;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

    //Pass values that are needed for the project
    private ArrayList<Sight> sights;
    Context context;

    //Create a copy of the full data
    private ArrayList<Sight> sightsFull;

    //Create variable for sort method
    public static final int SORT_METHOD_NAME = 1;
    public static final int SORT_METHOD_RATING = 2;

    //Instantiate onClickListener
    private OnClickListener myOnClickListener;


    //Constructor - Allows us to Initialises our class in main activity and pass values
    public MyAdapter(Context context, ArrayList<Sight> sights, OnClickListener onClickListener){
        this.context = context;
        this.sights = sights;

        //Create copy of the full ArrayList to act as our list that isn't filtered or sorted at
        //all
        sightsFull = new ArrayList<>(sights);
        this.myOnClickListener = onClickListener;


    }

    //This specifies the my_row.xml file as the thing that will be inflated and what represents a
    //single "view" of which the RecyclerView comprises of many.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view, myOnClickListener);
    }

    //The onBindViewHolder class sets the text and image of each MyViewHolder object
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Sight sight = sights.get(position);

        //Holder is used to find name, type etc...
        holder.name.setText(sight.getName());
        holder.type.setText("Type: "+sight.getType());
        holder.location.setText("Location: "+sight.getLocation());
        holder.rating.setText("Rating: "+String.valueOf(sight.getRating()));
        holder.image.setImageResource(sight.getImageLocation());
        holder.itemView.setTag(sight.getName());
    }

    //Keeps track of how many objects (and therefore, potential views) appear in the RecyclerView.
    @Override
    public int getItemCount() {
        return sights.size();
    }

    //This does a number of things
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public static int SORT_METHOD_NAME;
        TextView name, type, location, rating;
        ImageView image;
        OnClickListener onClickListener;

        //Constructor
        public MyViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);
            //Assigns a variable to a reference for the components within the layout in my_row
            //this allows them to be referenced above in onBindViewHolder
            name = itemView.findViewById(R.id.tvName);
            type = itemView.findViewById(R.id.tvType);
            location = itemView.findViewById(R.id.tvLocation);
            rating = itemView.findViewById(R.id.tvRating);
            image = itemView.findViewById(R.id.ivImage);
            //Find id using itemView
            itemView.setOnClickListener(this);
            //Instantiates the
            this.onClickListener = onClickListener;
        }

        @Override
        //When a given view is selected("clicked") we send that view and an identifying string or
        //"tag" which is used to select the right data to display in the DetailActivity.
        public void onClick(View v) {
            onClickListener.onClick(v, v.getTag().toString());
            Log.d("MVH onClick tag","Text data "+ v.getTag());
        }
    }

    //Create teh filter object
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    //Declare and instantiate the Filter object.
    private Filter exampleFilter = new Filter(){

        @Override
        //Here is where filtering occurs. This is what enables sorting via rating
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Sight> filteredList = new ArrayList<>();

            //Show everything if there are no filter criteria
            if (constraint==null||constraint.length()==0){
                filteredList.addAll(sightsFull);
            } else {
                //Prepare the input for filtering by removing cases and extra spaces
                String filterPattern = constraint.toString().toLowerCase().trim();
                //Iterate through all items in the list and see whether it fits
                for (Sight item: sightsFull){
                    if (item.getDetails().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            //Now assign the filtered objects to a new ArrayList which so that it can be refrenced
            //later on.
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        //Here, the filtered results are used i.e. displated. Now, the only thing that the user
        //will see in the MainActivity's display is the views of the objects (sights)
        //that that specified
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            sights.clear();
            sights.addAll((ArrayList)results.values);
            notifyDataSetChanged();
        }
    };

    //Similar to the filtering stuff but it just reorganises what appears at the top of the
    //RecyclerView based on a sorting criterion. In this case, it's name.
    public void sort(final int sortMethod){
        //if(sights.size()>0){
            Collections.sort(sights, new Comparator<Sight>(){
                @Override
                public int compare (Sight o1, Sight o2){
                    if(sortMethod == MyViewHolder.SORT_METHOD_NAME) {
                        return o1.getName().compareTo(o2.getName());
                    }else if(sortMethod == SORT_METHOD_RATING){
                        return Double.compare(o2.getRating(),o1.getRating());
                    }
                    return Double.compare(o2.getRating(),o1.getRating());
                }
            });
        //}
        notifyDataSetChanged();
    }

    //This is an interface which specifies that everywhere that OnClickListener is called,
    //the method onClick must be used and it must contain the parameters of a View and a String
    public interface OnClickListener {
        void onClick(View v, String name);
    }
}
