package com.vj.wlweb.util;


import commonj.work.WorkManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ServiceLocator {

    public static DataSource getDataSource(String jndiName) throws NamingException {
        Context ctx = null;
        DataSource ds = null;
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup(jndiName);

        return ds;
    }
    
}