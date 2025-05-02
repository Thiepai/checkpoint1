package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.dto.ProfissionalRequestCreate;
import br.com.fiap.checkpoint1.dto.ProfissionalRequestUpdate;
import br.com.fiap.checkpoint1.dto.ProfissionalResponse;
import br.com.fiap.checkpoint1.model.Profissional;
import br.com.fiap.checkpoint1.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository repository;

    public ProfissionalResponse create(ProfissionalRequestCreate dto) {
        Profissional profissional = new Profissional();
        profissional.setNome(dto.getNome());
        profissional.setEspecialidade(dto.getEspecialidade());
        profissional.setValorHora(dto.getValorHora());

        Profissional saved = repository.save(profissional);
        return toResponse(saved);
    }

    public List<ProfissionalResponse> getAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ProfissionalResponse getById(Long id) {
        Optional<Profissional> profissional = repository.findById(id);
        return profissional.map(this::toResponse).orElse(null);
    }

    public ProfissionalResponse update(Long id, ProfissionalRequestUpdate dto) {
        Optional<Profissional> optional = repository.findById(id);
        if (optional.isEmpty()) return null;

        Profissional profissional = optional.get();
        profissional.setNome(dto.getNome());
        profissional.setEspecialidade(dto.getEspecialidade());
        profissional.setValorHora(dto.getValorHora());

        Profissional updated = repository.save(profissional);
        return toResponse(updated);
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    private ProfissionalResponse toResponse(Profissional profissional) {
        ProfissionalResponse response = new ProfissionalResponse();
        response.setId(profissional.getId());
        response.setNome(profissional.getNome());
        response.setEspecialidade(profissional.getEspecialidade());
        response.setValorHora(profissional.getValorHora());
        return response;
    }
}
