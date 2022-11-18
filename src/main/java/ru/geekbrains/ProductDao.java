package ru.geekbrains;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    void save(Product product);

    void updateProductById(Long id, String newTitle, int newCost);

    void updateTitleById(Long id, String newTitle);

    void updateCostById(Long id, int newCost);

}
