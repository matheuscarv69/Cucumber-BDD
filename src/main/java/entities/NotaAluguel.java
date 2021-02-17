package entities;

import entities.enums.TipoAluguel;

import java.util.Date;

public class NotaAluguel {

    private Filme filme;
    private Integer diasAlugados;
    private Date dataEntrega;
    private Double precoAluguelFinal;
    private TipoAluguel tipoAluguel = TipoAluguel.COMUM;
    private Integer pontuacao;

    public NotaAluguel() {

    }

    public NotaAluguel(Filme filme, Integer diasAlugados, Date dataEntrega, Double precoAluguelFinal, TipoAluguel tipoAluguel, Integer pontuacao) {
        this.filme = filme;
        this.diasAlugados = diasAlugados;
        this.dataEntrega = dataEntrega;
        this.precoAluguelFinal = precoAluguelFinal;
        this.tipoAluguel = tipoAluguel;
        this.pontuacao = pontuacao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Integer getDiasAlugados() {
        return diasAlugados;
    }

    public void setDiasAlugados(Integer diasAlugados) {
        this.diasAlugados = diasAlugados;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Double getPrecoAluguelFinal() {
        return precoAluguelFinal;
    }

    public void setPrecoAluguelFinal(Double precoAluguelFinal) {
        this.precoAluguelFinal = precoAluguelFinal;
    }

    public TipoAluguel getTipoAluguel() {
        return tipoAluguel;
    }

    public void setTipoAluguel(TipoAluguel tipoAluguel) {
        this.tipoAluguel = tipoAluguel;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

}
