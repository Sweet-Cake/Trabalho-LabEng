package dao;

import java.util.List;

import model.Estoque;

public interface IEstoqueDao {

    public void insert(Estoque estoque);
    public List<Estoque> select();
}
