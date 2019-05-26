package com.dsindigo.ejercicio.libros.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * Created by pc on 26/05/2019.
 */
@Data
@Entity
@Table(name = "user", uniqueConstraints =@UniqueConstraint(columnNames = "names"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_name",
            joinColumns = @JoinColumn(
                    name ="user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;




}
