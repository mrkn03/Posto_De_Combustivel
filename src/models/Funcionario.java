package models;

public class Funcionario extends Pessoa{
    private String cargo;
    private double salario;

    // Construtor
    public Funcionario(int id, String nome, String cargo, double salario) {
        super(id, nome);
        this.cargo = cargo;
        this.salario = salario;
    }

    public void cadastrarFuncionario() {
        System.out.println("Funcionario " + nome + " cadastrado com sucesso.");
    }

    public void atualizarFuncionario(String cargo, double salario) {
        this.cargo = cargo;
        this.salario = salario;
        System.out.println("Funcionario " + nome + " atualizado com sucesso.");
    }

    public void removerFuncionario() {
        System.out.println("Funcionario " + nome + " removido com sucesso.");
    }

    // Getters e Setters adicionais
    public String getCargo() {
        return cargo;
    }
    public double getSalario() {
        return salario;
    }
}
