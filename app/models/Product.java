package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonmoy on 02-Jan-16.
 */
public class Product {

    public String ean;
    public String name;
    public String description;

    public Product() {
    }

    public Product(String ean, String name, String description) {
        this.ean = ean;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ean='" + ean + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product("111", "Betop Gamepad", "Gamepad for Xbox 360"));
        products.add(new Product("222", "Kindle Paperwhite", "Ebook reader from Amazon"));
        products.add(new Product("333", "Microlab MD212", "Portable bluetooth speaker from Microlab"));
        products.add(new Product("444", "Moto G", "Moto G 1st Generation phone from Motorola"));
        products.add(new Product("555", "HP Pavilion 14-E037TX", "Laptop from HP"));
    }

    public static List<Product> findAll() {
        return new ArrayList<>(products);
    }

    public static Product findByEan(String ean) {
        for (Product item : products) {
            if (item.ean.equals(ean)) {
                return item;
            }

        }
        return null;
    }

    public static List<Product> findByName(String name) {
        final List<Product> results = new ArrayList<>();
        for (Product item : products) {
            if (item.name.equalsIgnoreCase(name)) {
                results.add(item);
            }
        }

        return results;
    }


    public static boolean remove(Product product) {
        return products.remove(product);
    }

    public void save() {
        products.remove(findByEan(this.ean));
        products.add(this);
    }
}


