package services;

import entities.Pedido;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDePedidosImpl implements RepositorioDePedidos {
    private List<Pedido> pedidos;

    public RepositorioDePedidosImpl() {
        pedidos = new ArrayList<>();
    }

    @Override
    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos); // Retorna uma cópia para evitar manipulações diretas
    }

    @Override
    public void atualizarPedido(int indice, Pedido pedidoAtualizado) {
        if (indice >= 0 && indice < pedidos.size()) {
            pedidos.set(indice, pedidoAtualizado);
        } else {
            System.out.println("Índice de pedido inválido.");
        }
    }

    @Override
    public void removerPedido(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            pedidos.remove(indice);
        } else {
            System.out.println("Índice de pedido inválido.");
        }
    }

    @Override
    public Pedido buscarPedidoPorIndice(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            return pedidos.get(indice);
        } else {
            System.out.println("Índice de pedido inválido.");
            return null;
        }
    }
}
