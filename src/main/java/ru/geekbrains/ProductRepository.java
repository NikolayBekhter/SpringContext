package ru.geekbrains;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void addProducts () {
        products.add(new Product("Apple", 10));
        products.add(new Product("Lemon", 30));
        products.add(new Product("Orange", 17));
        products.add(new Product("Garnet", 35));
        products.add(new Product("Pear", 15));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void printProductList(){
        products.forEach((product) -> {
            System.out.println(product.toString());
        });
    }
    public Product getProductById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return products.get(i);
            }
        }
        System.out.println("Нет такого товара!");
        return null;
    }
}
