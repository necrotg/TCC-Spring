package com.unip.tcc2k22.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity

public class DataSpring implements Serializable {
    private static final int serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean isActive;
    private String balance;
    private int age;
    private String name;
    private String gender;
    private String company;
    private String email;
    private String phone;
    private String address;
}
