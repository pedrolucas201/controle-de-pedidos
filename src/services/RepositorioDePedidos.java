package services;

import entities.Pedido;
import java.util.List;

public interface RepositorioDePedidos {
    void adicionarPedido(Pedido pedido);
    List<Pedido> listarPedidos();
    void atualizarPedido(int indice, Pedido pedidoAtualizado);
    void removerPedido(int indice);
    Pedido buscarPedidoPorIndice(int indice);
}
