package com.wellsfargortask2.entity;


import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Entity
@Table(name = "clients")
public class Clients {

    public Clients() {
        log.info("the Clients Constructor method is invoking..");
    }

    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "c_email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "fa_id")
    private FinicialAdvisior finicialAdvisior;

    @Transient
    private Integer fAId;

    @OneToOne(mappedBy = "clients", cascade = CascadeType.ALL)
    private Portfolio portfolio;

    // constructor
    public Clients(String name, String email, FinicialAdvisior finicialAdvisior, Portfolio portfolio) {
        this.name = name;
        this.email = email;
        this.finicialAdvisior = finicialAdvisior;
        this.portfolio = portfolio;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FinicialAdvisior getFinicialAdvisior() {
        return finicialAdvisior;
    }

    public void setFinicialAdvisior(FinicialAdvisior finicialAdvisior) {
        this.finicialAdvisior = finicialAdvisior;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }


}
