package org.asd.practice._31_03;

public class Fruit {
    private double price;
    private String name;
    private boolean inStock;

    public Fruit(double price, String name, boolean inStock) {
        this.price = price;
        this.name = name;
        this.inStock = inStock;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean isInStock() {
        return inStock;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", inStock=" + inStock +
                '}';
    }
}
