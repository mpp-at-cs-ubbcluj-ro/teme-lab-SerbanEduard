package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Repository {
    private dbUtils db;

    private static final Logger logger= LogManager.getLogger();

    public Repository(Properties prop) {
        logger.info("Initializing CarsDBRepository with properties: {} ",prop);
        db = new dbUtils(prop);
    }

    public void add(Photographer photographer) {
        Connection conn = db.getConnection();
        try(PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO photographers(name, email, is_videographer) values (?, ?, ?)")){
            preparedStatement.setString(1, photographer.getName());
            preparedStatement.setString(2, photographer.getEmail());
            preparedStatement.setBoolean(3, photographer.isPhotographer());
            preparedStatement.execute();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Iterable<Photographer> getAll() {
        Connection conn = db.getConnection();
        List<Photographer> photographers = new ArrayList<>();
        try(PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM photographers")){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                photographers.add(new Photographer(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getBoolean("is_videographer")));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return photographers;
    }

    public Iterable<Photographer> getVideographers(){
        Connection conn = db.getConnection();
        List<Photographer> photographers = new ArrayList<>();
        try(PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM photographers WHERE is_videographer=1")){
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                photographers.add(new Photographer(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getBoolean("is_videographer")));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return photographers;
    }
}
