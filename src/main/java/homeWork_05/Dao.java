package homeWork_05;

import java.util.List;

public interface Dao <T> {

    T getById(long id);

    List<T> getAll();

    void save(T t);

    void saveAll(List<T>list);

    void update(T t, Object[] params);

    void delete(T t);

    void deleteById(long id);
}
