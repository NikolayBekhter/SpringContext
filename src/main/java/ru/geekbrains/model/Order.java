package ru.geekbrains.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @Column(name = "cost")
    private int cost;

    @CreationTimestamp
    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    public Order(Long id, Product product, Consumer consumer, int cost, Date dateOfCreation) {
        this.id = id;
        this.product = product;
        this.consumer = consumer;
        this.cost = cost;
        this.dateOfCreation = dateOfCreation;
    }

    public Order() {}

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product.getTitle() +
                ", consumer=" + consumer.getName() +
                ", cost=" + cost +
                ", dateOfCreation=" + dateOfCreation +
                '}';
    }
}
