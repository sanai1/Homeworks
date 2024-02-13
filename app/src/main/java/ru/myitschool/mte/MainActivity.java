package ru.myitschool.mte;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.myitschool.mte.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private boolean go = false;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    public void btn_start(View view) {
        go = true;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0;; i++) {
                    if (!go) break;
                    binding.numIteration.setText(String.valueOf(i % 3 + 1));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void btn_stop(View view) {
        go = false;
        binding.numIteration.setText("0");
    }
}
