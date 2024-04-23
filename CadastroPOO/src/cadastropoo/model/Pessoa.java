package cadastropoo.model;
import java.io.Serializable;

public class Pessoa implements Serializable {
    private int id;
    private String nome;
    
    //construtores
    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
     
    
    //Gatters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    //setters
    public void setId(int id) {
        this.id = id;
    }
    
    
    public void setNome(String nome) {
        this.nome = nome;
    }  
    
    
    //Metodo Exibir
    public void exibir(){
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
    };
}


