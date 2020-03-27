package com.minhchauptit.scoremanagement.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ip")
public class Ip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ip", unique = true)
    private String ip;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


}
