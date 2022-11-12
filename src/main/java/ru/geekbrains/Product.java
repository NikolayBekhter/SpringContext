package ru.geekbrains;

public class Product {
    private int id;
    private static int idCount = 1;
    private String name;
    private int price;

    public Product (String name, int price) {
        id = idCount++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
