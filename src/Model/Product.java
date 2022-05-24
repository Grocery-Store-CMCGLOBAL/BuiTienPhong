package Model;

public class Product {
    private String id;
    private String name;
    private double price;
    private double total;
    private String unit;
    private boolean isSale;
    private double buy;
    private double bonus;

    public Product(String id, String name, double price, double total, String unit, boolean isSale, double buy, double bonus) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.total = total;
        this.unit = unit;
        this.isSale = isSale;
        this.buy = buy;
        this.bonus = bonus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
