package com.rj.esqueleto.infrastructure.admin.crud.persistence.springdata;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rj.esqueleto.infrastructure.admin.crud.persistence.entity.CrudEntityJpa;

@Repository
public interface crudSpringDataRepository extends JpaRepository<CrudEntityJpa, Long> {
    Optional<CrudEntityJpa> findByName(String name);
    List<CrudEntityJpa> findByNameIn(Collection<String> names);
}