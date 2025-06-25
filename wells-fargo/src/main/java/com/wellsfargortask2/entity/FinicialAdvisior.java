package com.wellsfargortask2.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name = "finicialAdvisior")


@Slf4j
public class FinicialAdvisior {

    public FinicialAdvisior() {
        log.info("the FinicialAdvisior Constructor method is invoking");
    }

    @Id
    @Column(name = "fa_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "finicialAdvisior", cascade = CascadeType.ALL)
    private List<Clients> clientsList;


    public FinicialAdvisior(String name, String email, List<Clients> clientsList) {
        this.name = name;
        this.email = email;
        this.clientsList = clientsList;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Clients> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Clients> clientsList) {
        this.clientsList = clientsList;
    }

}

