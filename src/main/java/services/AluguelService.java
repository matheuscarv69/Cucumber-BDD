package services;

import entities.Filme;
import entities.NotaAluguel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static helpers.DateMethods.calcularDataEntrega;

public class AluguelService {

    public static NotaAluguel alugar(Filme filme, Integer diasAlugados) {
        int estoqueFilme = filme.getEstoque();
        filme.setEstoque(estoqueFilme -= 1);

        NotaAluguel nota = new NotaAluguel();
        nota.setFilme(filme);
        nota.setDiasAlugados(diasAlugados);
        nota.setPrecoAluguelFinal(filme.getPrecoAluguel() * diasAlugados);
        nota.setDataEntrega(calcularDataEntrega(diasAlugados));
        return nota;
    }



}
