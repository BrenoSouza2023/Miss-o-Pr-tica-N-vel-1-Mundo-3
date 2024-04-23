package cadastropoo.model;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable{
    private String cpf;
    private int idade;
    
    //Contrutores
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    //getters
    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }
    //setters

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public void exibir(){
      System.out.println("ID: " + getId());
      System.out.println("Nome: " + getNome());
      System.out.println("CPF: " + getCpf());
      System.out.println("Idade: " + getIdade());
      
    }
}
