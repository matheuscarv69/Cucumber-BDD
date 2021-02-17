package services;

import entities.Filme;
import entities.NotaAluguel;

import static helpers.DateMethods.calcularDataEntrega;

public class AluguelService {

    public static NotaAluguel alugar(Filme filme, Integer diasAlugados) {
        NotaAluguel nota = new NotaAluguel();

        if (filme.getEstoque() == 0) {
            throw new RuntimeException("O filme não tem estoque");
        } else {

            int estoqueFilme = filme.getEstoque();
            filme.setEstoque(estoqueFilme -= 1);

            nota.setFilme(filme);
            nota.setDiasAlugados(diasAlugados);
            nota.setPrecoAluguelFinal(filme.getPrecoAluguel() * diasAlugados);
            nota.setDataEntrega(calcularDataEntrega(diasAlugados));
        }

        return nota;
    }


}
