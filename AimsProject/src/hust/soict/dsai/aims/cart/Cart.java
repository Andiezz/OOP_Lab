package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cart {
    private static ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public static ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public static void addMedia(Media item) {
        itemsOrdered.add(item);
        System.out.println("Item added successfully!");
    }

    public static void removeMedia(Media item) {
        for (Media i: itemsOrdered) {
            if (i.getTitle().equals(item.getTitle())) {
                itemsOrdered.remove(i);
                System.out.println("Item removed successfully!");
                return;
            }
        }
        System.out.println("Can't find item!");
    }

    public static void removeAllMedia() {
        for (Media i: itemsOrdered) {
            itemsOrdered.remove(i);
            System.out.println("Item removed successfully!");
        }
    }

    public static boolean contains (Object obj) {
        for (Media i: itemsOrdered) {
            if (i.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public static float totalCost() {
        float totalCost = 0;
        for (Media i: itemsOrdered) {
            totalCost += i.getCost();
        }
        return totalCost;
    }

    public static void printCart() {
        System.out.println("""
                ***************CART***************
                Ordered Items:""");
        for (Media i: itemsOrdered) {
            System.out.println(i.toString());
        }
        System.out.println("Total cost: " + totalCost() +
                "\n" + "*********************************");
    }

    public static void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public static void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public static void findById() {
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

    public static void findByTitle() {
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
