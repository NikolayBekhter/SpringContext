package ru.geekbrains;

import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Data
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {

    private final Map<Product, Integer> cartMap = new ConcurrentHashMap<>();

    public void addProduct(Product product, Integer quantity){
        if (product != null){
            cartMap.put(product, quantity);
        }
    }
    public void delProduct(String name){

        cartMap.forEach((k, v) -> {
            if(k.getName().equals(name)){
                cartMap.remove(k);
            }
        });
    }

    public int getAllProductSum(){
        int sum = 0;
        for (Map.Entry<Product, Integer> cartMap : cartMap.entrySet()) {
            sum+=(cartMap.getKey().getPrice())*cartMap.getValue();
        }
        return sum;
    }

    public Map<Product, Integer> getCartMap() {
        return cartMap;
    }
    public void clearCartMap(){
        cartMap.clear();
    }
}
