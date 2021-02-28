package com.koc.finans.api.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "income")
@Getter
@Setter
public class Income {
    @Id
    @Column(name = "code", nullable = false)
    protected int code;
    @Column(name = "multipler", nullable = false)
    protected int multipler;
    @Column(name = "description", nullable = false)
    protected String description;
}
