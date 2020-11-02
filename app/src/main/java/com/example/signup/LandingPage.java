package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class LandingPage extends AppCompatActivity
{
    private static final int VEHICLE_REQUEST_CODE = 1;
    private static final int PAYMENT_REQUEST_CODE = 2;
    private User user;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        user = getIntent().getExtras().getParcelable("USER");
        textView = findViewById(R.id.DATAVIEW);
        String temp = "FSU ID: " + user.getFsu_id() + "\nEmail: " + user.getEmail()
                + "\nPassword: " + user.getPass();
        UserData u = user.getUserData();
        temp += "\nName: " + u.getFirst() + " " + u.getLast() + "\nAddress:\n\t\t\t" + u.getStreet()
                + "\n\t\t\t" + u.getCity() + ", " + u.getState() + " " + u.getZip() + "\nPhone: " + u.getPhone();
        textView.setText(temp);
        if(user.getVehicles() == null)
            startActivityForResult(new Intent(this, VehicleActivity.class), VEHICLE_REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == VEHICLE_REQUEST_CODE && resultCode == RESULT_OK && data != null)
        {
            ArrayList<Vehicle> vehicle = new ArrayList<>();
            vehicle.add(data.getParcelableExtra("VEHICLE"));
            String temp = (String) textView.getText();
            for(Vehicle v : vehicle)
            {
                temp += "\nVehicle make: " + v.getMake() + "\nVehicle model: " + v.getModel()
                        + "\nVehicle color: " + v.getColor() + "\nVehicle year: " + v.getYear();
            }
            textView.setText(temp);
            if(user.getPayments() == null)
            {
                //inflate payments
            }
        }
    }
}