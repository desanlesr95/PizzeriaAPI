package com.desanlesr95.pizzeria.persitence.repository;

import com.desanlesr95.pizzeria.persitence.entity.PizzaEntity;
import com.desanlesr95.pizzeria.serivce.dto.UpdatePizzaPriceDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    PizzaEntity findFirstByAvailableTrueAndNameIgnoreCase(String name);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double pirce);
    int countByVeganTrue();

    @Query(value = "UPDATE pizza SET price = :#{#newPizzaPrice.newPrice} where id_pizza = :#{#newPizzaPrice.pizzaId}",nativeQuery = true)
    @Modifying
    void updatePrice(@Param("newPizzaPrice") UpdatePizzaPriceDto newPizzaPrice);
}
