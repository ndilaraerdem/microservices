package com.etiya.inventoryservice.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fuels")
public class Fuel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @Size(min = 3, max = 30)
    private String name;

    @OneToMany(mappedBy = "fuel")
    private List<Car> cars;
}
