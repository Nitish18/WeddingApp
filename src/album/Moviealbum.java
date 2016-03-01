package album;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class Moviealbum implements Parcelable{
	private String title,thumbnailUrl;
	
	
	
	public Moviealbum() {
		// TODO Auto-generated constructor stub
	}

	public Moviealbum(String name, String thumbnailUrl
			) {
		this.title = name;
		this.thumbnailUrl = thumbnailUrl;
		
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = "http://eventassociate.com/wedding/"+thumbnailUrl;
	}
	
	 // Parcelling part
    public Moviealbum(Parcel in){
        String[] data = new String[2];

        in.readStringArray(data);
        this.title = data[0];
        this.thumbnailUrl = data[1];
        
    }
	
	
	

	



	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.title,
                                            this.thumbnailUrl,
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


