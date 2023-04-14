package com.LaptopCuaHung.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Orders")
@Getter
@Setter
public class Order 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String address;
    private String note;
    private String receiverName;

    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date orderDate;
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date shipDate;
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date receiveDate;

    private String receivePhoneNumber;
    private long total;
    private String status;

    @ManyToOne
    @JoinColumn(name = "purchaser_id")
    private User purchaser;

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private User shipper;

    @OneToMany(mappedBy = "order")
    private List<OrderInfo> orderInfos;
}
