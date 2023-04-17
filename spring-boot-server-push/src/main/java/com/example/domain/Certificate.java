package com.example.domain;

public class Certificate {
    private String date;
    private double price;


    public Certificate(String date, double price) {
        this.date = date;
        this.price = price;
    }

    public Certificate() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.date+"股票价格"+this.price;
    }
}
