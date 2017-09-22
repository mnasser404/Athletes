package nasser.com.athletes.Models;

/**
 * Created by adv on 9/20/2017.
 */

public class Athlete {

    private String name ;
    private String imageUrl;
    private String brief;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
