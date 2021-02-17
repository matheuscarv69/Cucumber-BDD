package services;

import entities.Filme;
import entities.NotaAluguel;

import static helpers.DateMethods.calcularDataEntrega;

public class AluguelService {

    public static NotaAluguel alugar(Filme filme, Integer diasAlugados, NotaAluguel nota) {

        if (filme.getEstoque() == 0) {
            throw new RuntimeException("O filme não tem estoque");
        } else {

            int estoqueFilme = filme.getEstoque();
            filme.setEstoque(estoqueFilme -= 1);

            nota.setFilme(filme);
            nota.setDiasAlugados(diasAlugados);

            switch (nota.getTipoAluguel()) {
                case SEMANAL:
                    nota.setPrecoAluguelFinal(filme.getPrecoAluguel() * (diasAlugados - 4));
                    nota.setPontuacao(3);
                    break;
                case EXTENDIDO:
                    nota.setPrecoAluguelFinal(filme.getPrecoAluguel() * (diasAlugados - 1));
                    nota.setPontuacao(2);
                    break;
                case COMUM:
                default:
                    nota.setPrecoAluguelFinal(filme.getPrecoAluguel() * diasAlugados);
                    nota.setPontuacao(1);
                    break;
            }

            nota.setDataEntrega(calcularDataEntrega(diasAlugados));
        }

        return nota;
    }


}
