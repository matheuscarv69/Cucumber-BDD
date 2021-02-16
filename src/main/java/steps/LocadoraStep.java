package steps;

import io.cucumber.java.pt.*;

public class LocadoraStep {

    @Dado("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }
    @Dado("que o preço de aluguel seja R$ {int}")
    public void queOPreçoDeAluguelSejaR$(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }
    @Quando("alugar")
    public void alugar() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Então("o preço do aluguel será R$ {int}")
    public void oPreçoDoAluguelSeráR$(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }

    /** Tentar unificar os dois métodos  **/
    @Então("a data de entrega será no dia seguinte")
    public void aDataDeEntregaSeráNoDiaSeguinte() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Então("a data de entrega será em {int} dias")
    public void aDataDeEntregaSeráEmDias(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Então("o estoque do filme será {int} unidade")
    public void oEstoqueDoFilmeSeráUnidade(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Então("não será possível por falta de estoque")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Então("a pontuação recebida será de {int} pontos")
    public void aPontuaçãoRecebidaSeráDePontos(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }

}
