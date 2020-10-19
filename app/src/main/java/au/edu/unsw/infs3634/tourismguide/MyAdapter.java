package au.edu.unsw.infs3634.tourismguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    //Pass values that are needed for the project
    private ArrayList<Sight> sights;
    Context context;

    //Constructor - Allows us to Initialises our class in main activity and pass values
    public MyAdapter(Context context, ArrayList<Sight> sights){
        this.context = context;
        this.sights = sights;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
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

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, type, location, rating;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //Find id using itemView
            name = itemView.findViewById(R.id.tvName);
            type = itemView.findViewById(R.id.tvType);
            location = itemView.findViewById(R.id.tvLocation);
            rating = itemView.findViewById(R.id.tvRating);
            image = itemView.findViewById(R.id.ivImage);

        }
    }
}
