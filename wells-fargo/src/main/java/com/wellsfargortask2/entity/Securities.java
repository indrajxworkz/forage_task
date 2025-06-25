package com.wellsfargortask2.entity;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "securities")
@Slf4j

public class Securities {

    public Securities() {
        log.info("Securities Constructor method is invoking...");
    }

    @Id
    @Column(name = "s_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "s_name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "purchase_price")
    private double purchasePrice;

    @Column(name = "quantity")
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "p_id")
    private Portfolio portfolio;

    @Transient
    private Integer portfolioId;

    //constructor
    public Securities(String name, String category, Date purchaseDate, double purchasePrice, double quantity, Portfolio portfolio) {
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.portfolio = portfolio;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}

