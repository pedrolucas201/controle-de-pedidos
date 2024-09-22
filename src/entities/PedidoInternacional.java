package entities;

import java.util.List;

public class PedidoInternacional extends Pedido {
    private double taxaImportacao;

    public PedidoInternacional(Cliente cliente, List<Produto> produtos, double taxaImportacao) {
        super(cliente, produtos);
        setTaxaImportacao(taxaImportacao);
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() + taxaImportacao;
    }

    public double getTaxaImportacao() {
        return taxaImportacao;
    }

    public void setTaxaImportacao(double taxaImportacao) {
        if (taxaImportacao < 0) {
            throw new IllegalArgumentException("A taxa de importação não pode ser negativa");
        }
        this.taxaImportacao = taxaImportacao;
    }
}
