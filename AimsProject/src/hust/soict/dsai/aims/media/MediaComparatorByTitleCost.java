package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media a, Media b) {
        if (!a.getTitle().equals(b.getTitle())) {
            return a.getTitle().compareTo(b.getTitle());
        } else {
            if (a.getCost() - b.getCost() > 0.0) {
                return 1;
            } else if (a.getCost() - b.getCost() < 0.0){
                return -1;
            } else {
                return 0;
            }
        }
    }
}
