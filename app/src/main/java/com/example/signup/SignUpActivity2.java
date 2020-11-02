
package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpActivity2 extends AppCompatActivity
{
    private String first, last, street, city, state, zip, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        User user = getIntent().getExtras().getParcelable("USER");

        Button button = findViewById(R.id.SIGNUP_BUTTON2);
        button.setOnClickListener(v ->
        {
            if(!errors())
            {
                user.setUserData(new UserData(first, last, street, city, state, zip, phone));
                //databaseInteraction(user);
                //if(db_res.contains("Query OK"))
                Intent i = new Intent(this, LandingPage.class);
                i.putExtra("USER", user);
                startActivity(i);
            }
        });
    }
    private boolean errors()
    {
        getInput();
        boolean isError = false;
        if(!validateAddress())
        {
            addressError(true);
            isError = true;
        }
        else
            addressError(false);
        if(!validatePhone())
        {
            phoneError(true);
            isError = true;
        }
        else
            phoneError(false);
        return isError;
    }
    private void getInput()
    {
        EditText firstInput = findViewById(R.id.FIRST_INPUT);
        EditText lastInput = findViewById(R.id.LAST_INPUT);
        EditText streetInput = findViewById(R.id.STREET_INPUT);
        EditText cityInput = findViewById(R.id.CITY_INPUT);
        EditText stateInput = findViewById(R.id.STATE_INPUT);
        EditText zipInput = findViewById(R.id.ZIP_INPUT);
        EditText phoneInput = findViewById(R.id.PHONE_INPUT);

        first = firstInput.getText().toString();
        last = lastInput.getText().toString();
        street = streetInput.getText().toString();
        city = cityInput.getText().toString();
        state = stateInput.getText().toString();
        zip = zipInput.getText().toString();
        phone = phoneInput.getText().toString();
    }
    private boolean validateAddress()
    {
        //validate address
        return true;
    }
    private boolean validatePhone()
    {
        //validate phone
        return true;
    }
    private void addressError(boolean setError)
    {
        //set errors for addresses
    }
    private void phoneError(boolean setError)
    {
        //check valid phone
    }
}