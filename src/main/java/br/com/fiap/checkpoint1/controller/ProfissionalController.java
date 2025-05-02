package br.com.fiap.checkpoint1.controller;

import br.com.fiap.checkpoint1.dto.ProfissionalRequestCreate;
import br.com.fiap.checkpoint1.dto.ProfissionalRequestUpdate;
import br.com.fiap.checkpoint1.dto.ProfissionalResponse;
import br.com.fiap.checkpoint1.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService service;

    @PostMapping
    public ResponseEntity<ProfissionalResponse> create(@RequestBody ProfissionalRequestCreate dto) {
        return ResponseEntity.status(201).body(service.create(dto));
    }

    @GetMapping
    public List<ProfissionalResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> getById(@PathVariable Long id) {
        ProfissionalResponse response = service.getById(id);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalResponse> update(@PathVariable Long id, @RequestBody ProfissionalRequestUpdate dto) {
        ProfissionalResponse response = service.update(id, dto);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
