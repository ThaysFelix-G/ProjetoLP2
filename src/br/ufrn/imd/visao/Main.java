package br.ufrn.imd.visao;

import br.ufrn.imd.controle.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {

        Usuario usuario = new Usuario("src\\br\\ufrn\\imd\\dao\\usuario.txt");
        usuario.nome = "Thays";
        usuario.criar(usuario);
        Usuario usuario1 = new Usuario("src\\br\\ufrn\\imd\\dao\\usuario.txt");
        usuario1.nome = "Thays";
        usuario1.criar(usuario1);
        usuario.ler(2);

    }
}
