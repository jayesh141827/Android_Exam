package com.example.android_exam.CHECK_SHIRT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.android_exam.CHECK_SHIRT.Check_Adapter;
import com.example.android_exam.CHECK_SHIRT.Check_Moden;
import com.example.android_exam.Main_Adapter.Moden_class;
import com.example.android_exam.Main_Adapter.fashion_Adapter;
import com.example.android_exam.R;
import com.example.android_exam.databinding.ActivityCheckShirtMainBinding;
import com.example.android_exam.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class Check_Shirt_main extends AppCompatActivity {

    Integer[] shirt_image = {R.drawable.show1};

    String[] shirt_name = {"CHECK SHIRT"};

    String[] shirt_price = {"$ 7,590.00,"};

    String[] rate = {"3.9"};

    String[] rativ = {"430  Review"};

    ActivityCheckShirtMainBinding binding;

    ArrayList<Check_Moden> check_modens = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckShirtMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        for (int i = 0; i < shirt_image.length; i++) {
            Check_Moden  m1 = new Check_Moden(shirt_image[i], shirt_name[i], shirt_price[i],rate[i],rativ[i]);
            check_modens.add(m1);
        }

        Check_Adapter check_adapter = new Check_Adapter(this,check_modens);
        RecyclerView.LayoutManager R1 = new LinearLayoutManager(this);
        binding.shirt.setAdapter(check_adapter);
        binding.shirt.setLayoutManager(R1);
    }
}
