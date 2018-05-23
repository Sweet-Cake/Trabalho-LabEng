package dao;

import java.util.List;

import model.ItemPedido;

public interface IItemPedidoDao {
    public void insert(ItemPedido itemPedido);
    public List<ItemPedido> select();
}
