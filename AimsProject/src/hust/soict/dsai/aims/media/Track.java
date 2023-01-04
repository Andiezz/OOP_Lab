package hust.soict.dsai.aims.media;

import java.util.Scanner;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track product = (Track) obj;
            return product.getTitle().equals(this.getTitle())
                    && product.getLength() == this.getLength();
        }
        return false;
    }

    public static Track createTrack() {
        Scanner keyboard;
        System.out.println("Enter information:");
        keyboard = new Scanner(System.in);
        System.out.println("Title: ");
        String s1 = keyboard.nextLine();
        keyboard = new Scanner(System.in);
        System.out.println("Length: ");
        int s2 = keyboard.nextInt();
        Track track = new Track(s1, s2);
        return track;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
}
