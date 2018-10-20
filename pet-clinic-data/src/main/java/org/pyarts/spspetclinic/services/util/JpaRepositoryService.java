package org.pyarts.spspetclinic.services.util;

import java.util.Set;

public interface JpaRepositoryService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}
