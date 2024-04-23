package cadastropoo;

import cadastropoo.model.PessoaFisica;
import cadastropoo.model.PessoaFisicaRepo;
import cadastropoo.model.PessoaJuridica;
import cadastropoo.model.PessoaJuridicaRepo;
import java.io.IOException;
import java.util.Scanner;

public class CadastroPOO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        int opcao;
        do {
            System.out.println("1. Incluir Pessoa");
            System.out.println("2. Alterar Pessoa");
            System.out.println("3. Excluir Pessoa");
            System.out.println("4. Buscar pelo ID");
            System.out.println("5. Exibir todos");
            System.out.println("6. Persistir dados");
            System.out.println("7. Recuperar dados");
            System.out.println("0. Finalizar Programa");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    incluir(scanner, repoFisica, repoJuridica);
                    break;
                case 2:
                    alterar(scanner, repoFisica, repoJuridica);
                    break;
                case 3:
                    excluir(scanner, repoFisica, repoJuridica);
                    break;
                case 4:
                    exibirPorId(scanner, repoFisica, repoJuridica);
                    break;
                case 5:
                    exibirTodos(scanner, repoFisica, repoJuridica);
                    break;
                case 6:
                    salvarDados(scanner, repoFisica, repoJuridica);
                    break;
                case 7:
                    recuperarDados(scanner, repoFisica, repoJuridica);
                    break;
                case 0:
                    System.out.println("Finalizando execução...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void incluir(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
    System.out.println("Selecione o tipo (F - Física | J - Jurídica):");
    String tipo = scanner.next();

    if (tipo.equalsIgnoreCase("F")) {
        System.out.println("Digite o ID da Pessoa:");
        int id = scanner.nextInt();
        System.out.println("Digite o nome:");
        String nome = scanner.next();
        System.out.println("Digite o CPF:");
        String cpf = scanner.next();
        System.out.println("Digite a idade:");
        int idade = scanner.nextInt();

        PessoaFisica pessoa = new PessoaFisica(id, nome, cpf, idade);
        repoFisica.inserir(pessoa);
    } else if (tipo.equalsIgnoreCase("Jurídica")) {
        System.out.println("Digite o ID da Pessoa:");
        int id = scanner.nextInt();
        System.out.println("Digite o nome:");
        String nome = scanner.next();
        System.out.println("Digite o CNPJ:");
        String cnpj = scanner.next();

        PessoaJuridica empresa = new PessoaJuridica(id, nome, cnpj);
        repoJuridica.inserir(empresa);
    } else {
        System.out.println("Tipo inválido.");
    }
}

    private static void alterar(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
    System.out.println("Selecione o tipo (F - Física | J - Jurídica):");
    String tipo = scanner.next();

    if (tipo.equalsIgnoreCase("F")) {
        System.out.println("Digite o ID da pessoa física que deseja alterar:");
        int id = scanner.nextInt();
        PessoaFisica pessoa = repoFisica.obter(id);
        if (pessoa != null) {
            System.out.println("Dados atuais:");
            pessoa.exibir();
            System.out.println("Digite o novo nome:");
            String novoNome = scanner.next();
            System.out.println("Digite o novo CPF:");
            String novoCpf = scanner.next();
            System.out.println("Digite a nova idade:");
            int novaIdade = scanner.nextInt();
            pessoa.setNome(novoNome);
            pessoa.setCpf(novoCpf);
            pessoa.setIdade(novaIdade);
            System.out.println("Dados alterados com sucesso.");
        } else {
            System.out.println("Pessoa física não encontrada.");
        }
    } else if (tipo.equalsIgnoreCase("J")) {
        System.out.println("Digite o ID da pessoa jurídica que deseja alterar:");
        int id = scanner.nextInt();
        PessoaJuridica empresa = repoJuridica.obter(id);
        if (empresa != null) {
            System.out.println("Dados atuais:");
            empresa.exibir();
            System.out.println("Digite o novo nome:");
            String novoNome = scanner.next();
            System.out.println("Digite o novo CNPJ:");
            String novoCnpj = scanner.next();
            empresa.setNome(novoNome);
            empresa.setCnpj(novoCnpj);
            System.out.println("Dados alterados com sucesso.");
        } else {
            System.out.println("Pessoa jurídica não encontrada.");
        }
    } else {
        System.out.println("Tipo inválido.");
    }
}
    
    private static void excluir(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        
    }

    private static void exibirPorId(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        
    }

    private static void exibirTodos(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
        
    }

     private static void salvarDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
    System.out.println("Digite o prefixo dos arquivos:");
    String prefixo = scanner.next();

    try {
        repoFisica.persistir(prefixo + ".fisica.bin");
        repoJuridica.persistir(prefixo + ".juridica.bin");
        System.out.println("Dados salvos com sucesso.");
    } catch (IOException e) {
        System.out.println("Erro ao salvar os dados: " + e.getMessage());
    }
}

private static void recuperarDados(Scanner scanner, PessoaFisicaRepo repoFisica, PessoaJuridicaRepo repoJuridica) {
    System.out.println("Digite o prefixo dos arquivos:");
    String prefixo = scanner.next();

    try {
        repoFisica.recuperar(prefixo + ".fisica.bin");
        repoJuridica.recuperar(prefixo + ".juridica.bin");
        System.out.println("Dados recuperados com sucesso.");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
    }
}
}
