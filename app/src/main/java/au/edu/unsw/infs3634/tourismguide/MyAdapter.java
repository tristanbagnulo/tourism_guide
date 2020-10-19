package au.edu.unsw.infs3634.tourismguide;

import android.content.Context;
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

    //Instantiate onNoteListener
    private OnNoteListener myOnNoteListener;


    //Constructor - Allows us to Initialises our class in main activity and pass values
    public MyAdapter(Context context, ArrayList<Sight> sights, OnNoteListener onNoteListener){
        this.context = context;
        this.sights = sights;
        //Create copy of the full ArrayList
        sightsFull = new ArrayList<>(sights);
        this.myOnNoteListener = onNoteListener;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view, myOnNoteListener);
    }

    //The onBindViewHolder class sets the text and image of each MyViewHolder object
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Sight sight = sights.get(position);

        //Holder is used to find name, type etc...
        holder.name.setText(sight.getName());
        holder.type.setText(sight.getType());
        holder.location.setText(sight.getLocation());
        holder.rating.setText(String.valueOf(sight.getRating()));
        holder.image.setImageResource(sight.getImageLocation());
    }

    @Override
    public int getItemCount() {
        return sights.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public static int SORT_METHOD_NAME;
        TextView name, type, location, rating;
        ImageView image;
        OnNoteListener onNoteListener;

        public MyViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            //Find id using itemView
            name = itemView.findViewById(R.id.tvName);
            type = itemView.findViewById(R.id.tvType);
            location = itemView.findViewById(R.id.tvLocation);
            rating = itemView.findViewById(R.id.tvRating);
            image = itemView.findViewById(R.id.ivImage);
            itemView.setOnClickListener(this);

            this.onNoteListener = onNoteListener;
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter(){

        @Override
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
                    if (item.getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            sights.clear();
            sights.addAll((ArrayList)results.values);
            notifyDataSetChanged();
        }
    };

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

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
