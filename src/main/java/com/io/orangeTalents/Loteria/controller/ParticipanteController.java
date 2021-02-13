package com.io.orangeTalents.Loteria.controller;

import com.io.orangeTalents.Loteria.domain.Participante;
import com.io.orangeTalents.Loteria.dto.request.RequestDTO;
import com.io.orangeTalents.Loteria.repository.ParticipanteRepository;
import com.io.orangeTalents.Loteria.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class ParticipanteController {

    @Autowired
    private ParticipanteService service;

    @Autowired
    private ParticipanteRepository repository;


    @PostMapping("/salvar")
    public Participante salvar(@RequestBody Participante participante){
        return service.realizarAposta(participante.getEmail());
    }

    @GetMapping("/lista")
    public List<Participante>listarTodasApostas(){
        return service.listarTodos();
    }

    @GetMapping("/busca/{id}")
    public Participante buscarAposta(Long id){
        return service
                .buscarAposta(id)
                .orElseThrow(() -> {
                    throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Aposta não encontrada :(");
                });
    }

    @GetMapping("/listagem/{email}")
    public List<Participante>buscaPorEmail(@PathVariable("email") String email){
        return service.listaDeApostasPorPessoa(email);
    }
}
