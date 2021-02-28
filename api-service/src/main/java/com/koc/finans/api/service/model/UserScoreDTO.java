package com.koc.finans.api.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserScoreDTO {

    protected String identityNumber;
    protected String name;
    protected String surname;
    protected int income;
    protected String phone;
    protected String city;
}
