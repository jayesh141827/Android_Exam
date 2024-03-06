package com.example.android_exam.CHECK_SHIRT;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_exam.MainActivity;
import com.example.android_exam.Over_size;
import com.example.android_exam.R;

import java.util.ArrayList;

public class Check_Adapter extends RecyclerView.Adapter<Check_Adapter.checkshirtViewHolder> {
    Context context;
    ArrayList<Check_Moden> l1;

    public Check_Adapter(Context context, ArrayList<Check_Moden> l1) {
        this.context = context;
        this.l1 = l1;
    }


    @Override
    public checkshirtViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.check_shirt, parent, false);
        return new checkshirtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(checkshirtViewHolder holder, int position) {

        holder.productImageView.setImageResource(l1.get(position).shirt_image);
        holder.titleTextView.setText(l1.get(position).shirt_name);
        holder.priceTextView.setText(l1.get(position).shirt_price);
        holder.productRatingTxt.setText(l1.get(position).rate);
        holder.productReviewTxt.setText(l1.get(position).rativ);

        holder.addToCartButton.setTag(position);
        holder.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);

            }
        });

        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemPosition = (int) view.getTag();
                addToCart(itemPosition);
            }
        });
    }

     void addToCart(int position) {
        Toast.makeText(context, "Item added to cart: " + l1.get(position).shirt_name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return l1.size();
    }

     class checkshirtViewHolder extends RecyclerView.ViewHolder {
        ImageView productImageView, back;
        TextView titleTextView, priceTextView, productRatingTxt, productReviewTxt;
        Button addToCartButton;


        public checkshirtViewHolder(View itemView) {
            super(itemView);
            productImageView = itemView.findViewById(R.id.productImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
            productRatingTxt = itemView.findViewById(R.id.productRatingTxt);
            productReviewTxt = itemView.findViewById(R.id.productReviewTxt);
            back = itemView.findViewById(R.id.back);
        }
    }
}
