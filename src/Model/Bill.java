package Model;

public class Bill {
    private int id;
    private String name;
    private double totalProduct;
    private double totalBonus;
    private double price;
    private String unit;

    public Bill() {
    }

    public Bill(int id, String name, double totalProduct, double totalBonus, double price, String unit) {
        this.id = id;
        this.name = name;
        this.totalProduct = totalProduct;
        this.totalBonus = totalBonus;
        this.price = price;
        this.unit = unit;
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

    public double getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(double totalProduct) {
        this.totalProduct = totalProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(double totalBonus) {
        this.totalBonus = totalBonus;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return id+ "\t" + name + "\t\t\t" + totalProduct+unit +"\t\t\t\t"+totalBonus+unit + "\t\t\t" + price;
    }
}
