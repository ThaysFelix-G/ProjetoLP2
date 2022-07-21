package br.ufrn.imd.dao;

import br.ufrn.imd.controle.Usuario;
import br.ufrn.imd.interfaces.Crud;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class DB implements Crud {

    String p;
    public DB(){}
    public DB(String caminho) throws IOException {
        p = caminho;
    }
    private void escreverLinha(String texto, boolean override) throws IOException {
        try {
            File arquivo = new File(p);
            BufferedWriter  pw = new BufferedWriter(new FileWriter(arquivo,override));
            pw.write(texto);
            pw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Boolean criar(Object object) throws IOException {
        if(object instanceof Usuario){
            File arquivo = new File(p);
            long count = Files.lines(Path.of(arquivo.getAbsolutePath())).count();

            String insert = (count / 4) + 1 + "\n" +((Usuario) object).toString();
            this.escreverLinha(insert, true);
        }
        return true;
    }

    @Override
    public Boolean remover(int id) throws IOException {
        String saida ="";
        File arquivo = new File(p);
        BufferedReader in = new BufferedReader(new FileReader(arquivo));

        String linha;

        while ((linha = in.readLine()) != null) {
            if (linha.equals(Integer.toString(id))) {
                int count = 0;
                while ((linha = in.readLine()) != null) {
                    if (count ==  2) {
                        break;
                    }
                    count++;
                }
            } else{
                saida += linha + "\n";
            }
        }

        this.escreverLinha(saida, false);
        in.close();
        return null;
    }

    @Override
    public Boolean atualizar(Object object) throws IOException {
        String saida ="";
        File arquivo = new File(p);
        BufferedReader in = new BufferedReader(new FileReader(arquivo));

        String linha;
        Usuario u = new Usuario();

        if(object instanceof Usuario){
            u = (Usuario) object;
        }
        while ((linha = in.readLine()) != null) {
            if (linha.equals(Integer.toString(u.getId()))) {
                saida += linha + "\n";
                int count = 0;
                while ((linha = in.readLine()) != null) {
                    if(count == 0){
                        saida += u.getNome() + "\n";
                    } else if(count == 1){
                        saida += u.getEmail() + "\n";
                    } else if (count ==  2){
                        saida += u.getSenha() + "\n";
                        break;
                    }
                    count++;
                }
            } else{
                saida += linha + "\n";
            }
        }

        this.escreverLinha(saida, false);
        in.close();
        return null;
    }

    public Object ler(int id) throws IOException {
        File arquivo = new File(p);
        BufferedReader in = new BufferedReader(new FileReader(arquivo));

        String linha;
        while ((linha = in.readLine()) != null) {
            if (linha.equals(Integer.toString(id))) {
                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(linha.trim()));
                int count = 0;
                while ((linha = in.readLine()) != null) {
                    if(count == 0){
                        usuario.setNome(linha);
                    } else if(count == 1){
                        usuario.setEmail(linha);
                    } else if (count ==  2){
                        usuario.setSenha(linha);
                        return usuario;
                    }
                    count++;
                }
            }

        }
        in.close();
        return null;
    }

}
