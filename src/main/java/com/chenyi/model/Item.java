package com.chenyi.model;

public class Item {
    private product product;
    private int qunatity;
    public Item(){

    }

    public Item(com.chenyi.model.product product, int qunatity) {
        this.product = product;
        this.qunatity = qunatity;
    }

    public com.chenyi.model.product getProduct() {
        return product;
    }

    public void setProduct(com.chenyi.model.product product) {
        this.product = product;
    }

    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "product=" + product +
                ", qunatity=" + qunatity +
                '}';
    }
}
