package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InputVehicleActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_vehicle);

        Intent intent = new Intent();
        findViewById(R.id.INPUT_VEHICLE_ADD_BUTTON).setOnClickListener(v ->
        {
            EditText make = findViewById(R.id.INPUT_VEHICLE_MAKE_INPUT);
            EditText model = findViewById(R.id.INPUT_VEHICLE_MODEL_INPUT);
            EditText year = findViewById(R.id.INPUT_VEHICLE_YEAR_INPUT);
            EditText color = findViewById(R.id.INPUT_VEHICLE_COLOR_INPUT);

            //validateData

            Vehicle vehicle = new Vehicle(make.getText().toString(), model.getText().toString(),
                    year.getText().toString(), color.getText().toString());
            intent.putExtra("VEHICLE", vehicle);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}