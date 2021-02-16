package entities;

public class Filme {


    private Integer estoque;
    private Double precoAluguel;

    public Filme() {

    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Double getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(Double aluguel) {
        this.precoAluguel = aluguel;
    }
}
