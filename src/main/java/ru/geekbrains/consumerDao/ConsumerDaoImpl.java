package ru.geekbrains.consumerDao;

import org.hibernate.Session;
import ru.geekbrains.model.Consumer;
import ru.geekbrains.utils.SessionFactoryUtils;

import java.util.List;

public class ConsumerDaoImpl implements ConsumerDao {

    SessionFactoryUtils sessionFactoryUtils;

    public ConsumerDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Consumer findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Consumer consumer = session.get(Consumer.class, id);
            session.getTransaction().commit();
            return consumer;
        }
    }

    @Override
    public List<Consumer> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Consumer> consumers = session.createQuery("select consumer from Consumer consumer").getResultList();
            session.getTransaction().commit();
            return consumers;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Consumer consumer = session.get(Consumer.class, id);
            session.delete(consumer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void save(Consumer consumer) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(consumer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateNameById(Long id, String newName) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Consumer consumer = session.get(Consumer.class, id);
            consumer.setName(newName);
            session.getTransaction().commit();
        }
    }
}
