package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String TAG ="Root";
    EditText input;
    TextView serviceText;
    TextView resultText;
    RadioGroup radioGroup;
    Button button;
    Switch switch1;
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Application started");

        input = (EditText) findViewById(R.id.editTextNumber);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        button = (Button) findViewById(R.id.button);
        switch1 = (Switch) findViewById(R.id.switch1);
        resultText = (TextView) findViewById(R.id.textView3);
        int value;




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Button pressed"+count++);

                float tipAmount = 0;
                float percentageOfTip = 0;
                switch (radioGroup.getCheckedRadioButtonId()){

                    case R.id.radiobutton1:
                        percentageOfTip =20;

                        break;
                    case R.id.radiobutton2:
                        percentageOfTip =18;;
                         break;
                    case R.id.radiobutton3:
                        percentageOfTip =15;;
                       break;
                    default:
                        Toast.makeText(MainActivity.this, "Select a radio button", Toast.LENGTH_SHORT).show();

                }
                if (input.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(MainActivity.this,"Please enter valid input",Toast.LENGTH_SHORT);
                    toast.show();

                }
                else {
                    tipAmount = (percentageOfTip/100)*Integer.parseInt(input.getText().toString());
                    if (switch1.isChecked()){resultText.setText("Total amount: " + String.format("%.2f", tipAmount));}  else{resultText.setText("Total amount: " + tipAmount);}
                }

            }
        });








    }



}