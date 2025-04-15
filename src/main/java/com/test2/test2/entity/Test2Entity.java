package com.test2.test2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
//@Table(name="test2")
public class Test2Entity {
    @Id
    private Integer idd;
    private String name;
    private String country;
}
