package com.desanlesr95.pizzeria.persitence.audit;

import com.desanlesr95.pizzeria.persitence.entity.PizzaEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.SerializationUtils;

public class AuditPizzaLiestener {
    private  PizzaEntity currentValue;
    @PostLoad
    public void postLoad(PizzaEntity entity){
        System.out.println(entity.toString());
        this.currentValue = SerializationUtils.clone(entity);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersit(PizzaEntity entity){
        System.out.println("Valor anterior :"+currentValue.toString());
        System.out.println(entity.toString());
    }
    @PreRemove
    public void OnPreDelete(PizzaEntity entity){
        System.out.println(entity.toString());
    }
}
