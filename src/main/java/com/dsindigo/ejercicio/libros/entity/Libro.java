package com.dsindigo.ejercicio.libros.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "LIBRO")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String nombre;
    @NonNull
    private String autor;
    @NonNull
    private Integer paginas;
    @NonNull
    private String editorial;
    private String img;
    private Boolean activo;




}
