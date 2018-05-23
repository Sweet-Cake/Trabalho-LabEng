package dao;

import java.util.List;

import model.Cliente;

public interface IClienteDao {
    public void insert(Cliente cliente);
    public List<Cliente> select();
}
