package application;

import entities.Funcionario;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Funcionario> funcionario = new ArrayList<>();
        int n;
        System.out.println("Digite o número de funcionários que serão registrados: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf("Funcionário %d: \n", i + 1);
            sc.nextLine();
            System.out.println("ID: ");
            String id = sc.nextLine();
            while (possuiId(funcionario, id)) {
                System.out.println("Id already taken! Try again: ");
                id = String.valueOf(sc.nextInt());
            }
            System.out.println("Nome: ");
            String nome = sc.nextLine();
            System.out.println("Salário: ");
            double salario = sc.nextDouble();
            funcionario.add(new Funcionario(id, nome, salario));
        }
        sc.nextLine();
        System.out.println("Deseja cadastrar um aumento de salario? (s/n)");
        char option = sc.next().charAt(0);
        if(option=='s'){
            sc.nextLine();
            Funcionario func;
            do {
                System.out.println("Digite o ID do funcionário que terá aumento: ");
                String id = sc.nextLine();
                func = funcionario.stream().filter(x -> Objects.equals(x.getId(), id)).findFirst().orElse(null);
                if (func == null) {
                    System.out.println("Esse ID não existe!");
                } else {
                    System.out.println("Digite a porcentagem que vai ser aumentado o salário: ");
                    double porcent = sc.nextDouble();
                    func.aumento(porcent);
                }
            } while (func == null);
        }

        System.out.println();
        System.out.println("Lista de funcionários:");
        for (Funcionario i : funcionario) {
            System.out.println(i);
        }

        sc.close();
    }

    private static boolean possuiId(List<Funcionario> funcionario, String id) {
        Funcionario funcionarioCad = funcionario.stream().filter(x -> Objects.equals(x.getId(), id)).findFirst().orElse(null);
        return funcionarioCad != null;
    }
}
