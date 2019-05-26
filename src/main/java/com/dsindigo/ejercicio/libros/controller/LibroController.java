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
import java.util.List;
import java.util.Optional;
//$ git remote add origin git@github.com:jancarlo5/libro

@RestController

public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/libros")
    @CrossOrigin(origins = "*")
    public List<Libro> getLibros() {
        return libroRepository.findAll();
    }

    @GetMapping("/libros/{id}")
    @CrossOrigin(origins = "*")
    ResponseEntity<Libro> getLibro(@PathVariable Long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        return libro.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/libros")
    @CrossOrigin(origins = "*")
    ResponseEntity<?> createLibro(@Valid @RequestBody Libro libro) throws URISyntaxException {
        Libro result = libroRepository.save(libro);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/libros/{id}")
    @CrossOrigin(origins = "*")
    ResponseEntity<?> updateLibro(@PathVariable Long id, @Valid @RequestBody Libro libro) {

        Libro result = libroRepository.save(libro);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/libros/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Libro> deleteLibro(@PathVariable Long id) {
        libroRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
