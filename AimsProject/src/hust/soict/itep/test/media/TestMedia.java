package hust.soict.itep.test.media;

import hust.soict.itep.aims.media.*;

import java.util.ArrayList;

public class TestMedia {
    public static void main(String args[]) {
        ArrayList<Media> mediae = new ArrayList<Media>();

        ArrayList<Track> tracks = new ArrayList<Track>();
        Track track1 = new Track("Bài ca đầu tiên", 4);
        Track track2 = new Track("Thật bất ngờ", 3);
        Track track3 = new Track("Ước mơ của mẹ", 5);
        tracks.add(track1);
        tracks.add(track2);
        tracks.add(track3);
        CompactDisc cd = new CompactDisc("XHTDRLX", "music",
                612.1f, "Forest Studio", "Various artists", tracks);
        mediae.add(cd);

        DigitalVideoDisc dvd = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        mediae.add(dvd);

        ArrayList<String> authors = new ArrayList<String>();
        authors.add("J.K.Rowling");
        Book book = new Book("Harry Potter", "Fantasy", 12.3f, authors);

        for (Media m: mediae) {
            System.out.println(m.toString());
        }
    }
}
