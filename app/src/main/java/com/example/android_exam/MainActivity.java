package com.example.android_exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android_exam.Main_Adapter.fashion_Adapter;
import com.example.android_exam.Main_Adapter.Moden_class;
import com.example.android_exam.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Integer[] shirt_image = {R.drawable.show1, R.drawable.show2, R.drawable.show3, R.drawable.show4, R.drawable.show5, R.drawable.show6};

    String[] shirt_name = {"CHECK SHIRT", "CHECK OVERSHIRT", "RELAXED FIT", "STRIPED JACQUARD", "CROPPED CHECK", "SLOGAN PRINT"};

    String[] shirt_price = {"$ 7,590.00,", "$ 4,990.00", "$ 2,590.00", "$ 2,990.00", "$ 4,990.00", "$ 2,290.00"};

    String[] rate = {"3.9","4.1","2.1","4.7","4.6","1.9"};

    String[] rativ = {"430  Review","500 Review","70 Review","400 Review","203 Review","470 Review"};

    ActivityMainBinding binding;

    ArrayList<Moden_class> moden_classes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        for (int i = 0; i < shirt_image.length; i++) {
            Moden_class  m1 = new Moden_class(shirt_image[i], shirt_name[i], shirt_price[i],rate[i],rativ[i]);
            moden_classes.add(m1);
        }

        fashion_Adapter fashionAdapter = new fashion_Adapter(this,moden_classes);
        RecyclerView.LayoutManager R1 = new GridLayoutManager(this, 2);
        binding.page.setAdapter(fashionAdapter);
        binding.page.setLayoutManager(R1);
    }
}



