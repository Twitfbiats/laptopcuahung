package com.LaptopCuaHung.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role 
{
    @Id
    @GeneratedValue
    private long id;

    private String roleName;

    @ManyToMany(mappedBy = "roles")
    List<User> users;
}
