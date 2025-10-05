package com.example.semenov_chair.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.semenov_chair.R;
import com.example.semenov_chair.databinding.ActivityMainBinding;
import com.example.semenov_chair.model.Chair;
import com.example.semenov_chair.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getChairLiveData().observe(this, model -> {
            if (model.isShouldNavigateToSecondView()) {
                model.setShouldNavigateToSecondView(false);
                Chair chair = model.toChair();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("CHAIR_KEY", chair);
                startActivity(intent);
            }
            if (model.isShouldShowError()) {
                model.setShouldShowError(false);
                Toast.makeText(this, "Будь ласка, заповніть всі поля!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
