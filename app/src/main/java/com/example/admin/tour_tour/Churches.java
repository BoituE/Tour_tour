package com.example.admin.tour_tour;

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

public class Churches extends AppCompatActivity {


    private RecyclerView recyclerView;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_churches);



        myRef = FirebaseDatabase.getInstance().getReference().child("/churches");

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerAdapter<Blog,BlogViewHolder> adapter =new FirebaseRecyclerAdapter<Blog, Churches.BlogViewHolder>(
                Blog.class,
                R.layout.individual_row,
                Churches.BlogViewHolder.class,
                myRef
        ) {
            @Override
            protected void populateViewHolder(Churches.BlogViewHolder viewHolder, Blog model, int position) {
                viewHolder.setName(model.getName());
                viewHolder.setAddress(model.getAddress());
                viewHolder.setImage(model.getImage());

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

