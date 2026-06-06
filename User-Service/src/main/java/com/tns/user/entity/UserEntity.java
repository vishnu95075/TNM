package com.tns.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="users")
public class UserEntity extends BaseEntity{

    @Id
    @GeneratedValue()
    private Long id;

    private String name;
    private String email;
    private String contactNo;

}

