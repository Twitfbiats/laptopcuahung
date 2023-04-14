package com.LaptopCuaHung.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String address;
    private String email;
    private String name;
    private String password;
    @Transient private String retypedPassword;
    private String phoneNumber;

    @ManyToMany
    @JoinTable
    (name = "user_role",
    joinColumns = @JoinColumn(name = "user"),
    inverseJoinColumns = @JoinColumn(name = "role"))
    private List<Role> roles;

    @OneToMany(mappedBy = "purchaser")
    private List<Order> orders;

    @OneToMany(mappedBy = "shipper")
    private List<Order> ships;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    @OneToMany(mappedBy = "respondentId")
    private List<Contact> responses;
}
