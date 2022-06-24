package model;

import java.math.BigDecimal;

public class Product {
    private Integer id;
    private String name;
    private String imgSrc;
    private BigDecimal price;
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public Integer setId(Integer id) {
        return this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer setQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
