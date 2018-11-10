package com.gvt.ika.common.domain;

public enum PersistenceType {

    MERGE , PERSIST;




    public static PersistenceType findPersistenceType(Object id)
    {
        if(id==null)
        {
            return MERGE;
        }
        else
        {
            return PERSIST;
        }
    }
}
