package com.tns.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="users")
public class User extends BaseEntity{

    @Id
    private Long id;

}

