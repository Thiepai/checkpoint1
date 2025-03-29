package br.com.fiap.checkpoint1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint1.dto.PacienteRequestCreate;
import br.com.fiap.checkpoint1.dto.PacienteRequestUpdate;
import br.com.fiap.checkpoint1.dto.PacienteResponse;
import br.com.fiap.checkpoint1.model.Paciente;
import br.com.fiap.checkpoint1.repository.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public PacienteResponse createPaciente(PacienteRequestCreate dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setEndereco(dto.getEndereco());
        paciente.setBairro(dto.getBairro());
        paciente.setEmail(dto.getEmail());
        paciente.setTelefoneCompleto(dto.gettelefoneCompleto());

        Paciente salvo = repository.save(paciente);

        return toResponse(salvo);
    }

    public PacienteResponse updatePaciente(Long id, PacienteRequestUpdate dto) {
        Optional<Paciente> optional = repository.findById(id);
        if (optional.isEmpty()) return null;

        Paciente paciente = optional.get();
        paciente.setNome(dto.getNome());
        paciente.setEndereco(dto.getEndereco());
        paciente.setBairro(dto.getBairro());
        paciente.setEmail(dto.getEmail());
        paciente.setTelefoneCompleto(dto.gettelefoneCompleto());

        return toResponse(repository.save(paciente));
    }

    public boolean deletePaciente(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    public PacienteResponse getPacienteById(Long id) {
        Optional<Paciente> paciente = repository.findById(id);
        return paciente.map(this::toResponse).orElse(null);
    }

    public List<PacienteResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private PacienteResponse toResponse(Paciente paciente) {
        PacienteResponse response = new PacienteResponse();
        response.setId(paciente.getId());
        response.setNome(paciente.getNome());
        response.setEndereco(paciente.getEndereco());
        response.setBairro(paciente.getBairro());
        response.setEmail(paciente.getEmail());
        response.settelefoneCompleto(paciente.getTelefoneCompleto());
        return response;
    }
}