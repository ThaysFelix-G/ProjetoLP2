package br.ufrn.imd.dao;

import br.ufrn.imd.controle.Usuario;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class DB {

    BufferedWriter  pw;
    BufferedReader in;
    File arquivo;
    public DB(String caminho) throws IOException {
        String s = "src\\br\\ufrn\\imd\\dao\\";
        s += caminho;
        arquivo = new File(caminho);
        in = new BufferedReader(new FileReader(arquivo));
        pw = new BufferedWriter(new FileWriter(arquivo,true));

    }
    private void escreverLinha(String texto) throws IOException {
        try {
            pw.write(texto);
            pw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public Boolean criar(Object object) throws IOException {
        if(object instanceof Usuario){
            long count = Files.lines(Path.of(arquivo.getAbsolutePath())).count();

            String insert = (count / 4) + 1 + "\n" +((Usuario) object).toString();
            this.escreverLinha(insert);
        }
        /*else
        {
        }*/
        return true;
    }


    public Boolean remover(int id) {
        return null;
    }


    public Boolean atualizar(Object object) {
        return null;
    }


    public Object ler(int id) throws IOException {
        String linha;

        while ((linha = in .readLine()) != null) {
            System.out.println("Linha: " + linha);
            if(linha.contains(String.valueOf(id))){
                //for (int i = 0; i < 3 ; i++) {
                    //System.out.println((linha.lines().));
                //}
                System.out.println("ACHOU!!!");
                //return false;
            }


        }

        return null;

    }

}
