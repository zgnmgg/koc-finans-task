package com.koc.finans.api.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_score")
@Getter
@Setter
public class UserModel {
    @Id
    @Column(name = "identity_number", nullable = false)
    protected String identityNumber;
    @Column(name = "phone", nullable = false)
    protected String phone;
    @Column(name = "name", nullable = false)
    protected String name;
    @Column(name = "surname", nullable = false)
    protected String surname;
    @Column(name = "city", nullable = false)
    protected String city;
    @Column(name = "score", nullable = false)
    protected int score;

}
