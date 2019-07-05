package com.blogspot.yashas003.colorpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.String.format;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ConstraintLayout color;
    SeekBar red, green, blue;
    TextView HEX, RGB;
    int seekR, seekG, seekB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        color = findViewById(R.id.color);

        red = findViewById(R.id.red);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);

        HEX = findViewById(R.id.HEX);
        RGB = findViewById(R.id.RGB);

        SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateBackground();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        };

        red.setOnSeekBarChangeListener(seekBarChangeListener);
        green.setOnSeekBarChangeListener(seekBarChangeListener);
        blue.setOnSeekBarChangeListener(seekBarChangeListener);
    }

    private void updateBackground() {
        seekR = red.getProgress();
        seekG = green.getProgress();
        seekB = blue.getProgress();
        color.setBackgroundColor(0xff000000 + seekR * 0x10000 + seekG * 0x100 + seekB);
        RGB.setText("(" + seekR + "," + seekG + "," + seekB + ")");

        Drawable background = color.getBackground();
        int colorCode = ((ColorDrawable) background).getColor();
        String hexColor = String.format("#%06X", (0xFFFFFF & colorCode));
        HEX.setText(hexColor);
    }
}

