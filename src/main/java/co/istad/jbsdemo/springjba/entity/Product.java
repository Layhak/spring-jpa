package co.istad.jbsdemo.springjba.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products_tbl")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private float price;
}
