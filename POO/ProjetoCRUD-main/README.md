# Projeto Sistema CRUD de Gerenciamento de Cardápio de Lanches

Desenvolvido por Karleandro e Liriel (https://github.com/LirielG)

Este projeto em Java simula um sistema de armazenamento de cardápio para uma lanchonete, permitindo a adição, remoção, listagem e atualização de lanches. Ele é executado diretamente no terminal e possui um menu interativo que facilita a operação.

## Funcionalidades

O sistema permite realizar as seguintes operações:

1. **Adicionar Lanche**: Adiciona um novo lanche ao cardápio, com nome e preço.
2. **Remover Lanche**: Remove um lanche do cardápio com base em seu índice.
3. **Listar Lanches**: Exibe a lista de todos os lanches cadastrados no cardápio.
4. **Atualizar Lanche**: Atualiza o nome e o preço de um lanche existente.
5. **Sair**: Encerra o programa.

## Requisitos

- Java 8 ou superior

## Exemplo de Uso
Após iniciar o programa, você verá um menu semelhante ao seguinte:

### 1. Adicionar Lanche
Ao escolher a opção [1], você será solicitado a inserir o nome e o preço do novo lanche.

### 2. Remover Lanche
Ao escolher a opção [2], você verá uma lista dos lanches disponíveis e poderá selecionar o lanche que deseja remover inserindo o índice correspondente.

### 3. Listar Lanches
Ao escolher a opção [3], o sistema exibirá todos os lanches cadastrados no cardápio, com seus respectivos índices, nomes e preços.

### 4. Atualizar Lanche
Ao escolher a opção [4], você poderá atualizar o nome e o preço de um lanche existente. Se o lanche não for encontrado, o sistema perguntará se você deseja adicioná-lo.

### 5. Sair
Ao escolher a opção [5], o programa será encerrado.

## Tratamento de Erros
O sistema verifica se o valor do preço é válido ao adicionar ou atualizar um lanche.
No caso de entradas inválidas para índices ou valores, o programa exibe mensagens de erro adequadas e solicita nova entrada.
