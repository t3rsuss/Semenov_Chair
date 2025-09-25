package com.example.semenov_chair;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText materialEt;
    private EditText colorEt;
    private EditText heightEt;
    private EditText priceEt;
    private CheckBox hasArmrestsCb;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        materialEt = findViewById(R.id.materialEt);
        colorEt = findViewById(R.id.colorEt);
        heightEt = findViewById(R.id.heightEt);
        priceEt = findViewById(R.id.priceEt);
        hasArmrestsCb = findViewById(R.id.hasArmrestsCb);
        submitBtn = findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(submitBtnOnClickListener);
    }

    private View.OnClickListener submitBtnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isAllFieldsFilled()) {
                try {
                    Chair tmpChair = new Chair(
                            materialEt.getText().toString(),
                            colorEt.getText().toString(),
                            Integer.parseInt(heightEt.getText().toString()),
                            Float.parseFloat(priceEt.getText().toString()),
                            hasArmrestsCb.isChecked()
                    );

                    Log.d("CHAIR_APP", tmpChair.toString());

                    Intent startSecondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                    startSecondActivityIntent.putExtra("CHAIR_KEY", tmpChair);
                    startActivity(startSecondActivityIntent);

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Будь ласка, використовуйте правильний формат для числових полів!", LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Будь ласка, заповніть всі поля!", LENGTH_LONG).show();
            }
        }
    };

    private boolean isAllFieldsFilled() {
        return !materialEt.getText().toString().isEmpty() &&
                !colorEt.getText().toString().isEmpty() &&
                !heightEt.getText().toString().isEmpty() &&
                !priceEt.getText().toString().isEmpty();
    }
}
