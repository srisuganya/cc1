package com.example.gardening;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Garden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
 
    @Column(name = "materialtype")
    private String materialtype;

    @Column(name = "price")
    private Integer price;

    @Column(name = "no.of.items")
    private Integer items;

    

    

    public Garden(Integer id, String name, String materialtype, Integer price, Integer items) {
        this.id = id;
        this.name = name;
        this.materialtype=materialtype;
        this.price=price;
        this.items=items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterialtype() {
        return materialtype;
    }

    public void setMaterialtype(String materialtype) {
        this.materialtype=materialtype;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price= price;
    }
    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items=items;
    }
}

