package com.LaptopCuaHung.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Manufacturer 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;    

    private String name;

    @OneToMany(mappedBy = "manufacturer")
    private List<Product> products;
}
