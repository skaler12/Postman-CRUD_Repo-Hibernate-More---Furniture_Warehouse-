package com.example.furniture_warehouse.dao;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
Fetch type |Eager/Lazy|
example  :
@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
  private Set<OrderItem> items = new HashSet<OrderItem>();

  !!!! items loading at start api !!!!

 @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
  private Set<OrderItem> items = new HashSet<OrderItem>();

  !!!! items loading at request !!!!


Cascade Type

Example

Entity relationships often depend on the existence of another entity — for example, the Person–Address relationship.
 Without the Person, the Address entity doesn't have any meaning of its own. When we delete the Person entity,
 our Address entity should also get deleted.

 Types:
 ALL
PERSIST
MERGE
REMOVE
REFRESH
DETACH
 */


@Entity
@Table(name="Furniture")
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "weight")
    private int weight;

    public Furniture(){};
    public Furniture(String name,int weight){

        this.name=name;
        this.weight=weight;
    }
    public  Furniture(String name, int weight, Colour colour, Type type, Owner owner,Set<User> users){
        this.name=name;
        this.weight=weight;
        this.colour=colour;
        this.type=type;
        this.owner=owner;
        this.users=users;
    }
    @Enumerated(value=EnumType.STRING)
     private  Colour colour;

    /*
    relacja 2 kierunkowa
     */
    @ManyToOne
    private Type type;
/*
relacja 2 kierunkowa
 */
    @OneToOne
    private Owner owner;

    @ManyToMany
    @JoinTable(name = "furniture_category",
         joinColumns = @JoinColumn(name = "furniture_id"),
         inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private Set<User> users=new HashSet<>();


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return weight == furniture.weight &&
                Objects.equals(id, furniture.id) &&
                Objects.equals(name, furniture.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight);
    }

}
