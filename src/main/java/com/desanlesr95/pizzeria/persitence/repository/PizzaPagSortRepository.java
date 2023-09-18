package com.desanlesr95.pizzeria.persitence.repository;

import com.desanlesr95.pizzeria.persitence.entity.PizzaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;



public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<PizzaEntity,Integer> {
    Page<PizzaEntity> findByAvailableTrue(Pageable pageable);
}
