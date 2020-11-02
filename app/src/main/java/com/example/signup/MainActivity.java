
package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private String fsu_id, email, pass1, pass2;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.SIGNUP_BUTTON1);
        button.setOnClickListener(v ->
        {
            if(!errors())
            {
                user = new User(fsu_id, email, pass1);
                Intent i = new Intent(this, SignUpActivity2.class);
                i.putExtra("USER", user);
                startActivity(i);
            }
        });
    }
    private boolean errors()
    {
        getInput();
        boolean isError = false;
        if(!validateFsuId())
        {
            fsuIdError(true);
            isError = true;
        }
        else
            fsuIdError(false);
        if(!validateEmail())
        {
            emailError(true);
            isError = true;
        }
        else
            emailError(false);
        if(!pass1.equals(pass2))
        {
            passwordError(true);
            isError = true;
        }
        else
            passwordError(false);
        return isError;
    }
    private void getInput()
    {
        EditText id = findViewById(R.id.FSU_ID_INPUT);
        EditText email_in = findViewById(R.id.EMAIL_INPUT);
        EditText password1 = findViewById(R.id.PASSWORD_INPUT);
        EditText password2 = findViewById(R.id.PASSWORD_CONFIRM_INPUT);

        fsu_id = id.getText().toString();
        email = email_in.getText().toString();
        pass1 = passHash(password1.getText().toString());
        pass2 = passHash(password2.getText().toString());
    }
    private String passHash(String pass)
    {
        //hash
        return pass;
    }
    private boolean validateFsuId()
    {
        //check fsuid
        return true;
    }
    private boolean validateEmail()
    {
        //check email
        return true;
    }
    private void fsuIdError(boolean setError)
    {
        TextView t = findViewById(R.id.ID_TEXT);
        if(setError)
        {
            t.setText("Not a valid FSU ID");
            t.setTextColor(getResources().getColor(R.color.colorPrimary));
        }
        else
        {
            t.setText("FSU ID");
            t.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
    private void emailError(boolean setError)
    {
        TextView t = findViewById(R.id.EMAIL_TEXT);
        if(setError)
        {
            t.setText("Not a valid email address");
            t.setTextColor(getResources().getColor(R.color.colorPrimary));
        }
        else
        {
            t.setText("Email");
            t.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
    private void passwordError(boolean setError)
    {
        TextView t1 = findViewById(R.id.PASS1_TEXT);
        TextView t2 = findViewById(R.id.PASS2_TEXT);
        if(setError)
        {
            t1.setText("Passwords must match");
            t1.setTextColor(getResources().getColor(R.color.colorPrimary));
            t2.setText("Passwords must match");
            t2.setTextColor(getResources().getColor(R.color.colorPrimary));
        }
        else
        {
            t1.setText("Password");
            t1.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            t2.setText("Confirm Password");
            t2.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}