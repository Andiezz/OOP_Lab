package hust.soict.itep.test.disc;

import hust.soict.itep.aims.media.DigitalVideoDisc;

class dvdWrapper {
    DigitalVideoDisc c;
    dvdWrapper(DigitalVideoDisc c) {
        this.c = c;
    }
}

public class TestPassingParameter {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // Wrapper
        dvdWrapper dw1 = new dvdWrapper(jungleDVD);
        dvdWrapper dw2 = new dvdWrapper(cinderellaDVD);

        swap(jungleDVD, cinderellaDVD);

        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());

        swap(dw1, dw2);

        System.out.println("Jungle DVD title: " + dw1.c.getTitle());
        System.out.println("Cinderella DVD title: " + dw2.c.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
    }

    public static void swap (Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void swap (dvdWrapper o1, dvdWrapper o2) {
        DigitalVideoDisc tmp = o1.c;
        o1.c = o2.c;
        o2.c = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
