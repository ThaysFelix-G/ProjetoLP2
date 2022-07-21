package br.ufrn.imd.controle;

import br.ufrn.imd.dao.DB;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Usuario extends DB {
    public int id;
    public String nome;
    public String email;
    public String senha;

    @Override
    public String toString() {
        return  "" + nome + '\n' +
                "" + email + '\n' +
                "" + senha + '\n';
    }

    public Usuario(String caminho) throws IOException {
        super(caminho);
        email = "vazio";
        senha = "vazio";
        nome = "vazio";
    }
    public Usuario() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
