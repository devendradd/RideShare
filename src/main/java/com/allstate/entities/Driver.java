package com.allstate.entities;

import com.allstate.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.tools.javac.code.Attribute;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "drivers")
@Data
public class Driver {
    private int id;
    private int version;
    private String name;
    private int age;
    private Gender gender;
    private int tickets;
    private Date created;
    private Date modified;
    private City city;
    private List<Car> car;

    public Driver(){

    }

    public Driver(String name, int age, Gender gender, int tickets) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.tickets = tickets;
    }

    @GeneratedValue
    @Id
    public int getId() { return id; }
    public void setId(int id) {  this.id = id; }

    @Version
    public int getVersion() { return version;}
    public void setVersion(int version) {  this.version = version; }

    @Size(min = 1)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Min(value = 21)
    public int getAge() { return age;}
    public void setAge(int age) { this.age = age;}

    @Column(columnDefinition = "ENUM('MALE','FEMALE')")
    @Enumerated(EnumType.STRING)
    @NotNull
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender;  }

    @Min(value = 0)
    public int getTickets() {return tickets;}
    public void setTickets(int tickets) { this.tickets = tickets;}

    @CreationTimestamp
    public Date getCreated() { return created;}
    public void setCreated(Date created) { this.created = created;}
    @UpdateTimestamp
    public Date getModified() {  return modified;}
    public void setModified(Date modified) { this.modified = modified; }

    @ManyToOne
    @JoinColumn(name="driver_id")
    public City getCity() { return city;}
    public void setCity(City city) {  this.city = city;}


    @OneToMany(mappedBy = "car_id")
    public List<Car> getCar() {  return car;  }
    public void setCar(List<Car> car) {  this.car = car; }


}
