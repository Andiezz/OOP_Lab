package hust.soict.itep.aims.cart;

import hust.soict.itep.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Scanner;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media item) {
        itemsOrdered.add(item);
        System.out.println("Item added successfully!");
    }

    public void removeMedia(Media item) {
        for (Media i: itemsOrdered) {
            if (i.getTitle().equals(item.getTitle())) {
                itemsOrdered.remove(i);
                System.out.println("Item removed successfully!");
                return;
            }
        }
        System.out.println("Can't find item!");
    }

    public void removeAllMedia() {
        for (Media i: itemsOrdered) {
            itemsOrdered.remove(i);
            System.out.println("Item removed successfully!");
        }
    }

    public boolean contains (Object obj) {
        for (Media i: itemsOrdered) {
            if (i.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public float totalCost() {
        float totalCost = 0;
        for (Media i: itemsOrdered) {
            totalCost += i.getCost();
        }
        return totalCost;
    }

    public void printCart() {
        System.out.println("""
                ***************CART***************
                Ordered Items:""");
        for (Media i: itemsOrdered) {
            System.out.println(i.toString());
        }
        System.out.println("Total cost: " + totalCost() +
                "\n" + "*********************************");
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void findById() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Find the Media by ID: ");
        int n = keyboard.nextInt();
        for (Media i: itemsOrdered) {
            if (i.getId() == n) {
                System.out.println(i.toString());
                return;
            }
        }
        System.out.println("No product found!");
    }

    public void findByTitle() {
        Scanner keyboard2 = new Scanner(System.in);
        System.out.println("Find the Media by Title:");
        String s = keyboard2.nextLine();
        for (Media i: itemsOrdered) {
            if (i.getTitle().equals(s)) {
                System.out.println(i.toString());
                return;
            }
        }
        System.out.println("No product found!");
    }
}
