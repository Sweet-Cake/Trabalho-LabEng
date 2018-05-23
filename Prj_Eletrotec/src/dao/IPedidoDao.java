package dao;

import java.util.List;

import model.Pedido;

public interface IPedidoDao {
    public void insert(Pedido pedido);
    public List<Pedido> select();
}
