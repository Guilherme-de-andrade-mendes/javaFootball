import java.util.List;

public interface DAO<T> {
    void save(T value);

    void update(T value);

    void delete(T value);

    T findOne(int id);

    List<T> findAll();
}
