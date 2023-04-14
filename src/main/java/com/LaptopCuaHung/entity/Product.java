package com.LaptopCuaHung.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String cpu;
    private String pin;
    private String operatingSystem;
    private String display;
    private String ram;
    private String graphicCard;
    private String drive;
    private String port;
    private String warranty;
    private String description;

    private long price;
    private int sold;
    private int stock;

    @Transient
    private MultipartFile image;

    @OneToMany(mappedBy = "product")
    private List<CartInfo> cartInfos;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "product")
    private List<OrderInfo> orderInfos;
}
