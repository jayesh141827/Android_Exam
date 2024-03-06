package com.example.android_exam.Main_Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import com.example.android_exam.CHECK_SHIRT.Check_Shirt_main;
import com.example.android_exam.Over_size;
import com.example.android_exam.R;

import java.util.ArrayList;

public class fashion_Adapter extends RecyclerView.Adapter<fashion_Adapter.AdapterViewHolder> {
    Context context;
    ArrayList<Moden_class> l1;

    public fashion_Adapter(Context context, ArrayList<Moden_class> l1) {
        this.context = context;
        this.l1 = l1;

    }


    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fashion_taitl, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder( AdapterViewHolder holder, int position) {
        holder.image.setImageResource(l1.get(position).shirt_image);
        holder.name.setText(l1.get(position).shirt_name);
        holder.prace.setText(l1.get(position).shirt_price);
        holder.productRatingTxt.setText(l1.get(position).rate);
        holder.productReviewTxt.setText(l1.get(position).rativ);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();

                Intent intent = new Intent(context, Check_Shirt_main.class);
                intent.putExtra("name", l1.get(position).shirt_name);
                context.startActivity(intent);

                if (position==1){
                Intent intent1 = new Intent(context, Over_size.class);
                context.startActivity(intent1);

            }}
        });
    }

    @Override
    public int getItemCount() {
        return l1.size();
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {

        ImageView image, addtocard;
        TextView name, prace, productRatingTxt, productReviewTxt;
        LinearLayout card;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            prace = itemView.findViewById(R.id.prace);

            productRatingTxt = itemView.findViewById(R.id.productRatingTxt);
            productReviewTxt = itemView.findViewById(R.id.productReviewTxt);

            card = itemView.findViewById(R.id.card);
            addtocard = itemView.findViewById(R.id.addtocard);
        }
    }
}
