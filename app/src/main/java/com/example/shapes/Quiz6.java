package com.example.shapes;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Timer;
import java.util.TimerTask;


public class Quiz6 extends AppCompatActivity {
    private RadioGroup radioShapesGroup;
    private RadioButton radioButton;
    AlertDialog.Builder builder;
    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6);

        builder = new AlertDialog.Builder(this);

        addListenerOnButton();

    }

    public void addListenerOnButton() {

        radioShapesGroup = findViewById(R.id.radioShapesGroup);
        Button next = findViewById(R.id.Next);

        next.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioShapesGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioButton = findViewById(selectedId);
                Log.d("ADebugTag", "Value: " + (radioButton.getText()));
                if (radioButton.getText().equals("1")) {
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("Correct");
                    alert.show();
                    // Toast.makeText(MainActivity.this,
                    // radioSexButton.getText(), Toast.LENGTH_SHORT).show();


                }
                else
                {
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("Wrong");
                    alert.show();

                }



                // if(radioSexButton.getText().toString() == "Male") {

                // Log.d("ADebugTag", "dark: " + (radioSexButton.getText()));

                //   }

                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Quiz6.this,Question7.class);
                        startActivity(intent);
                        finish();

                    }
                },15000);
            }

        });

    }
}

