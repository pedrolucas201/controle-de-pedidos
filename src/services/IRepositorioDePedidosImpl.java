package services;

import entities.Pedido;
import interfaces.IRepositorioDePedidos;

import java.util.ArrayList;
import java.util.List;

public class IRepositorioDePedidosImpl implements IRepositorioDePedidos {
    private List<Pedido> pedidos;
    private Pilha<Pedido> pilhaPedidos;

    public IRepositorioDePedidosImpl() {
        pedidos = new ArrayList<>();
        pilhaPedidos = new Pilha<>();
    }

    @Override
    public void adicionarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo.");
        }
        pedidos.add(pedido);
        pilhaPedidos.empilhar(pedido); // Empilha o pedido
    }

    @Override
    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos); // Retorna uma cópia para evitar manipulações diretas
    }

    @Override
    public void atualizarPedido(int indice, Pedido pedidoAtualizado) {
        if (indice < 0 || indice >= pedidos.size()) {
            throw new IndexOutOfBoundsException("Índice de pedido inválido.");
        }
        if (pedidoAtualizado == null) {
            throw new IllegalArgumentException("Pedido atualizado não pode ser nulo.");
        }
        pedidos.set(indice, pedidoAtualizado);
    }

    @Override
    public void removerPedido(int indice) {
        if (indice < 0 || indice >= pedidos.size()) {
            throw new IndexOutOfBoundsException("Índice de pedido inválido.");
        }
        Pedido pedidoRemovido = pedidos.remove(indice);
        // Desempilha o pedido removido se existir
        if (pedidoRemovido != null) {
            pilhaPedidos.desempilhar(); // Desempilha o pedido
        }
    }

    @Override
    public Pedido buscarPedidoPorIndice(int indice) {
        if (indice < 0 || indice >= pedidos.size()) {
            throw new IndexOutOfBoundsException("Índice de pedido inválido.");
        }
        return pedidos.get(indice);
    }

    // Métodos para pilha
    public Pedido desempilharPedido() {
        return pilhaPedidos.desempilhar();
    }

    public Pedido visualizarUltimaPedido() {
        return pilhaPedidos.visualizarUltimo();
    }

    public boolean isPilhaVazia() {
        return pilhaPedidos.isEmpty();
    }
}
