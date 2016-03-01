package images_static;

import java.util.ArrayList;
import java.util.List;


public class Travels {

  public static final List<Data> IMG_DESCRIPTIONS = new ArrayList<Data>();

  static {
    Travels.IMG_DESCRIPTIONS.add(new Travels.Data("Image1", "album1.jpg",
                                                  "Image discription 1",
                                                  "China", "Lhasa",
                                                  "http://en.wikipedia.org/wiki/Potala_Palace"));
    Travels.IMG_DESCRIPTIONS.add(new Travels.Data("Image2", "album2.jpg",
                                                  "Image discription 2",
                                                  "China", "Lhasa",
                                                  "http://en.wikipedia.org/wiki/Drepung"));
    Travels.IMG_DESCRIPTIONS.add(new Travels.Data("Image3", "album3.jpg",
                                                  "Image discription 3",
                                                  "China", "Lhasa",
                                                  "http://en.wikipedia.org/wiki/Sera_Monastery"));
   
   
    Travels.IMG_DESCRIPTIONS.add(new Travels.Data("Image4", "album4.jpg",
                                                  "Image discription 4",
                                                  "Nepal", "Patan",
                                                  "http://en.wikipedia.org/wiki/Patan,_Nepal"));
    
    
    
    
    Travels.IMG_DESCRIPTIONS.add(new Travels.Data("Image4", "album5.jpg",
            "Image discription 5",
            "Nepal", "Patan",
            "http://en.wikipedia.org/wiki/Patan,_Nepal"));
    
    
    
    
    
    
    
  }

  public static final class Data {

    public final String title;
    public final String imageFilename;
    public final String description;
    public final String country;
    public final String city;
    public final String link;

    private Data(String title, String imageFilename, String description, String country,
                 String city, String link) {
      this.title = title;
      this.imageFilename = imageFilename;
      this.description = description;
      this.country = country;
      this.city = city;
      this.link = link;
    }
  }
}
