package com.desanlesr95.pizzeria.persitence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@IdClass(UserRoleId.class)
@NoArgsConstructor
public class UserRoleEntity {
    @Id
    @Column(nullable = false,length = 20)
    private String username;


    @Id
    @Column(nullable = false,length = 20)
    private String role;

    @Column(name = "granted_date",nullable = false,columnDefinition = "DATETIME")
    private LocalDateTime grantedDate;


    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username",insertable = false)
    private UserEntity user;
}
