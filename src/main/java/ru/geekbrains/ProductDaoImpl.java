package ru.geekbrains;

import org.hibernate.Session;

import java.util.List;

public class ProductDaoImpl implements ProductDao{

    SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select product from Product product").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void save(Product product) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateProductById(Long id, String newTitle, int newCost) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setTitle(newTitle);
            product.setCost(newCost);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateTitleById(Long id, String newTitle) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setTitle(newTitle);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateCostById(Long id, int newCost) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setCost(newCost);
            session.getTransaction().commit();
        }
    }

}
