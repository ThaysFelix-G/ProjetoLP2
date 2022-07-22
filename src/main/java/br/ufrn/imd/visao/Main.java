package br.ufrn.imd.visao;

import br.ufrn.imd.controle.Usuario;

import java.io.IOException;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Main {

   public static String p = "src\\main\\java\\br\\ufrn\\imd\\dao\\usuario.txt";
    public static void menu() throws InterruptedException {
        System.out.println("-----------------------------------MENU-------------------------");
        System.out.println("Escolha uma das opcoes");
        System.out.println("1: cadastrar usuario");
        System.out.println("2: remover usuario");
        System.out.println("3: atualizar usuario");
        System.out.println("4: pesquisar usuario");
        System.out.println("5: finalizar");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("#");
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leia = new Scanner(System.in);
        System.out.println("Iniciando ...");
        TimeUnit.SECONDS.sleep(5);
        while(true){
            menu();

            int opcao = leia.nextInt();
            boolean existe = true;

            switch (opcao){
                case 1: {
                    Scanner leitor = new Scanner(System.in);
                    Usuario user = new Usuario(p);
                    System.out.print("Digite o nome do usuario: ");
                    String nome = leitor.nextLine();
                    user.setNome(nome);
                    while (existe == true) {
                        System.out.print("Digite o email do usuario: ");
                        user.setEmail(leitor.nextLine());
                        if(user.existeEmail(user.getEmail()) == true){
                            System.out.println("Esse email ja estar em uso..." );
                        }
                        else {
                            existe = false;
                        }
                    }

                    System.out.print("Digite a senha do usuario: ");
                    user.setSenha(leitor.nextLine());
                    user.criar(user);
                    System.out.println("...");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Usuario criado com sucesso");
                    TimeUnit.SECONDS.sleep(2);
                    continue;
                }
                case 2: {
                    Scanner leitor = new Scanner(System.in);
                    System.out.print("Informe o id do usuario que deseja remover: ");
                    Usuario user = new Usuario(p);
                    int id = leitor.nextInt();
                    Object u = new Usuario();
                    u = user.ler(id);
                    user.remover(id);
                    System.out.println("...");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("usuario removido!!!!");
                    System.out.println(u.toString());
                    continue;

                }
                case 3:{
                    Scanner leitor = new Scanner(System.in);
                    Usuario user = new Usuario(p);
                    System.out.print("Digite o id do usuario: ");
                    //int id = leia.nextInt();
                    int id = Integer.parseInt(leitor.nextLine());
                    user.setId(id);
                    System.out.print("Digite o novo nome do usuario: ");
                    user.setNome(leitor.nextLine());
                    System.out.print("Digite o novo email do usuario: ");
                    user.setEmail(leitor.nextLine());
                    System.out.print("Digite a nova senha do usuario: ");
                    user.setSenha(leitor.nextLine());
                    user.atualizar(user);
                    System.out.println("Usuario atualizado com sucesso!!!!");
                    continue;
                }
                case 4:{
                    Scanner l = new Scanner(System.in);
                    Usuario user = new Usuario(p);
                    System.out.print("Digite o id do usuario para pesquisa: ");
                    int id = l.nextInt();
                    user = (Usuario) user.ler(id);
                    System.out.println(user.toString());
                    continue;
                }
                case 5: {
                    System.out.println("Saindo...");
                    System.exit(0);
                }
                default:{
                    System.out.println("Opcao invalida!!!!!");
                    continue;
                }

            }

        }



//        Usuario usuario = new Usuario("src\\br\\ufrn\\imd\\dao\\usuario.txt");
//        usuario.setNome("Thays");
//        usuario.setEmail("thays@email.com.br");
//        usuario.setSenha("senhafacil123");
////        usuario.criar(usuario);
//
//        Usuario usuario1 = new Usuario("src\\br\\ufrn\\imd\\dao\\usuario.txt");
//        usuario1.setNome("Madson");
//        usuario1.setEmail("madson@email.com.br");
//        usuario1.setSenha("qualquerumafacil0987");
////        usuario1.criar(usuario1);
//
//        Object resul = usuario.ler(3);
//        Usuario s = (Usuario) resul;
//        s.setNome("Thays ta ficando fofinha");
//
////        System.out.println(s.toString());
//        usuario.atualizar(s);
//        usuario.remover(1);
    }
}
