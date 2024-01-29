package com.jithspycca.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@Table(name ="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int personId;

    @Column(name ="name")
    private String name;
    @Column(name ="password")
    private String password;
    @Column(name ="email")
    private String email;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH,targetEntity = Roles.class)
    @JoinColumn(name = "role_id",referencedColumnName = "roleId",nullable = false)
    private Roles roles;
}
