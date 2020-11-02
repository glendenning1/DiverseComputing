
package com.example.signup;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class User implements Parcelable
{
    private String fsu_id, email, pass;
    private UserData userData;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Payment> payments;

    public User(String fsu_id, String email, String pass)
    {
        this.fsu_id = fsu_id;
        this.email = email;
        this.pass = pass;
        userData = null;
        vehicles = null;
        payments = null;
    }
    public void setUserData(UserData userData)
    { this.userData = userData; }
    public void setVehicles(ArrayList<Vehicle> vehicles)
    { this.vehicles = vehicles; }
    public void setPayments(ArrayList<Payment> payments)
    { this.payments = payments; }
    public String getFsu_id()
    { return fsu_id; }
    public String getEmail()
    { return email; }
    public String getPass()
    { return pass; }
    public UserData getUserData()
    { return userData; }
    public ArrayList<Vehicle> getVehicles()
    { return vehicles; }
    public ArrayList<Payment> getPayments()
    { return payments; }

    protected User(Parcel in)
    {
        fsu_id = in.readString();
        email = in.readString();
        pass = in.readString();
        userData = (UserData) in.readValue(UserData.class.getClassLoader());
        if(in.readByte() == 0x01)
        {
            vehicles = new ArrayList<>();
            in.readList(vehicles, Vehicle.class.getClassLoader());
        }
        else
            vehicles = null;
        if(in.readByte() == 0x01)
        {
            payments = new ArrayList<>();
            in.readList(payments, Payment.class.getClassLoader());
        }
        else
            payments = null;
    }
    public static final Creator<User> CREATOR = new Creator<User>()
    {
        @Override
        public User createFromParcel(Parcel in)
        { return new User(in); }
        @Override
        public User[] newArray(int size)
        { return new User[size]; }
    };
    @Override
    public int describeContents()
    { return 0; }
    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(fsu_id);
        dest.writeString(email);
        dest.writeString(pass);
        dest.writeValue(userData);
        if(vehicles == null)
            dest.writeByte((byte) (0x00));
        else
        {
            dest.writeByte((byte) (0x01));
            dest.writeList(vehicles);
        }
        if(payments == null)
            dest.writeByte((byte) (0x00));
        else
        {
            dest.writeByte((byte) (0x01));
            dest.writeList(payments);
        }
    }
}
