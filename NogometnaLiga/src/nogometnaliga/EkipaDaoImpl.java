/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnaliga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author JakaKralj
 */
public class EkipaDaoImpl implements EkipaDao {

    String dbURL = "jdbc:ucanaccess://D://Šola//Jaka Programiranje - TIS//NogometnaLiga//nogometnaliga.accdb";
    String SQL_GET_ALL = "SELECT Id, Naziv, Naslov, Posta, Glavni_trener, Stevilo_naslovov FROM Ekipa order by id";

    @Override
    public ArrayList<Ekipa> getAllEkipe() {
        Connection conn;
        Statement stmt;
        ResultSet rs;

        int id;
        String naziv;
        String naslov;
        int posta;
        String glavni_trener;
        int stevilo_naslovov;

        ArrayList<Ekipa> ekipe = new ArrayList();
        try {
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL);

            while (rs.next()) {
                id = rs.getInt("Id");
                naziv = rs.getString("Naziv");
                naslov = rs.getString("Naslov");
                posta = rs.getInt("Posta");
                glavni_trener = rs.getString("Glavni_trener");
                stevilo_naslovov = rs.getInt("Stevilo_naslovov");
                Ekipa ekipa = new Ekipa(id, naziv, naslov, posta, glavni_trener, stevilo_naslovov);
                ekipe.add(ekipa);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException es) {
            es.printStackTrace();
        }

        return ekipe;
    }

    @Override
    public Ekipa getEkipaById(int idN) {
        int id;
        String naziv;
        String naslov;
        int posta;
        String glavni_trener;
        int stevilo_naslovov;
        String sql;

        Connection conn;
        ResultSet rs;
        PreparedStatement pr1;
        Ekipa ekipa = new Ekipa();
        
        try {
            sql = "Select * FROM Ekipa WHERE Id=?";
            conn = DriverManager.getConnection(dbURL);

            pr1 = conn.prepareStatement(sql);
            pr1.setInt(1, idN);
            rs = pr1.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
                naziv = rs.getString("Naziv");
                naslov = rs.getString("Naslov");
                posta = rs.getInt("Posta");
                glavni_trener = rs.getString("Glavni_trener");
                stevilo_naslovov = rs.getInt("Stevilo_naslovov");

                ekipa.setId(id);
                ekipa.setNaziv(naziv);
                ekipa.setNaslov(naslov);
                ekipa.setPosta(posta);
                ekipa.setGlavni_trener(glavni_trener);
                ekipa.setStevilo_naslovov(stevilo_naslovov);

            }
            pr1.close();
            conn.close();
            rs.close();
        } catch (SQLException es) {
            es.printStackTrace();
        }
        return ekipa;
    }

    @Override
    public void insertEkipa(Ekipa ek) {
        String sql;
        Connection conn;
        PreparedStatement pr1;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "INSERT INTO Ekipa (Naziv, Naslov, Posta, Glavni_trener, Stevilo_naslovov) VALUES(?, ?, ?, ?,?)";

            pr1 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pr1.setString(1, ek.getNaziv());
            pr1.setString(2, ek.getNaslov());
            pr1.setDouble(3, ek.getPosta());
            pr1.setString(4, ek.getGlavni_trener());
            pr1.setInt(5, ek.getStevilo_naslovov());
            pr1.executeUpdate();
            
            try (ResultSet generatedKeys = pr1.getGeneratedKeys())  {
                if (generatedKeys.next()){
                    ek.setId(generatedKeys.getInt(1));
                }
            }
            pr1.close();
            conn.close();

        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

    @Override
    public void updateEkipa(Ekipa ek) {
        String sql;
        Connection conn;
        PreparedStatement pr1;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Update Ekipa SET Naziv=?, Naslov=?, Posta=?, Glavni_trener=?, Stevilo_naslovov=? WHERE id=?  ";

            pr1 = conn.prepareStatement(sql);
            pr1.setString(1, ek.getNaziv());
            pr1.setString(2, ek.getNaslov());
            pr1.setInt(3, ek.getPosta());
            pr1.setString(4, ek.getGlavni_trener());
            pr1.setInt(5, ek.getStevilo_naslovov());
            pr1.setInt(6, ek.getId());

            pr1.executeUpdate();
            pr1.close();
            conn.close();

        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

    @Override
    public void deleteEkipa(int id) {
        String sql;
        Connection conn;
        PreparedStatement pr1;
        
        try {

            conn = DriverManager.getConnection(dbURL);
            sql = sql = "DELETE FROM  Ekipa WHERE Id=?  ";
            pr1 = conn.prepareStatement(sql);
            pr1.setInt(1, id);
            pr1.executeUpdate();
            pr1.close();
            conn.close();

        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

}
