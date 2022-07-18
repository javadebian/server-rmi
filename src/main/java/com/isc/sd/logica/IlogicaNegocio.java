package com.isc.sd.logica;

import java.util.List;

public interface IlogicaNegocio <T,ID> {
    public void add(T Objeto);
    public T edit(T Objeto);
    public Boolean remove(ID Integer);
    public List<T> listData();
}
