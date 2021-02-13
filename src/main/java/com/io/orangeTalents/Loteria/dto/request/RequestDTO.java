package com.io.orangeTalents.Loteria.dto.request;

import com.io.orangeTalents.Loteria.domain.Participante;
import lombok.Data;

@Data
public class RequestDTO {

    private String email;

    /*public Participante converter(String email){
        return new Participante(email);
    }*/
}
