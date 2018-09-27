package com.tedu.dto;

public class GoodsDto {
    private Integer id;
    private String name;
    private Double price;
    private String image;

    public GoodsDto(String name, Double price, String image,Integer id) {
        this.name = name;
        this.price = price;
        this.image=image;
        this.id=id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "GoodsDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
