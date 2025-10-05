package com.example.semenov_chair.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.semenov_chair.R;
import com.example.semenov_chair.model.Chair;

public class SecondActivity extends AppCompatActivity {

    private TextView chairTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        chairTv = findViewById(R.id.chairTv);

        if (getIntent() != null && getIntent().getExtras() != null && !getIntent().getExtras().isEmpty()) {
            Chair tmpChair = (Chair) getIntent().getExtras().getSerializable("CHAIR_KEY");

            if (tmpChair != null) {
                String chairInfo = "Інформація про стілець:" + "\n" +
                        "Матеріал: " + tmpChair.getMaterial() + "\n" +
                        "Колір: " + tmpChair.getColor() + "\n" +
                        "Висота: " + tmpChair.getHeight() + " см \n" +
                        "Ціна: " + tmpChair.getPrice() + " грн \n" +
                        "Підлокітники: " + (tmpChair.isHasArmrests() ? "Є" : "Немає");

                chairTv.setText(chairInfo);
                Log.d("CHAIR_APP", "Object of Chair.class type was deserialized and obtained: " + tmpChair.toString());
            }
        }
    }
}
