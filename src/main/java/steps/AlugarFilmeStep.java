package steps;

import entities.Filme;
import entities.NotaAluguel;
import entities.enums.TipoAluguel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import services.AluguelService;

import java.util.*;

import static helpers.DateMethods.calcularDataEntrega;
import static helpers.DateMethods.sdfFormater;

public class AlugarFilmeStep {


    private AluguelService aluguelService;

    private Filme filme;
    private NotaAluguel notaAluguel = new NotaAluguel();

    private List<String> errors = new ArrayList<>();

    @Dado("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(Integer estoque) {
        filme = new Filme();
        filme.setEstoque(estoque);
    }

    @Dado("^que o preço de aluguel seja R\\$ (.*)$")
    public void queOPreçoDeAluguelSejaR$(String strPreco) {
        String strPrecoFormatado = strPreco.replaceAll(",", ".");
        Double preco = Double.parseDouble(strPrecoFormatado);
        filme.setPrecoAluguel(preco);
    }

    @Dado("um filme")
    public void umFilme(DataTable dataTable) {
        /** Map de String's por conta que as Wrapper class de estoque e preco, são
         diferentes. (Integer e Double) */
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        filme = new Filme();
        filme.setEstoque(Integer.parseInt(map.get("estoque")));
        filme.setPrecoAluguel(Double.parseDouble(map.get("preco")));

    }

    @Quando("alugar por {int} dia(s)")
    public void alugar(Integer dias) {
        try {
            notaAluguel = aluguelService.alugar(filme, dias, notaAluguel);
        } catch (RuntimeException e) {
            errors.add(e.getMessage());
        }
    }

    @Então("^o preço do aluguel será R\\$ (.*)$")
    public void oPreçoDoAluguelSeráR$(String strPreco) {
        String strPrecoFormatado = strPreco.replaceAll(",", ".");
        Double preco = Double.parseDouble(strPrecoFormatado);

        Assert.assertEquals(preco, notaAluguel.getPrecoAluguelFinal());
    }

    @Então("a data de entrega será em {int} dia(s)")
    public void aDataDeEntregaSeráEmDias(Integer diasAlugados) {
        Date dataEntregaEsperada = calcularDataEntrega(diasAlugados);
        Assert.assertEquals(sdfFormater(dataEntregaEsperada), sdfFormater(notaAluguel.getDataEntrega()));
    }

    @Então("o estoque do filme será {int} unidade")
    public void oEstoqueDoFilmeSeráUnidade(Integer int1) {
        Assert.assertEquals(int1, filme.getEstoque());
    }

    @Então("não será possível por falta de estoque")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assert.assertTrue(errors.contains("O filme não tem estoque"));
    }

    @Dado("que o tipo de aluguel seja (extendido|comum|semanal)$")
    public void queOTipoDeAluguelSeja(String tipo) {
        TipoAluguel tipoAluguel = TipoAluguel.valueOf(tipo.toUpperCase());
        notaAluguel.setTipoAluguel(tipoAluguel);
    }

    @Então("a pontuação recebida será de {int} ponto(s)")
    public void aPontuaçãoRecebidaSeráDePontos(Integer pontuacao) {
        Assert.assertEquals(pontuacao, notaAluguel.getPontuacao());
    }


}
