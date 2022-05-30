package com.vj.wlweb.service;

import com.vj.wlweb.util.ServiceLocator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBVersionService {

    private final static Logger LOGGER = Logger.getLogger(DBVersionService.class.getName());

    public static String getMySQLVersion() {

        String version = "no version";

        DataSource ds;
        try {
            ds = ServiceLocator.getDataSource("MariaDB");
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
        Connection con = null;

        try {
            con = ds.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT VERSION()");

            if (rs.next()) {

                version = rs.getString(1);
            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, null, ex);
                }
            }
        }

        return version;
    }
}
