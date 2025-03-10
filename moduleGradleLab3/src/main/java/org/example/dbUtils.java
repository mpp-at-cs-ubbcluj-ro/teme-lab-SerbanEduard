package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class dbUtils {

    private Properties jdbcProps;

    private static final Logger logger= LogManager.getLogger();

    public dbUtils(Properties prop) {
        this.jdbcProps = prop;
    }

    private Connection instance = null;

    private Connection getNewConnection(){

        String url=jdbcProps.getProperty("jdbc.url");
        Connection con=null;
        try {
            logger.info("trying to connect to database ... {}",url);
            con= DriverManager.getConnection(url);

        } catch (SQLException e) {
            logger.error(e);
            System.out.println("Error getting connection "+e);
        }
        return con;
    }

    public Connection getConnection(){
        try {
            if (instance==null || instance.isClosed())
                instance=getNewConnection();

        } catch (SQLException e) {
            logger.error(e);
            System.out.println("Error DB "+e);
        }
        logger.traceExit(instance);
        return instance;
    }
}
