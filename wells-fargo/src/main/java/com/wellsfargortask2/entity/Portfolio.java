package com.wellsfargortask2.entity;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "portfolio")

@Slf4j
public class Portfolio {

    public Portfolio() {
        log.info("Portfolio Constructor method is invoking");
    }

    @Id
    @Column(name = "p_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "c_id")
    private Clients clients;

    private Integer clientsId;

    @OneToMany(mappedBy = "securities", cascade = CascadeType.ALL)
    private List<Securities> securities;

    public Portfolio(Clients clients, List<Securities> securities) {
        this.clients = clients;
        this.securities = securities;
    }

    public int getId() {
        return id;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public List<Securities> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Securities> securities) {
        this.securities = securities;
    }

}
