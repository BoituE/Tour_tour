package com.example.admin.tour_tour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Restaurants extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

       // AlertDialog.Builder dialogBuilder =new AlertDialog.Builder(this);
      // LayoutInflater inflater =this.getLayoutInflater();
       // View dialogView = inflater.inflate(R.layout.alert, null);
       // dialogBuilder.setView(dialogView);

        //EditText editText = (EditText) dialogView.findViewById(R.id.edit_history);
      // editText.setText("test label");
        //AlertDialog alertDialog = dialogBuilder.create();
     //  alertDialog.show();


        myRef = FirebaseDatabase.getInstance().getReference().child("/restaurants");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerAdapter<Blog,BlogViewHolder> adapter =new FirebaseRecyclerAdapter<Blog, Restaurants.BlogViewHolder>(
                Blog.class,
                R.layout.individual_row,
                Restaurants.BlogViewHolder.class,
                myRef
        ) {
            @Override
            protected void populateViewHolder(Restaurants.BlogViewHolder viewHolder, Blog model, int position) {
                viewHolder.setName(model.getName());
                viewHolder.setAddress(model.getAddress());
                viewHolder.setImage(model.getImage());

                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent awe = new Intent(Restaurants.this, DetailsActivity.class);
                        startActivity(awe);
                    }
                });

            }
        };


        recyclerView.setAdapter(adapter);

    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        TextView text_name,text_address;
        ImageView imageview;
        public BlogViewHolder(View itemView) {
            super(itemView);
            text_name=(TextView)itemView.findViewById(R.id.name);
            text_address=(TextView)itemView.findViewById(R.id.address);
            imageview=(ImageView)itemView.findViewById(R.id.imageview);
        }



        public void setName(String name) {
            text_name.setText(name);
        }

        public void setAddress(String address) {
            text_address.setText(address);
        }

        public void setImage(String image) {
            Picasso.with(itemView.getContext())
                    .load(image)
                    .resize(500, 500)
                    .centerCrop()
                    .into(imageview);

        }
    }
}
