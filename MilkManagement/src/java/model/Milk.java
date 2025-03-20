package model;

public class Milk {

    private int id;
    private String name;
    private String unit;
    private int categoryId;
    private double price;
    private String overview;
    private String original;
    private boolean hasSugar;
    private String categoryName;

    public Milk() {
    }

    public Milk(int id, String name, String unit, int categoryId, double price, String overview, String original, boolean hasSugar, String categoryName) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.categoryId = categoryId;
        this.price = price;
        this.overview = overview;
        this.original = original;
        this.hasSugar = hasSugar;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public boolean isHasSugar() {
        return hasSugar;
    }

    public void setHasSugar(boolean hasSugar) {
        this.hasSugar = hasSugar;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
