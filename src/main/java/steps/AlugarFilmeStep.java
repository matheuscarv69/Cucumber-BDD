package steps;

import entities.Filme;
import entities.NotaAluguel;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import services.AluguelService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static helpers.DateMethods.calcularDataEntrega;
import static helpers.DateMethods.sdfFormater;

public class AlugarFilmeStep {


    private AluguelService aluguelService;

    private Filme filme;
    private NotaAluguel notaAluguel;

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

    @Quando("alugar por {int} dia(s)")
    public void alugar(Integer dias) {
        try{
            notaAluguel = aluguelService.alugar(filme, dias);
        }catch (RuntimeException e){
            errors.add(e.getMessage());
        }
    }

    @Então("^o preço do aluguel será R\\$ (.*)$")
    public void oPreçoDoAluguelSeráR$(String strPreco) {
        String strPrecoFormatado = strPreco.replaceAll(",", ".");
        Double preco = Double.parseDouble(strPrecoFormatado);

        Assert.assertEquals(preco, notaAluguel.getPrecoAluguelFinal());
    }

    /**
     * Tentar unificar os dois métodos
     **/
    @Então("a data de entrega será no dia seguinte")
    public void aDataDeEntregaSeráNoDiaSeguinte() {
        Date dataEntregaEsperada = calcularDataEntrega(notaAluguel.getDiasAlugados());

        Assert.assertEquals(sdfFormater(dataEntregaEsperada), sdfFormater(notaAluguel.getDataEntrega()));
    }

    @Então("a data de entrega será em {int} dias")
    public void aDataDeEntregaSeráEmDias(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Então("o estoque do filme será {int} unidade")
    public void oEstoqueDoFilmeSeráUnidade(Integer int1) {
        Assert.assertEquals(int1, filme.getEstoque());
    }

    @Então("não será possível por falta de estoque")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assert.assertTrue(errors.contains("O filme não tem estoque"));
    }

    @Então("a pontuação recebida será de {int} pontos")
    public void aPontuaçãoRecebidaSeráDePontos(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }

}
