/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author Huy
 */
public abstract class SystemDAO<E, K> {
    abstract public void create(E entity);

    abstract public void update(E entity);

    abstract public void delete(K id);

    abstract public List<E> getAll();

    abstract public E getById(K id);

    abstract protected List<E> getBySql(String sql, Object... args);
}
