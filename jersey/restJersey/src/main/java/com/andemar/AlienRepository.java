package com.andemar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {

    Connection con = null;

    public AlienRepository() {
        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Alien> getAliens() {
        List<Alien> aliens = new ArrayList<>();
        String sql = "select * from alien";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoints(rs.getInt(3));

                aliens.add(a);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return aliens;
    }

    public Alien getALienById(int id) {
        String sql = "select * from alien where id = " + id;
        Alien a = new Alien();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {

                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoints(rs.getInt(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return a;

//        return aliens.stream().filter(alien -> alien.getId() == id).collect(Collectors.toList()).get(0);
    }

//    public Alien getAlienByName(String name) {
//        return aliens.stream().filter((alien -> alien.getName().equalsIgnoreCase(name))).collect(Collectors.toList()).get(0);
//    }

    public void create(Alien a1) {

        String sql = "insert into alien values (?,?,?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();

            st.setInt(1, a1.getId());
            st.setString(2, a1.getName());
            st.setInt(3, a1.getPoints());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        aliens.add(a1);
    }

    public void update(Alien a1) {

        String sql = "update alien set name=?, points=? where id=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(3, a1.getId());
            st.setString(1, a1.getName());
            st.setInt(2, a1.getPoints());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "delete from alien where id=?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
// https://www.youtube.com/watch?v=BZi44GOD8kY&t=4312s