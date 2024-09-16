package entities;

import java.util.List;

public class PedidoInternacional extends Pedido {
    private double taxaImportacao;

    public PedidoInternacional(Cliente cliente, List<Produto> produtos, double taxaImportacao) {
        super(cliente, produtos);
        this.taxaImportacao = taxaImportacao;
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() + taxaImportacao;
    }

    public double getTaxaImportacao() {
        return taxaImportacao;
    }

    public void setTaxaImportacao(double taxaImportacao) {
        this.taxaImportacao = taxaImportacao;
    }
}
