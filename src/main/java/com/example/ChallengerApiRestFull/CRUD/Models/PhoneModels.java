package com.example.ChallengerApiRestFull.CRUD.Models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class PhoneModels {
    @Id
    @Column
    private Long number;

    @Column
    private Long cityCode;

    @Column
    private Long countryCode;

    public PhoneModels() {
        this.number = 0L;
        this.cityCode = 0L;
        this.countryCode = 0L;
    }

    public PhoneModels(Long number, Long cityCode, Long countryCode) {
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
    }

    private void setNumber(Long number) {
        this.number = number;
    }

    private void setCityCode(Long cityCode) {
        this.cityCode = cityCode;
    }

    private void setCountryCode(Long countryCode) {
        this.countryCode = countryCode;
    }
}
