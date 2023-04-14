package com.LaptopCuaHung.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderInfo 
{
    @EmbeddedId 
    private OrderInfoKey orderInfoKey;

    @ManyToOne
    @MapsId(value = "order")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId(value = "product")
    @JoinColumn(name = "product_id")
    private Product product;

    private long total;
    private int quantity;
    private int receiveQuantity;
}
