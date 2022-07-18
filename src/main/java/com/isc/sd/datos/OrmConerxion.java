package com.isc.sd.datos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrmConerxion {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DSCampeonato");
    private EntityManager em = emf.createEntityManager();
    private static OrmConerxion ormConerxion = null;

    public static OrmConerxion getInstance(){
        if(ormConerxion==null){
            ormConerxion= new OrmConerxion();
        }
        return ormConerxion;
    }

    public EntityManager getORMInstance(){
        return em;
    }
}
