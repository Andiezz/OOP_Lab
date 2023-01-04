package hust.soict.dsai.aims.media;

import java.util.Scanner;

public class DigitalVideoDisc extends Disc implements Playable{
    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMatch(String title) {
        return this.title.equals(title);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
        System.out.println("\n");
    }

    @Override
    public String toString() {
        return "Id: " + getId() +
                "\nTitle: " + getTitle() + "\nCategory: " + getCategory() +
                "\nCost: " + getCost() + "\nDirector: " + getDirector() +
                "\nLength: " + getLength() +"\n";
    }

    public static DigitalVideoDisc createDigitalVideoDisc () {
        Scanner keyboard;
        System.out.println("Enter information:");
        keyboard = new Scanner(System.in);
        System.out.println("Title: ");
        String s1 = keyboard.nextLine();
        keyboard = new Scanner(System.in);
        System.out.println("Category: ");
        String s2 = keyboard.nextLine();
        keyboard = new Scanner(System.in);
        System.out.println("Director: ");
        String s3 = keyboard.nextLine();
        keyboard = new Scanner(System.in);
        System.out.println("Length: ");
        int s4 = keyboard.nextInt();
        keyboard = new Scanner(System.in);
        System.out.println("Cost: ");
        float s5 = keyboard.nextFloat();
        DigitalVideoDisc dvd = new DigitalVideoDisc(s1, s2, s3, s4, s5);
        return dvd;
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
}
