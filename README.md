Sistema de Controle de Pedidos
1. Nome do Projeto: Sistema de Controle de Pedidos

2. Objetivo
> O objetivo deste projeto é implementar um sistema que permite o controle de pedidos de forma interativa, possibilitando o gerenciamento de clientes, produtos e tipos de pedidos (nacionais e internacionais). O sistema oferece funcionalidades de CRUD (Create, Read, Update, Delete) para gerenciar os pedidos de forma eficiente e com interface gráfica.

3. Entidades
  > O projeto foi construído com três entidades principais, refletindo a estrutura dos dados que o sistema gerencia:

> Pedido: Representa um pedido de um cliente. Inclui o cliente, produtos e, dependendo do tipo de pedido, uma taxa de importação.

> Cliente: Representa o cliente que fez o pedido. Inclui informações como nome e endereço.

> Produto: Representa os produtos que fazem parte do pedido. Inclui nome e preço.

4. Herança
   > Para estruturar diferentes tipos de pedidos, utilizamos herança nas classes:

> Pedido Nacional: Herda da classe Pedido e representa pedidos feitos dentro do país.

> Pedido Internacional: Herda da classe Pedido e adiciona uma taxa de importação, simulando um pedido que é feito de fora do país.
5. Interfaces
   > Duas interfaces foram definidas para estruturar os serviços necessários no projeto:

> RepositorioDePedidos: Define os métodos essenciais para manipular os pedidos, incluindo adicionar, listar, atualizar, buscar por índice e remover.

> ServicoDeEntrega (em progresso): Definida para realizar operações relacionadas à entrega dos pedidos. Pode incluir cálculos de prazo, rastreamento, e integração com APIs externas de frete.
6. Funcionalidades do Sistema
   > O sistema foi desenvolvido com as seguintes funcionalidades:

> Adicionar Pedido: O usuário pode inserir informações do cliente, produto e tipo de pedido (nacional ou internacional). Um pedido internacional aplica automaticamente uma taxa de importação fixa.

> Listar Pedidos: A interface gráfica exibe uma tabela com todos os pedidos cadastrados, mostrando o nome do cliente, produto, preço e tipo de pedido.

> Atualizar Pedido: O sistema permite que o usuário selecione um pedido existente na tabela, edite as informações e atualize o registro na lista.

> Deletar Pedido: O usuário pode selecionar um pedido e removê-lo da lista.

> Buscar Pedido por Índice: O sistema recupera um pedido específico com base no índice, o que facilita a edição e visualização.

7. Interface Gráfica (GUI)
   > A interface gráfica foi desenvolvida utilizando Swing, proporcionando uma experiência interativa para o usuário:

> Entrada de dados: A GUI contém campos de texto para o nome e endereço do cliente, nome e preço do produto, além de uma lista suspensa (combobox) para o tipo de pedido.

> Tabela de Pedidos: Utilizamos um JTable para listar todos os pedidos cadastrados, permitindo que o usuário visualize e selecione pedidos para edição ou remoção.

> Botões de Ação: Botões foram implementados para adicionar, atualizar e deletar pedidos. Quando o usuário seleciona um pedido, os campos são preenchidos automaticamente, facilitando a edição.

> A interface gráfica é simples e funcional, focada na usabilidade e interatividade.

8. Estrutura de Código

> Pacote entities: Contém as classes Pedido, PedidoNacional, PedidoInternacional, Cliente e Produto.
    
> Pacote services: Contém a implementação da interface RepositorioDePedidosImpl, que gerencia a lista de pedidos.
   
> Pacote gui: Contém a classe PedidoMonitorGUI, que implementa a interface gráfica e lida com todas as interações do usuário com o sistema.
9. Desafios
> Manipulação de múltiplos produtos: A princípio, o sistema foi configurado para um produto por pedido, mas há a possibilidade de expandir essa funcionalidade para múltiplos produtos em um único pedido.

> Validação de dados: A validação básica dos campos (como campos vazios ou valores inválidos) foi implementada, mas pode ser aprimorada.
10. Possíveis Expansões
> Serviço de Entrega Completo: Implementar um sistema de entrega que calcule o prazo de entrega, custos variáveis e integração com APIs externas de transporte.

> Pedidos com Múltiplos Produtos: Expandir a estrutura de Pedido para suportar uma lista de produtos, permitindo que o cliente adicione mais de um produto por pedido.
    
> Relatórios Detalhados: Implementar uma funcionalidade de geração de relatórios para análise dos pedidos, como exportação para PDF ou Excel.
11. Conclusão
    > O projeto Sistema de Controle de Pedidos oferece uma solução robusta para gerenciar pedidos, com funcionalidades de CRUD implementadas de forma clara e eficiente. A interface gráfica fornece uma boa experiência de usuário, permitindo o controle total dos pedidos realizados por clientes. O projeto pode ser facilmente expandido para incluir funcionalidades mais complexas, como entrega avançada e suporte para múltiplos produtos por pedido.