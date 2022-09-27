package entities;

import java.util.List;

public class Funcionario {
    private String id;
    private String nome;
    private double salario;

    public Funcionario(String id, String nome, double salario){
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void aumento(double porcent){
        salario+=(salario*(porcent/100.0));
    }



    @Override
    public String toString() {
            return "\nID: "
                    + id
                    + "\nNome: "
                    + nome
                    + "\nSalário: R$ "
                    + String.format("%.2f", salario);
    }
}
