package com.dsindigo.ejercicio.libros.controller;


import com.dsindigo.ejercicio.libros.entity.Libro;
import com.dsindigo.ejercicio.libros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/libros")
    public Collection<Libro> coolCars() {
        return libroRepository.findAll();
    }

    @GetMapping("/libro/{id}")
    ResponseEntity<?> getLibro(@PathVariable Long id) {
        Optional<Libro> group = libroRepository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/libro")
    ResponseEntity<Libro> createLibro(@Valid @RequestBody Libro libro) throws URISyntaxException {
        Libro result = libroRepository.save(libro);
        return ResponseEntity.created(new URI("/libro/" + result.getId()))
                .body(result);
    }

    @PutMapping("/libro/{id}")
    ResponseEntity<Libro> updateLibro(@Valid @RequestBody Libro libro) {
        Libro result = libroRepository.save(libro);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/libro/{id}")
    public ResponseEntity<?> deleteLibro(@PathVariable Long id) {
        libroRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
