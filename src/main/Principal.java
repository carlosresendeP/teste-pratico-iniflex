package main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import models.Funcionario;
import services.FuncionarioService;

public class Principal {

    public static void main(String[] args) {

        // 1. Inicialização dos Dados (Simulando uma busca em Banco de Dados)
        List<Funcionario> funcionarios = new ArrayList<>();
        
        // 3.1 - Inserir todos os funcionários
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));


        // 2. Instanciando o Serviço
        FuncionarioService service = new FuncionarioService();


        // 3. Orquestração: Chamando as regras de negócio de forma limpa e sequencial

        // 3.2 - Remover o funcionário "João"
        service.removerPorNome(funcionarios, "João");

        // 3.3 - Imprimir todos os funcionários
        service.imprimirFuncionarios(funcionarios);

        // 3.4 - Aplicar 10% de aumento de salário
        service.aplicarAumento(funcionarios, "0.10");

        // 3.5 e 3.6 - Agrupar por função e imprimir
        Map<String, List<Funcionario>> funcionariosAgrupados = service.agruparPorFuncao(funcionarios);
        service.imprimirAgrupados(funcionariosAgrupados);

        // 3.8 - Imprimir funcionários que fazem aniversário no mês 10 e 12
        // Usamos Arrays.asList para passar os meses desejados como uma lista de números
        service.imprimirAniversariantes(funcionarios, Arrays.asList(10, 12));

        // 3.9 - Imprimir o funcionário com a maior idade
        service.imprimirFuncionarioMaisVelho(funcionarios);

        // 3.10 - Imprimir a lista de funcionários por ordem alfabética
        service.imprimirOrdemAlfabetica(funcionarios);

        // 3.11 - Imprimir o total dos salários dos funcionários
        service.imprimirTotalSalarios(funcionarios);

        // 3.12 - Imprimir quantos salários mínimos ganha cada funcionário
        // Passamos o valor do salário mínimo atual como parâmetro
        service.imprimirSalariosMinimos(funcionarios, new BigDecimal("1212.00"));
    }
}