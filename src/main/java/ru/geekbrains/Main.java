package ru.geekbrains;

import ru.geekbrains.model.Product;
import ru.geekbrains.productDao.ProductDao;
import ru.geekbrains.productDao.ProductDaoImpl;
import ru.geekbrains.utils.SessionFactoryUtils;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new ProductDaoImpl(sessionFactoryUtils);
            System.out.println(productDao.findById(1L));
            System.out.println(productDao.findAll());
            //productDao.save(new Product("Apricot", 37));
            //productDao.deleteById(2L);
            //System.out.println(productDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutDown();
        }

    }

}