package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void main(String[] args) {
        // Initialize
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        Store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        Store.addMedia(dvd2);

        ArrayList<Track> tracks = new ArrayList<Track>();
        Track track1 = new Track("Bài ca đầu tiên", 4);
        Track track2 = new Track("Thật bất ngờ", 3);
        Track track3 = new Track("Ước mơ của mẹ", 5);
        tracks.add(track1);
        tracks.add(track2);
        tracks.add(track3);
        CompactDisc cd = new CompactDisc("XHTDRLX", "music",
                61.2f, "Forest Studio", "Various artists", tracks);
        Store.addMedia(cd);

        ArrayList<String> authors = new ArrayList<String>();
        authors.add("J.K.Rowling");
        Book book = new Book("Harry Potter", "Fantasy", 12.3f, authors);
        Store.addMedia(book);

        Store.printStore();
        //Main Menu
        while (true) {
            showMenu();
            Scanner keyboard = new Scanner(System.in);
            int n = keyboard.nextInt();
            // Main menu
            if (n == 1) {
                // Store Menu
                while (true) {
                    storeMenu();
                    keyboard = new Scanner(System.in);
                    int m = keyboard.nextInt();
                    if (m == 1) {
                        keyboard = new Scanner(System.in);
                        System.out.println("Enter title: ");
                        String tit = keyboard.nextLine();
                        for (Media i : Store.getItemsInStore()) {
                            if (i.getTitle().equals(tit)) {
                                System.out.println(i.toString());
                                while (true) {
                                    mediaDetailsMenu();
                                    keyboard = new Scanner(System.in);
                                    int x = keyboard.nextInt();
                                    if (x == 1) {
                                        Cart.addMedia(i);
                                    } else if (x == 2 && (i instanceof CompactDisc ||
                                            i instanceof DigitalVideoDisc)) {
                                        ((Playable) i).play();
                                    } else if (x == 2 && i instanceof Book) {
                                        System.out.println("Play not available!");
                                    } else if (x == 0) {
                                        break;
                                    } else {
                                        System.out.println("Wrong input. Choose again!");
                                    }
                                }
                            }
                        }
                    } else if (m == 2) {
                        keyboard = new Scanner(System.in);
                        System.out.println("Enter title: ");
                        String tit = keyboard.nextLine();
                        for (Media i : Store.getItemsInStore()) {
                            if (i.getTitle().equals(tit)) {
                                Cart.addMedia(i);
                                if (i instanceof DigitalVideoDisc) {
                                    int count = 0;
                                    for (Media j : Store.getItemsInStore()) {
                                        if (j instanceof DigitalVideoDisc) {
                                            count++;
                                        }
                                    }
                                    System.out.println("Number of DVDs: " + count);
                                }
                            }
                        }
                    } else if (m == 3) {
                        keyboard = new Scanner(System.in);
                        System.out.println("Enter title: ");
                        String tit = keyboard.nextLine();
                        for (Media i : Store.getItemsInStore()) {
                            if (i.getTitle().equals(tit) && (i instanceof CompactDisc || i instanceof DigitalVideoDisc)) {
                                ((Playable) i).play();
                            } else if (i.getTitle().equals(tit) && i instanceof Book) {
                                System.out.println("Play not available!");
                            }
                        }
                    } else if (m == 4) {
                        Cart.printCart();
                    } else if (m == 0) {
                        break;
                    } else {
                        System.out.println("Wrong input. Choose again!");
                    }
                }
            } else if (n == 2) {
                while (true) {
                    System.out.println("Options: ");
                    System.out.println("--------------------------------");
                    System.out.println("1. Add media");
                    System.out.println("2. Remove media");
                    System.out.println("0. Back");
                    System.out.println("--------------------------------");
                    System.out.println("Please choose a number: 0-1-2");
                    keyboard = new Scanner(System.in);
                    int a = keyboard.nextInt();
                    if (a == 1) {
                        while (true) {
                            System.out.println("Options: ");
                            System.out.println("--------------------------------");
                            System.out.println("1. Book");
                            System.out.println("2. Compact Disc");
                            System.out.println("3. Digital Video Disc");
                            System.out.println("0. Back");
                            System.out.println("--------------------------------");
                            System.out.println("Please choose a number: 0-1-2-3");
                            keyboard = new Scanner(System.in);
                            int b = keyboard.nextInt();
                            if (b == 1) {
                                while (true) {
                                    Book book2 = Book.createBook();
                                    if (Store.addMedia(book2)) {
                                        break;
                                    }
                                }
                            } else if (b == 2) {
                                while (true) {
                                    CompactDisc cd2 = CompactDisc.createCompactDisc();
                                    if (Store.addMedia(cd2)) {
                                        break;
                                    }
                                }
                            } else if (b == 3) {
                                DigitalVideoDisc dvd3 = DigitalVideoDisc.createDigitalVideoDisc();
                                if (Store.addMedia(dvd3)) {
                                    break;
                                }
                            } else if (b == 0) {
                                break;
                            } else {
                                System.out.println("Wrong input. Choose again!");
                            }
                        }
                    } else if (a == 2) {
                        keyboard = new Scanner(System.in);
                        System.out.println("Remove the Media by Title:");
                        String s = keyboard.nextLine();
                        Store.removeMediaByTitle(s);
                    } else if (a == 0) {
                        break;
                    } else {
                        System.out.println("Wrong input. Choose again!");
                    }
                }
            } else if (n == 3) {
                Cart.printCart();
                // Cart Menu
                while (true) {
                    cartMenu();
                    keyboard = new Scanner(System.in);
                    int p = keyboard.nextInt();
                    if (p == 1) {
                        System.out.println("Options: ");
                        System.out.println("--------------------------------");
                        System.out.println("1. Filter by ID");
                        System.out.println("2. Filter by Title");
                        System.out.println("0. Back");
                        System.out.println("--------------------------------");
                        System.out.println("Please choose a number: 0-1-2");
                        keyboard = new Scanner(System.in);
                        int q = keyboard.nextInt();
                        if (q == 1) {
                            Cart.findById();
                        } else if (q == 2) {
                            Cart.findByTitle();
                        } else if (q == 0) {
                            break;
                        } else {
                            System.out.println("Wrong input. Choose again!");
                        }
                    } else if (p == 2) {
                        System.out.println("Options: ");
                        System.out.println("--------------------------------");
                        System.out.println("1. Sort by Title");
                        System.out.println("2. Sort by Cost");
                        System.out.println("0. Back");
                        System.out.println("--------------------------------");
                        System.out.println("Please choose a number: 0-1-2");
                        keyboard = new Scanner(System.in);
                        int q = keyboard.nextInt();
                        if (q == 1) {
                            Cart.sortByTitleCost();
                        } else if (q == 2) {
                            Cart.sortByCostTitle();
                        } else if (q == 0) {
                            break;
                        } else {
                            System.out.println("Wrong input. Choose again!");
                        }
                    } else if (p == 3) {
                        keyboard = new Scanner(System.in);
                        System.out.println("Enter title: ");
                        String tit = keyboard.nextLine();
                        for (Media i : Store.getItemsInStore()) {
                            if (i.getTitle().equals(tit)){
                                Cart.removeMedia(i);
                            }
                        }
                    } else if (p == 4) {
                        keyboard = new Scanner(System.in);
                        System.out.println("Enter title: ");
                        String tit = keyboard.nextLine();
                        for (Media i : Cart.getItemsOrdered()) {
                            if (i.getTitle().equals(tit) && (i instanceof CompactDisc || i instanceof DigitalVideoDisc)) {
                                ((Playable) i).play();
                            } else if (i.getTitle().equals(tit) && i instanceof Book) {
                                System.out.println("Play not available!");
                            }
                        }
                    } else if (p == 5) {
                        System.out.println("The order is created!");
                        Cart.removeAllMedia();
                    } else if (p == 0) {
                        break;
                    } else {
                        System.out.println("Wrong input. Choose again!");
                    }
                }
            } else if (n == 0) {
                break;
            } else {
                System.out.println("Wrong input. Choose again!");
            }
        }
    }
}
