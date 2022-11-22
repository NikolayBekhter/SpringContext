package ru.geekbrains.consumerDao;

import ru.geekbrains.model.Consumer;
import ru.geekbrains.model.Product;

import java.util.List;

public interface ConsumerDao {

    Consumer findById (Long id);

    List<Consumer> findAll ();

    void deleteById(Long id);

    void save(Consumer consumer);

    void updateNameById(Long id, String newName);
}
