package com.LaptopCuaHung.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Contact 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String contactEmail;
    private String contactContent;
    private String responseContent;
    private String status;

    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date contactDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date responseDate;

    @ManyToOne
    @JoinColumn(name = "respondent_id")
    private User respondentId;
}
