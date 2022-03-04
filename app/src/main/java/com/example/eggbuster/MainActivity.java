package com.example.eggbuster;

import static com.example.eggbuster.R.id.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.wear.tiles.material.Button;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eggbuster.R.id;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
      View button;
      TextView timerdisplay;
      EditText input;
      ImageView img;
      CountDownTimer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        timerdisplay = findViewById(R.id.textView2);
        input = findViewById(R.id.time_edit_text);
        img = findViewById(Imageview_1);

        button.setOnClickListener(new View.OnClickListener() {
//            public int millisUntilFinished;

            @Override
            public void onClick(View v) {
//                Context context;
//                Object text;
//                Toast.makeText(MainActivity.this, "Message", Toast.LENGTH_SHORT).show();
                if(TextUtils.isEmpty(input.getText())){
                    Toast.makeText(MainActivity.this,"No input",Toast.LENGTH_SHORT).show();
                    return;
                }
             int time = Integer.parseInt(input.getText().toString());
//             timerdisplay.setText(time+"");
             img.setImageDrawable(getDrawable(R.drawable.egg));
//                timerdisplay.setText(display);
                timer = new CountDownTimer(time*1000 ,1000) {


                    @Override
                    public void onTick(long millisUntilFinished) {



                        int timeInsec = (int) millisUntilFinished/1000;

                        int min =  timeInsec / 60;
                        int sec = timeInsec % 60;

                        String display = min +" : "+sec;
                        timerdisplay.setText(display);

                    }

                    @Override
                    public void onFinish() {
                        img.setImageDrawable(getDrawable(R.drawable.cracked));

                    }
                };
                timer.start();


            };
        });

    }}