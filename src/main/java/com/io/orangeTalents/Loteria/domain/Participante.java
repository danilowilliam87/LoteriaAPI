package com.io.orangeTalents.Loteria.domain;

import com.io.orangeTalents.Loteria.util.GerarNumeros;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "participante")
public class Participante {

    public Participante( String email ){
        this.email = email;
        StringBuilder builder = new StringBuilder();
        SecureRandom random = new SecureRandom();
        List<Integer>nums = new ArrayList<>();
        for(int i = 0; i < 60; i++){
            nums.add( i + 1 );
        }

        int cont = 59;
        builder.append("[ ");
        for (int i = 0; i < 15; i++) {
            int rand = random.nextInt(cont);
            if(i <= 13) {
                builder.append(nums.get(rand));
                builder.append(", ");
            }
            else{builder.append(nums.get(rand));}
            cont = cont - 1;
            nums.remove(rand);
        }
        builder.append(" ]");
        this.numeros = builder.toString();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "{campo.email.mensagem}")
    @Column(name = "email")
    private String email;

    @Column(name = "numeros")
    private String numeros;

    //data da realização da aposta
    @Column(name = "data_aposta")
    private LocalDate dataAposta;
}
