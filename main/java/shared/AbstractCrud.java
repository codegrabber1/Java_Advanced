package shared;

import java.util.List;

public interface AbstractCrud<T> {

    List<T> readAll();

    T create(T t);

    T read(Integer id);

    T update(T t);

    void delete(Integer id);

}
