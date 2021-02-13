package com.io.orangeTalents.Loteria.service;

import com.io.orangeTalents.Loteria.domain.Participante;
import com.io.orangeTalents.Loteria.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository repository;

    //método que salva no banco o
    //participante e os numeros gerados para no mesmo
    public Participante realizarAposta(String email){
        Participante novo = new Participante(email);
        novo.setDataAposta(LocalDate.now());
        return repository.save(novo);
    }

    public List<Participante>listarTodos(){
        return repository.findAll();
    }

    public Optional<Participante> buscarAposta(Long id){
        return repository.findById(id);
    }

    public List<Participante>listaDeApostasPorPessoa(String email){
        return repository.buscaPorEmail(email);
    }

}
