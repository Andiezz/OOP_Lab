package hust.soict.itep.aims.store;

import hust.soict.itep.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public boolean addMedia(Media item) {
        if (itemsInStore.contains(item)) {
            System.out.println("Item already existed. Try again!");
            return false;
        }
        itemsInStore.add(item);
        System.out.println("Item added successfully!");
        return true;
    }

    public void removeMedia(Media item) {
        for (Media i: itemsInStore) {
            if (i.getTitle().equals(item.getTitle())) {
                itemsInStore.remove(i);
                System.out.println("Item removed successfully!");
                return;
            }
        }
        System.out.println("Can't find item!");
    }

    public void removeMediaByTitle(String title) {
        for (Media i: itemsInStore) {
            if (i.getTitle().equals(title)) {
                itemsInStore.remove(i);
                System.out.println("Item removed successfully!");
                return;
            }
        }
        System.out.println("Can't find item!");
    }

    public boolean contains (Object obj) {
        for (Media i: itemsInStore) {
            if (i.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public void printStore() {
        System.out.println("""
                ***************Store***************
                Store Items:""");
        for (Media i: itemsInStore) {
            System.out.println(i.toString());
        }
    }
}
