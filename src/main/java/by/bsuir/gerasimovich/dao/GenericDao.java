/**
 * Унифицированный интерфейс управления персистентным состоянием объектов
 *
 * @param <T> тип объекта персистенции
 * @param <PK> тип первичного ключа
 */
package by.bsuir.gerasimovich.dao;

import java.sql.SQLException;
import java.util.List;


/**
 * @author Tatiana
 * @version 1.00 07.04.2015.
 */
public interface GenericDao<T> {

    /**
     * Создает новую запись, соответствующую объекту object
     */
    public void persist(T object) throws PersistException, SQLException;

    /**
     * Возвращает объект соответствующий записи с первичным ключом key или null
     */
    public T getByPK(Integer key,String nameOfId) throws PersistException, SQLException;

    /**
     * Сохраняет состояние объекта в базе данных
     */
    public void update(T object) throws PersistException, SQLException;

    /**
     * Удаляет запись об объекте из базы данных
     */
    public void delete(T object) throws PersistException, SQLException;

    /**
     * Возвращает список объектов соответствующих всем записям в базе данных
     */
    public List<T> getAll() throws PersistException, SQLException;
}
