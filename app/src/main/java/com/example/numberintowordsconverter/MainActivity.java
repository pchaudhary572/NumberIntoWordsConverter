package com.example.numberintowordsconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText digitNum;
    private TextView display;
    private Button convertbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        digitNum = findViewById(R.id.digitID);
        display = findViewById(R.id.viewID);
        convertbtn = findViewById(R.id.conBtn);

        convertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num;
                num=Integer.parseInt(digitNum.getText().toString());
                Convertor converter= new Convertor(num);
                display.setText(converter.Validate());
            }
        });
    }
}
