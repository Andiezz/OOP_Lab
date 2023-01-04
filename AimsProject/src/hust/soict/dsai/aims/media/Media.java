package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    protected int id = 0;
    protected String title;
    protected String category;
    protected float cost;
    protected static int nbProducts = 0;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();

    public Media(String title) {
        nbProducts++;
        this.id = nbProducts;
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        nbProducts++;
        this.id = nbProducts;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public String toString() {
        return "Title: " + getTitle() + "Category: " + getCategory() +
                "Cost: " + getCost() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Media) {
            Media product = (Media) obj;
            if (product.getTitle().equals(this.getTitle())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
