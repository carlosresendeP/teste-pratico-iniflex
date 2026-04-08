package services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import models.Funcionario;

public class FuncionarioService {

    // Instanciamos os formatadores apenas uma vez para reaproveitar em todo o serviço (Performance)
    private final DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final NumberFormat formatadorNumero = NumberFormat.getNumberInstance(Locale.of("pt", "BR"));

    public FuncionarioService() {
        formatadorNumero.setMinimumFractionDigits(2);
    }

    // 3.2 - Remover funcionário por nome
    public void removerPorNome(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }

    // 3.3 - Imprimir todos os funcionários formatados
    public void imprimirFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("--- LISTA DE FUNCIONÁRIOS ---");
        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome() +
                    " | Nasc: " + f.getDataNascimento().format(formatadorData) +
                    " | Salário: " + formatadorNumero.format(f.getSalario()) +
                    " | Função: " + f.getFuncao());
        }
    }

    // 3.4 - Aplicar aumento de salário
    public void aplicarAumento(List<Funcionario> funcionarios, String percentualAumento) {
        BigDecimal fator = new BigDecimal(percentualAumento);
        for (Funcionario f : funcionarios) {
            BigDecimal aumento = f.getSalario().multiply(fator);
            f.setSalario(f.getSalario().add(aumento));
        }
    }

    // 3.5 - Agrupar os funcionários por função
    public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    // 3.6 - Imprimir os funcionários agrupados
    public void imprimirAgrupados(Map<String, List<Funcionario>> funcionariosAgrupados) {
        System.out.println("\n--- FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO ---");
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosAgrupados.entrySet()) {
            System.out.println("Função: " + entry.getKey());
            for (Funcionario f : entry.getValue()) {
                System.out.println("  - " + f.getNome());
            }
        }
    }

    // 3.8 - Imprimir funcionários que fazem aniversário nos meses especificados
    public void imprimirAniversariantes(List<Funcionario> funcionarios, List<Integer> mesesPermitidos) {
        System.out.println("\n--- ANIVERSARIANTES DOS MESES " + mesesPermitidos + " ---");
        for (Funcionario f : funcionarios) {
            int mesNascimento = f.getDataNascimento().getMonthValue();
            if (mesesPermitidos.contains(mesNascimento)) {
                System.out.println(f.getNome() + " (Mês " + mesNascimento + ")");
            }
        }
    }

    // 3.9 - Imprimir o funcionário mais velho
    public void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        System.out.println("\n--- FUNCIONÁRIO MAIS VELHO ---");
        Funcionario maisVelho = Collections.min(funcionarios, Comparator.comparing(Funcionario::getDataNascimento));
        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println("Nome: " + maisVelho.getNome() + " | Idade: " + idade + " anos");
    }

    // 3.10 - Imprimir a lista por ordem alfabética
    public void imprimirOrdemAlfabetica(List<Funcionario> funcionarios) {
        System.out.println("\n--- FUNCIONÁRIOS EM ORDEM ALFABÉTICA ---");
        // Criamos uma cópia para não alterar a ordem da lista original do sistema
        List<Funcionario> funcionariosOrdenados = new ArrayList<>(funcionarios);
        funcionariosOrdenados.sort(Comparator.comparing(Funcionario::getNome));
        
        for (Funcionario f : funcionariosOrdenados) {
            System.out.println(f.getNome());
        }
    }

    // 3.11 - Imprimir total dos salários
    public void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        System.out.println("\n--- SOMA TOTAL DOS SALÁRIOS ---");
        BigDecimal total = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            total = total.add(f.getSalario());
        }
        System.out.println("Total: " + formatadorNumero.format(total));
    }

    // 3.12 - Imprimir quantos salários mínimos ganha cada funcionário
    public void imprimirSalariosMinimos(List<Funcionario> funcionarios, BigDecimal valorSalarioMinimo) {
        System.out.println("\n--- QTD DE SALÁRIOS MÍNIMOS (R$ " + formatadorNumero.format(valorSalarioMinimo) + ") ---");
        for (Funcionario f : funcionarios) {
            BigDecimal qtdSalarios = f.getSalario().divide(valorSalarioMinimo, 2, RoundingMode.DOWN);
            System.out.println(f.getNome() + " ganha " + qtdSalarios + " salários mínimos.");
        }
    }
}