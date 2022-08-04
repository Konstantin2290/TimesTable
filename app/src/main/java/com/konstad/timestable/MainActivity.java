package com.konstad.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewNumbers;
    private SeekBar seekBar;

    private TextView textViewNumbers;
    private String number;
    private String numberText;

    private ArrayList<Integer> numbers;

    private int max = 20;
    private int min = 1;
    private int count = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewNumbers = findViewById(R.id.listViewNumbers);
        textViewNumbers = findViewById(R.id.textViewNumbers);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(max);

        numbers = new ArrayList<>();

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, numbers);
        listViewNumbers.setAdapter(arrayAdapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (progress < min) {
                    seekBar.setProgress(min);
                }

                numbers.clear();
                for (int i = min; i <= count; i++) {
                    numbers.add(seekBar.getProgress() * i);
                }
                arrayAdapter.notifyDataSetChanged();

                number = String.format("%s", progress);
                textViewNumbers.setText(number);
                if (number.equals("0")) {
                    textViewNumbers.setText("1");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar.setProgress(1);
    }
}