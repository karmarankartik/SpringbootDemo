package com.example.demo.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue
    private Long id;


    @Column(name="student_name", length=50, nullable=false, unique=false)
    private String name;

    //temporal time and timestamp alos exist

    @Temporal(TemporalType.DATE)
    @Column(name="date")
    private Date birthDate;

  

    @Column(name="gender")
    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

  

    
}
