package interfaces;

import entities.Pedido;
import java.util.List;

public interface IRepositorioDePedidos {
    /**
     * Adiciona um pedido ao repositório.
     *
     * @param pedido O pedido a ser adicionado; não pode ser nulo.
     */
    void adicionarPedido(Pedido pedido);

    /**
     * Retorna a lista de pedidos.
     *
     * @return Lista de pedidos.
     */
    List<Pedido> listarPedidos();

    /**
     * Atualiza um pedido existente no repositório.
     *
     * @param indice O índice do pedido a ser atualizado; deve ser válido.
     * @param pedidoAtualizado O novo pedido que substituirá o existente; não pode ser nulo.
     */
    void atualizarPedido(int indice, Pedido pedidoAtualizado);

    /**
     * Remove um pedido do repositório.
     *
     * @param indice O índice do pedido a ser removido; deve ser válido.
     */
    void removerPedido(int indice);

    /**
     * Busca um pedido pelo índice.
     *
     * @param indice O índice do pedido a ser buscado; deve ser válido.
     * @return O pedido correspondente ao índice, ou null se não encontrado.
     */
    Pedido buscarPedidoPorIndice(int indice);
}
