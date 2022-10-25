package com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.entity;

import com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.validation.OnCreate;
import com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.validation.UniqueName;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "name", unique = true)
    @NotBlank(message = "name is required field", groups = {OnCreate.class, Default.class})
    @UniqueName(groups = {OnCreate.class})
    private String name;

    @Column(name = "text")
    @NotBlank(message = "text is required field", groups = {OnCreate.class, Default.class})
    private String text;

    @Column(name = "price")
    @DecimalMin(value = "0.0", inclusive = false, message = "price must be more than 0.0"
            , groups = {OnCreate.class, Default.class})
    @NotNull(message = "price is required field", groups = {OnCreate.class, Default.class})
    private float price;


    public Product() {
    }

    public Product(String name, String text, float price) {
        this.name = name;
        this.text = text;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", price=" + price +
                '}';
    }
}
