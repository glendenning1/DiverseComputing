package com.example.signup;

import android.os.Parcel;
import android.os.Parcelable;

public class Vehicle implements Parcelable
{
    private String make, model, year, color;

    public Vehicle(String make, String model, String year, String color)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }
    public String getMake()
    { return make; }
    public String getModel()
    { return model; }
    public String getYear()
    { return year; }
    public String getColor()
    { return color; }

    protected Vehicle(Parcel in)
    {
        make = in.readString();
        model = in.readString();
        year = in.readString();
        color = in.readString();
    }
    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>()
    {
        @Override
        public Vehicle createFromParcel(Parcel in)
        { return new Vehicle(in); }
        @Override
        public Vehicle[] newArray(int size)
        { return new Vehicle[size]; }
    };
    @Override
    public int describeContents()
    { return 0; }
    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(make);
        dest.writeString(model);
        dest.writeString(year);
        dest.writeString(color);
    }
}
