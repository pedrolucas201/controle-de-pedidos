package gui;

import entities.*;
import services.IRepositorioDePedidosImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoMonitorGUI extends JFrame {
    private IRepositorioDePedidosImpl repositorio;
    private JTextField nomeClienteField;
    private JTextField enderecoClienteField;
    private JTextField nomeProdutoField;
    private JTextField precoProdutoField;
    private JComboBox<String> tipoPedidoComboBox;
    private JTable pedidosTable;
    private DefaultTableModel tableModel;
    private int pedidoSelecionado = -1;  // Para atualizar ou deletar o pedido selecionado

    public PedidoMonitorGUI() {
        repositorio = new IRepositorioDePedidosImpl();

        setTitle("Sistema de Controle de Pedidos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de Entrada de Dados
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

        inputPanel.add(new JLabel("Nome do Cliente:"));
        nomeClienteField = new JTextField();
        inputPanel.add(nomeClienteField);

        inputPanel.add(new JLabel("Endereço do Cliente:"));
        enderecoClienteField = new JTextField();
        inputPanel.add(enderecoClienteField);

        inputPanel.add(new JLabel("Nome do Produto:"));
        nomeProdutoField = new JTextField();
        inputPanel.add(nomeProdutoField);

        inputPanel.add(new JLabel("Preço do Produto:"));
        precoProdutoField = new JTextField();
        inputPanel.add(precoProdutoField);

        inputPanel.add(new JLabel("Tipo de Pedido:"));
        tipoPedidoComboBox = new JComboBox<>(new String[]{"Nacional", "Internacional"});
        inputPanel.add(tipoPedidoComboBox);

        JButton adicionarButton = new JButton("Adicionar Pedido");
        adicionarButton.addActionListener(e -> {
            if (pedidoSelecionado == -1) {
                adicionarPedido();
            } else {
                atualizarPedido(pedidoSelecionado);
            }
        });

        JButton deletarButton = new JButton("Deletar Pedido");
        deletarButton.addActionListener(e -> deletarPedido());

        JButton desempilharButton = new JButton("Desempilhar Pedido");
        desempilharButton.addActionListener(e -> desempilharPedido());

        // Tabela de pedidos
        String[] colunas = {"Cliente", "Produto", "Preço", "Tipo"};
        tableModel = new DefaultTableModel(colunas, 0);
        pedidosTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(pedidosTable);

        // Seleção de um pedido na tabela
        pedidosTable.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && pedidosTable.getSelectedRow() != -1) {
                pedidoSelecionado = pedidosTable.getSelectedRow();
                carregarPedidoParaEdicao(pedidoSelecionado);
            }
        });

        // Layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(adicionarButton);
        buttonPanel.add(deletarButton);
        buttonPanel.add(desempilharButton); // Adiciona o botão de desempilhar

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
        listarPedidos();  // Carrega a lista de pedidos ao iniciar
    }

    private void adicionarPedido() {
        String nomeCliente = nomeClienteField.getText();
        String enderecoCliente = enderecoClienteField.getText();
        String nomeProduto = nomeProdutoField.getText();
        double precoProduto;

        try {
            precoProduto = Double.parseDouble(precoProdutoField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preço inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String tipoPedido = (String) tipoPedidoComboBox.getSelectedItem();

        Cliente cliente = new Cliente(nomeCliente, enderecoCliente);
        Produto produto = new Produto(nomeProduto, precoProduto);
        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto);

        Pedido pedido;
        if (tipoPedido.equals("Nacional")) {
            pedido = new PedidoNacional(cliente, produtos);
        } else {
            pedido = new PedidoInternacional(cliente, produtos, 50.0);  // Taxa de importação fixa para simplificar
        }

        repositorio.adicionarPedido(pedido);
        listarPedidos();
        limparCampos();
    }

    private void listarPedidos() {
        List<Pedido> pedidos = repositorio.listarPedidos();
        tableModel.setRowCount(0);  // Limpa a tabela

        for (Pedido pedido : pedidos) {
            String tipo = (pedido instanceof PedidoNacional) ? "Nacional" : "Internacional";
            Object[] rowData = {
                    pedido.getCliente().getNome(),
                    pedido.getProdutos().get(0).getNome(),
                    pedido.getProdutos().get(0).getPreco(),
                    tipo
            };
            tableModel.addRow(rowData);
        }
    }

    private void carregarPedidoParaEdicao(int indice) {
        Pedido pedido = repositorio.buscarPedidoPorIndice(indice);
        nomeClienteField.setText(pedido.getCliente().getNome());
        enderecoClienteField.setText(pedido.getCliente().getEndereco());
        Produto produto = pedido.getProdutos().get(0);
        nomeProdutoField.setText(produto.getNome());
        precoProdutoField.setText(String.valueOf(produto.getPreco()));
        tipoPedidoComboBox.setSelectedItem(pedido instanceof PedidoNacional ? "Nacional" : "Internacional");
    }

    private void atualizarPedido(int indice) {
        String nomeCliente = nomeClienteField.getText();
        String enderecoCliente = enderecoClienteField.getText();
        String nomeProduto = nomeProdutoField.getText();
        double precoProduto;

        try {
            precoProduto = Double.parseDouble(precoProdutoField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preço inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String tipoPedido = (String) tipoPedidoComboBox.getSelectedItem();

        Cliente cliente = new Cliente(nomeCliente, enderecoCliente);
        Produto produto = new Produto(nomeProduto, precoProduto);
        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto);

        Pedido pedido;
        if (tipoPedido.equals("Nacional")) {
            pedido = new PedidoNacional(cliente, produtos);
        } else {
            pedido = new PedidoInternacional(cliente, produtos, 50.0);
        }

        repositorio.atualizarPedido(indice, pedido);
        listarPedidos();
        limparCampos();
        pedidoSelecionado = -1;  // Resetar seleção
    }

    private void deletarPedido() {
        if (pedidoSelecionado != -1) {
            repositorio.removerPedido(pedidoSelecionado);
            listarPedidos();
            limparCampos();
            pedidoSelecionado = -1;  // Resetar seleção
        }
    }

    private void desempilharPedido() {
        if (!repositorio.isPilhaVazia()) {
            Pedido pedidoDesempilhado = repositorio.desempilharPedido();
            JOptionPane.showMessageDialog(this, "Pedido desempilhado: " + pedidoDesempilhado.getCliente().getNome());
            listarPedidos();
        } else {
            JOptionPane.showMessageDialog(this, "Não há pedidos na pilha!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        nomeClienteField.setText("");
        enderecoClienteField.setText("");
        nomeProdutoField.setText("");
        precoProdutoField.setText("");
        tipoPedidoComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PedidoMonitorGUI::new);
    }
}
