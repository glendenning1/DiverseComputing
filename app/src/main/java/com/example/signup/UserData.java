package com.example.signup;

import android.os.Parcel;
import android.os.Parcelable;

public class UserData implements Parcelable
{
    private String first, last, street, city, state, zip, phone;

    public UserData(String f, String l, String s, String c, String st, String z, String p)
    {
        first = f;
        last = l;
        street = s;
        city = c;
        state = st;
        zip = z;
        phone = p;
    }
    public String getFirst()
    { return first; }
    public String getLast()
    { return last; }
    public String getStreet()
    { return street; }
    public String getCity()
    { return city; }
    public String getState()
    { return state; }
    public String getZip()
    { return zip; }
    public String getPhone()
    { return phone; }

    protected UserData(Parcel in)
    {
        first = in.readString();
        last = in.readString();
        street = in.readString();
        city = in.readString();
        state = in.readString();
        zip = in.readString();
        phone = in.readString();
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>()
    {
        @Override
        public UserData createFromParcel(Parcel in)
        { return new UserData(in); }

        @Override
        public UserData[] newArray(int size)
        { return new UserData[size]; }
    };
    @Override
    public int describeContents()
    { return 0; }
    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(first);
        dest.writeString(last);
        dest.writeString(street);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeString(zip);
        dest.writeString(phone);
    }
}
