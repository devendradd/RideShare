package com.allstate.entities;

import com.allstate.enums.Gender;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "passengers")
@Data
public class Passenger {
    private int id;
    private int version;
    private int age;
    private String name;
    private Gender gender;
    private double credit_balance;
    private Date created;
    private Date modified;

    public Passenger(){

    }

    public Passenger(int age, String name, Gender gender, double credit_balance) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.credit_balance = credit_balance;
    }

    @GeneratedValue
    @Id
    public int getId() {return id; }
    public void setId(int id) {  this.id = id;}
    @Version
    public int getVersion() { return version; }
    public void setVersion(int version) {  this.version = version; }
    @Min(value = 21)
    public int getAge() {  return age;}
    public void setAge(int age) {this.age = age; }
    @Size(min =  1)
    public String getName() {  return name; }
    public void setName(String name) { this.name = name; }
    @Column(columnDefinition = "ENUM('MALE','FEMALE')")
    @Enumerated(EnumType.STRING)
    @NotNull
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    @NotNull
    public double getCredit_balance() { return credit_balance;}
    public void setCredit_balance(double credit_balance) { this.credit_balance = credit_balance;}
    @CreationTimestamp
    public Date getCreated() { return created;}
    public void setCreated(Date created) { this.created = created; }
    @UpdateTimestamp
    public Date getModified() {  return modified; }
    public void setModified(Date modified) {this.modified = modified;}

}
