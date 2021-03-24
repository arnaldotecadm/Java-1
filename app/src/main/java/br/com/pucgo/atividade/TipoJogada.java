package br.com.pucgo.atividade;

import java.util.Arrays;
import java.util.List;

public enum TipoJogada {
    PEDRA(0, "pedra") {
        Boolean julga(TipoJogada oponente) {
            switch (oponente) {
                case PAPEL:
                    return false;
                case TESOURA:
                    return true;
                default:
                    return null;
            }
        }

        ;
    },
    PAPEL(1, "papel") {
        Boolean julga(TipoJogada oponente) {
            switch (oponente) {
                case TESOURA:
                    return false;
                case PEDRA:
                    return true;
                default:
                    return null;
            }
        }
    },
    TESOURA (2,"tesoura"){
        Boolean julga(TipoJogada oponente) {
            switch (oponente) {
                case PEDRA:
                    return false;
                case PAPEL:
                    return true;
                default:
                    return null;
            }
        }
    };

    abstract Boolean julga(TipoJogada tipo);

    private final int codigo;
    private final String nome;

    private TipoJogada(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    public static TipoJogada getEnumByCodigo(int codigo){
        List<TipoJogada> tipoJogadas = Arrays.asList(TipoJogada.values());
        for(TipoJogada tj : tipoJogadas){
            if(tj.codigo == codigo){
                return tj;
            }
        }

        throw new RuntimeException("Tipo de jogada nao permitida!!!");
    }

    public static TipoJogada getEnumByNome(String nome){
        List<TipoJogada> tipoJogadas = Arrays.asList(TipoJogada.values());
        for(TipoJogada tj : tipoJogadas){
            if(tj.nome.equalsIgnoreCase(nome)){
                return tj;
            }
        }

        throw new RuntimeException("Tipo de jogada nao permitida!!!");
    }
}
