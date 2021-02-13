package com.io.orangeTalents.Loteria.repository;


import com.io.orangeTalents.Loteria.domain.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

    @Query("from Participante p where p.email=:email")
    public List<Participante> buscaPorEmail(@Param("email") String email);
}
