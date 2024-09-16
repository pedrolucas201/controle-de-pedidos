package entities;

import java.util.List;

public class PedidoNacional extends Pedido {

    public PedidoNacional(Cliente cliente, List<Produto> produtos) {
        super(cliente, produtos);
    }

    // Métodos específicos para pedidos nacionais podem ser adicionados aqui
}
