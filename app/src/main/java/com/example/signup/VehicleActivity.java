package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class VehicleActivity extends AppCompatActivity
{
    private Vehicle vehicle;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        Button button1 = findViewById(R.id.VEHICLE_ADD_BUTTON);
        Button button2 = findViewById(R.id.VEHICLE_SKIP_BUTTON);
        button1.setOnClickListener(v -> { startActivityForResult(new Intent(this,
                InputVehicleActivity.class), REQUEST_CODE); });
        button2.setOnClickListener(v -> { finish(); });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null)
        {
            vehicle = data.getParcelableExtra("VEHICLE");
            Intent intent = new Intent();
            intent.putExtra("VEHICLE", vehicle);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }
}