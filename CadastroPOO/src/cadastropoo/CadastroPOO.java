package cadastropoo;

import cadastropoo.model.PessoaFisica;
import cadastropoo.model.PessoaFisicaRepo;
import cadastropoo.model.PessoaJuridica;
import cadastropoo.model.PessoaJuridicaRepo;
import java.io.IOException;

public class CadastroPOO {
    public static void main(String[] args) {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        PessoaFisica pessoa1 = new PessoaFisica(1, "Ana", "11111111111", 30);
        PessoaFisica pessoa2 = new PessoaFisica(2, "Carlos", "22222222222", 52);
        
        repo1.inserir(pessoa1);
        repo1.inserir(pessoa2);

        try {
            repo1.persistir("pessoas_fisicas.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoas_fisicas.dat");

            for (PessoaFisica pessoa : repo2.obterTodos()) {
                pessoa.exibir();
            }

            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            PessoaJuridica empresa1 = new PessoaJuridica(3, "XPTO Sales", "333333333333333");
            PessoaJuridica empresa2 = new PessoaJuridica(4, "XPTO Solutions", "444444444444444");

            repo3.inserir(empresa1);
            repo3.inserir(empresa2);

            repo3.persistir("pessoas_juridicas.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoas_juridicas.dat");

            for (PessoaJuridica empresa : repo4.obterTodos()) {
                empresa.exibir();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}