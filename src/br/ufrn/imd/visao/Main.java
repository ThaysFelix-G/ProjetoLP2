package br.ufrn.imd.visao;

import br.ufrn.imd.controle.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void menu() {
        System.out.println("Escolha uma das opcoes");
        System.out.println("1: cadastrar usuario");
        System.out.println("2: remover usuario");
        System.out.println("3: atualizar usuario");
        System.out.println("4: pesquisar usuario");
        System.out.println("5: finalizar");
        System.out.println("");
    }

    public static void main(String[] args) throws IOException {
        Scanner leia = new Scanner(System.in);
        while (true) {
            menu();
            int opcao = leia.nextInt();

            switch (opcao) {
                case 1: {
                    Usuario user = new Usuario("src\\br\\ufrn\\imd\\dao\\usuario.txt");
                    System.out.print("Digite o nome do usuario: ");
                    user.setNome(String.valueOf(leia.next().replaceAll("[ ]+", " ").split(" ")));
                    System.out.print("Digite o email do usuario: ");
                    user.setEmail(leia.next().replaceAll(" ", "\n"));
                    System.out.print("Digite a senha do usuario: ");
                    user.setSenha(leia.next());
                    user.criar(user);
                    System.out.println("Usuario criado com sucesso");
                    continue;
                }
                case 2: {
                    System.out.print("Informe o id do usuario que deseja remover: ");
                    Usuario user = new Usuario("src\\br\\ufrn\\imd\\dao\\usuario.txt");
                    int id = leia.nextInt();
                    Object u = new Usuario();
                    u = user.ler(id);
                    user.remover(id);
                    System.out.println("usuario removido!!!!");
                    System.out.println(u.toString());
                    continue;

                }
                case 3: {
                    Usuario user = new Usuario("src\\br\\ufrn\\imd\\dao\\usuario.txt");
                    System.out.print("Digite o id do usuario: ");
                    int id = leia.nextInt();
                    user.setId(id);
                    System.out.print("Digite o novo nome do usuario: ");
                    user.setNome(leia.next());
                    System.out.print("Digite o novo email do usuario: ");
                    user.setEmail(leia.next());
                    System.out.print("Digite a nova senha do usuario: ");
                    user.setSenha(leia.next());
                    user.atualizar(user);
                    System.out.println("Usuario atualizado com sucesso!!!!");
                    continue;
                }
                case 4: {
                    Usuario user = new Usuario("src\\br\\ufrn\\imd\\dao\\usuario.txt");
                    System.out.print("Digite o id do usuario para pesquisa: ");
                    int id = leia.nextInt();
                    user = (Usuario) user.ler(id);
                    System.out.println(user.toString());
                    continue;
                }
                case 5: {
                    System.out.println("Saindo...");
                    System.exit(0);
                }
                default: {
                    System.out.println("Opcao invalida!!!!!");
                    continue;
                }
            }

        }

    }
}