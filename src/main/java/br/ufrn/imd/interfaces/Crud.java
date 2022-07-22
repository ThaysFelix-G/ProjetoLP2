package br.ufrn.imd.interfaces;

import java.io.IOException;

public interface Crud <T>{
    public Boolean criar(T object) throws IOException;

    public Boolean remover(int id) throws IOException;

    public Boolean atualizar(T object) throws IOException;

    public Object ler(int id) throws IOException;
}
