package com.io.orangeTalents.Loteria.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class GerarNumeros {
    public static int gerar(int index){
        List<Integer>numeros = new ArrayList<>();
        for(int i = 0; i < 60; i++){
            numeros.add(i + 1);
        }
    return numeros.remove(index);
    }
}
