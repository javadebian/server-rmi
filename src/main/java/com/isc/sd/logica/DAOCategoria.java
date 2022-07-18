package com.isc.sd.logica;

import com.isc.sd.datos.OrmConerxion;
import com.isc.sd.model.Categoria;

import java.util.List;

public class DAOCategoria implements IlogicaNegocio<Categoria, Integer> {
    private OrmConerxion conn= OrmConerxion.getInstance();
    @Override
    public void add(Categoria Objeto) {
        conn.getORMInstance().persist(Objeto);
    }

    @Override
    public Categoria edit(Categoria Objeto) {
        return null;
    }

    @Override
    public Boolean remove(Integer Integer) {
        return null;
    }

    @Override
    public List<Categoria> listData() {
        return null;
    }
}
