# ☕ Teste Prático Iniflex - Programação Java

> Sistema desenvolvido como resolução do teste prático para a Iniflex, focado na manipulação de coleções, cálculos de alta precisão e boas práticas de Engenharia de Software.

## 📋 Sobre o Projeto

Este projeto consiste em uma aplicação Java pura (Console) para gerenciamento de funcionários. O objetivo principal é demonstrar o domínio sobre os pilares da Programação Orientada a Objetos (POO), manipulação de estruturas de dados e aplicação de lógicas de negócio utilizando as APIs modernas do Java.

## 🚀 Requisitos Atendidos (Lógica de Negócio)

A aplicação executa de forma sequencial e automatizada as seguintes operações:
- [x] Inserção de dados estruturados em uma `List`.
- [x] Remoção de elementos baseada em condições (Predicados).
- [x] Formatação customizada de Datas (`dd/MM/yyyy`) e Moedas (`pt-BR`).
- [x] Cálculos financeiros de alta precisão garantidos pelo uso de `BigDecimal` (Aumento de 10%).
- [x] Agrupamento de dados complexos utilizando a API de `Streams` (Dicionário/Map de Funcionários por Função).
- [x] Filtros e buscas de aniversariantes e identificação do funcionário mais velho usando `LocalDate` e `Period`.
- [x] Ordenação alfabética segura (utilizando cópia de coleções e `Comparator`).
- [x] Totalização de folha salarial e conversão para múltiplos de salários mínimos.

## 🏗️ Arquitetura e Padrões Aplicados

Para demonstrar senioridade e preocupação com a manutenibilidade, o projeto fugiu do padrão de "script único" e foi desenhado utilizando a **Arquitetura em Camadas (MVC / Domain-Driven)**, aplicando os princípios do **SOLID** (especialmente o Princípio da Responsabilidade Única) e **Clean Code**.

A árvore de diretórios foi dividida em:

    src/
     ┣ main/
     ┃ ┗ Principal.java         # Ponto de entrada (Entry Point). Apenas orquestra as chamadas.
     ┣ models/
     ┃ ┣ Pessoa.java            # Entidade base (Demonstra Encapsulamento).
     ┃ ┗ Funcionario.java       # Entidade especializada (Demonstra Herança e Reuso).
     ┗ services/
       ┗ FuncionarioService.java # "Cérebro" do sistema. Contém todas as regras de negócio.

## 🛠️ Tecnologias Utilizadas

* **Java 8+** (Utilização intensiva de `java.util.stream`, `java.time` e Expressões Lambda).
* **Paradigma Funcional** integrado à Orientação a Objetos clássica.
* **Sem bibliotecas externas** (Apenas o core do JDK foi utilizado para atestar o domínio da linguagem).

## 🖥️ Como Executar o Projeto

### Pré-requisitos
Certifique-se de ter o **Java Development Kit (JDK)** instalado (versão 8 ou superior). Você pode verificar executando no terminal:
    
    java -version

### Opção 1: Via Terminal (Linha de Comando)
1. Clone o repositório ou baixe o arquivo `.zip`:
   
       git clone [https://github.com/carlosresendeP/teste-pratico-iniflex.git](https://github.com/carlosresendeP/teste-pratico-iniflex.git)
   
2. Abra o terminal e navegue até a pasta `src` do projeto:
   
       cd teste-pratico-iniflex/src
   
3. Compile os arquivos Java respeitando a estrutura de pacotes:
   
       javac controllers/Principal.java
   
4. Execute o programa chamando a classe Principal compilada:
   
       java controllers.Principal

### Opção 2: Via IDE (VS Code, IntelliJ, Eclipse)
1. Abra a pasta raiz do projeto na sua IDE.
2. Certifique-se de que a IDE reconheceu a pasta `src` como o diretório de fontes (Source Root).
3. Navegue até o arquivo `src/controllers/Principal.java`.
4. Clique no botão de **Run** (Executar) ou clique com o botão direito e selecione `Run 'Principal.main()'`.

---
*Desenvolvido com dedicação por Carlos Alexandre Paula.*