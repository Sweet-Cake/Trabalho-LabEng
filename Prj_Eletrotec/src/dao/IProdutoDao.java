package dao;

import java.util.List;

import model.Produto;


public interface IProdutoDao {
    public void insert(Produto produto);
    public List<Produto> select();
}
