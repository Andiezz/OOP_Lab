package hust.soict.itep.aims.media;

public class Disc extends Media implements Playable{
    protected int length;
    protected String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc(String title) {
        super(title);
    }

    @Override
    public void play() {

    }

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }
}
