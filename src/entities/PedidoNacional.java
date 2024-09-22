package entities;

import java.util.List;

public class PedidoNacional extends Pedido {

    public PedidoNacional(Cliente cliente, List<Produto> produtos) {
        super(cliente, produtos);
    }

    @Override
    public void setProdutos(List<Produto> produtos) {
        if (produtos == null || produtos.isEmpty()) {
            throw new IllegalArgumentException("A lista de produtos não pode ser nula ou vazia");
        }
        super.setProdutos(produtos);
    }

    // Métodos específicos para pedidos nacionais podem ser adicionados aqui
}
