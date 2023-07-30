package com.example.ChallengerApiRestFull.CRUD.Models;

import com.example.ChallengerApiRestFull.CRUD.Utils.JWT.JWT;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@EqualsAndHashCode
@Table(name = "Users")
public class UsersModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Getter
    @Column
    private String name;

    @Getter
    @Column
    private String email;

    @Getter
    @Column
    private String password;

    @Getter
    @Column
    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneModels> phones;

    @Getter
    @Column
    private Date created;

    @Getter
    @Column
    private Date modified;

    @Getter
    @Column
    private Date lastLogin;

    @Getter
    @Column
    private String token;

    @Column
    private Boolean isActive;

    public UsersModels() {
        this.id = UUID.randomUUID();
        this.name = null;
        this.email = null;
        this.password = null;
        this.phones = new ArrayList<>();
        this.created = new Date();
        this.modified = new Date();
        this.lastLogin = new Date();
        this.token = null;
        this.isActive = false;
    }

    public UsersModels(String name, String email, String password, List<PhoneModels> phones, Boolean isActive) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.created = new Date();
        this.modified = null;
        this.lastLogin = null;
        this.token = UUID.randomUUID().toString();
        //JWT jwt = new JWT();
        //this.token = jwt.createJwt(email);
        this.isActive = isActive;
    }

    public UsersModels(UUID id, String name, String email, String password, Date created, List<PhoneModels> phones, String token, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.created = created;
        this.modified = new Date();
        this.lastLogin = created;
        this.token = token;
        this.isActive = isActive;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhones(List<PhoneModels> phones) {
        this.phones = phones;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
