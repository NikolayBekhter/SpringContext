package ru.geekbrains;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Cart cart = context.getBean(Cart.class);
        ProductRepository repository = new ProductRepository();
        repository.addProducts();
        repository.printProductList();
        cart.addProduct(repository.getProductById(6), 2);
        cart.addProduct(repository.getProductById(10), 3);
        System.out.println(cart.getCartMap());
        System.out.println(cart.getAllProductSum());
        cart.clearCartMap();
        System.out.println(repository.getProductById(6));
        System.out.println(repository.getProductById(10));
        context.close();
    }
}