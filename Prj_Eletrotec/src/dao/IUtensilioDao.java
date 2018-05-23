package dao;

import java.util.List;

import model.Utensilio;

public interface IUtensilioDao {
    public void insert(Utensilio person);
    public List<Utensilio> select();
}
