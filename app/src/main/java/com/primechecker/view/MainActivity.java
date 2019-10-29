package com.primechecker.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.primechecker.R;
import com.primechecker.databinding.ActivityMainBinding;
import com.primechecker.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setViewModel(mainViewModel);
        mainViewModel.observeData(this);

        binding.setLifecycleOwner(this);
    }
}
