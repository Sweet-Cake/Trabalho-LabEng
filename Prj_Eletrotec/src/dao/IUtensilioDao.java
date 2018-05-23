package dao;

import java.util.List;

import model.Utensilio;

public interface IUtensilioDao {
    public void insert(Utensilio utensilio);
    public List<Utensilio> select();
}
