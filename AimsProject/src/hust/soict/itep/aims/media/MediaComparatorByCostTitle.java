package hust.soict.itep.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media a, Media b) {
        if (a.getCost() != b.getCost()) {
            if (a.getCost() - b.getCost() > 0.0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return a.getTitle()
                    .compareTo(b.getTitle());
        }
    }
}
