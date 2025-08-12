package com.project.inventory_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer warehousId;

    private String warehouseName;
    private String warehouseAddress;

    @OneToMany(mappedBy = "warehouse")
    private List<Inventory> inventories;
}
