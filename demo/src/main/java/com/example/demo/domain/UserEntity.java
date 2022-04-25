package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "users", catalog = "")
public class UserEntity {
    private int userdId;
    private String name;
    private String pass;
    private String mail;

    @Id
    @Column(name = "userd_id")
    public int getUserdId() {
        return userdId;
    }

    public void setUserdId(int userdId) {
        this.userdId = userdId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pass")
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userdId == that.userdId && Objects.equals(name, that.name) && Objects.equals(pass, that.pass) && Objects.equals(mail, that.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userdId, name, pass, mail);
    }
}
