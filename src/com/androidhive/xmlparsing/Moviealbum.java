package com.androidhive.xmlparsing;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;



public class Moviealbum implements Parcelable{
	private String title,year,day;
	
	

	public Moviealbum() {
	}

	public Moviealbum(String name, String year, String day
			) {
		this.title = name;
		
		this.year = year;
		this.day = day;
		
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	
	
	
	// Parcelling part
    public Moviealbum(Parcel in){
        String[] data = new String[3];
        
        

        in.readStringArray(data);
        this.title = data[0];
        this.year = data[1];
        this.day = data[2];
        
    }
	
	


	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.title,
                                            this.year,this.day
                                            });
    }
	
	
	 public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
         public Moviealbum createFromParcel(Parcel in) {
             return new Moviealbum(in); 
         }

         public Moviealbum[] newArray(int size) {
             return new Moviealbum[size];
         }
     };
	
	
	
	
	
	

	
}
