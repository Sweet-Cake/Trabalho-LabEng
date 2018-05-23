package dao;

import java.util.List;

import model.UtensilioProduto;

public interface IUtensilioProdutoDao {
    public void insert(UtensilioProduto utensilioProduto);
    public List<UtensilioProduto> select();
}
