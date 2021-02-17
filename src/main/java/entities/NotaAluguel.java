package entities;

import java.util.Date;

public class NotaAluguel {

    private Filme filme;
    private Integer diasAlugados;
    private Date dataEntrega;
    private Double precoAluguelFinal;
    private String tipoAluguel = "Normal";
    private Integer pontuacao;

    public NotaAluguel() {

    }

    public NotaAluguel(Filme filme, Integer diasAlugados, Date dataEntrega, Double precoAluguelFinal, String tipoAluguel, Integer pontuacao) {
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

    public String getTipoAluguel() {
        return tipoAluguel;
    }

    public void setTipoAluguel(String tipoAluguel) {
        this.tipoAluguel = tipoAluguel;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
