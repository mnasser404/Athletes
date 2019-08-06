package nasser.com.athletes.Models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by adv on 9/20/2017.
 */

public class AthleteModel {


    private List<Athele> athletes;

    public List<Athele> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Athele> athletes) {
        this.athletes = athletes;
    }

    public static class Athele implements Serializable {

        private String name;
        private String image;
        private String brief;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }
    }
}
