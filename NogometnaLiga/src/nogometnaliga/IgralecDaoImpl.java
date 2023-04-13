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
public class IgralecDaoImpl implements IgralecDao {

    String dbURL = "jdbc:ucanaccess://D://Šola//Jaka Programiranje - TIS//NogometnaLiga//nogometnaliga.accdb";
    String SQL_GET_ALL = "SELECT Id, Ime, Priimek, Visina, Teza, Davcna_Stevilka, Naslov, IDEkipa FROM Igralec order by id";

    @Override
    public ArrayList<Igralec> getAllIgralci() {
        Connection conn;
        Statement stmt;
        ResultSet rs;

        int id;
        String ime;
        String priimek;
        int visina;
        int teza;
        int davcna_stevilka;
        String naslov;
        int idEkipa;

        ArrayList<Igralec> igralci = new ArrayList();

        try {
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL);

            while (rs.next()) {
                id = rs.getInt("Id");
                ime = rs.getString("Ime");
                priimek = rs.getString("Priimek");
                visina = rs.getInt("Visina");
                teza = rs.getInt("Teza");
                davcna_stevilka = rs.getInt("Davcna_Stevilka");
                naslov = rs.getString("Naslov");
                idEkipa = rs.getInt("IDEkipa");
                Igralec igralec = new Igralec(id, ime, priimek, visina, teza, davcna_stevilka, naslov, idEkipa);
                igralci.add(igralec);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException es) {
            es.printStackTrace();
        }
        return igralci;
    }

    @Override
    public Igralec getIgralecById(int idI) {
        Connection conn;
        ResultSet rs;
        PreparedStatement pr1;

        String sql = "Select * FROM Igralec WHERE id=?";

        int id;
        String ime;
        String priimek;
        int visina;
        int teza;
        int davcna_stevilka;
        String naslov;
        int idEkipa;

        Igralec igralec = new Igralec();

        try {
            conn = DriverManager.getConnection(dbURL);
            pr1 = conn.prepareStatement(sql);
            pr1.setInt(1, idI);
            rs = pr1.executeQuery();
            if (rs.next()) {
                id = rs.getInt("Id");
                ime = rs.getString("Ime");
                priimek = rs.getString("Priimek");
                visina = rs.getInt("Visina");
                teza = rs.getInt("Teza");
                davcna_stevilka = rs.getInt("Davcna_Stevilka");
                naslov = rs.getString("Naslov");
                idEkipa = rs.getInt("IDEkipa");

                igralec.setId(id);
                igralec.setIme(ime);
                igralec.setPriimek(priimek);
                igralec.setVisina(visina);
                igralec.setTeza(teza);
                igralec.setDavcna_stevilka(davcna_stevilka);
                igralec.setNaslov(naslov);
                igralec.setIdEkipa(idEkipa);
            }

            pr1.close();
            conn.close();
            rs.close();

        } catch (SQLException es) {
            es.printStackTrace();
        }
        return igralec;
    }

    @Override
    public void insertIgralec(Igralec igr) {
        String sql = "INSERT INTO Igralec (Ime, Priimek, Visina, Teza, Davcna_Stevilka, Naslov, IDEkipa) VALUES(?, ?, ?, ?,?,?,?)";
        Connection conn;
        PreparedStatement pr1;
        try {
            conn = DriverManager.getConnection(dbURL);
            pr1 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pr1.setString(1, igr.getIme());
            pr1.setString(2, igr.getPriimek());
            pr1.setInt(3, igr.getVisina());
            pr1.setInt(4, igr.getTeza());
            pr1.setInt(5, igr.getDavcna_stevilka());
            pr1.setString(6, igr.getNaslov());
            pr1.setInt(7, igr.getIdEkipa());
            pr1.executeUpdate();

            try ( ResultSet generatedKeys = pr1.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    igr.setId(generatedKeys.getInt(1));
                }
            }
            pr1.close();
            conn.close();

        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

    @Override
    public void updateIgralec(Igralec igr) {
        String sql = "Update Igralec SET Ime=?, Priimek=?, Visina=?, Teza=?, Davcna_Stevilka=?, Naslov=?, IDEkipa=? WHERE Id=?";
        Connection conn;
        PreparedStatement pr1;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            pr1 = conn.prepareStatement(sql);
            pr1.setInt(8, igr.getId());
            pr1.setString(1, igr.getIme());
            pr1.setString(2, igr.getPriimek());
            pr1.setInt(3, igr.getVisina());
            pr1.setInt(4, igr.getTeza());
            pr1.setInt(5, igr.getDavcna_stevilka());
            pr1.setString(6, igr.getNaslov());
            pr1.setInt(7, igr.getIdEkipa());
            
            pr1.executeUpdate();
            pr1.close();
            conn.close();

        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

    @Override
    public void deleteIgralec(int idI) {
        String sql = "DELETE FROM Igralec WHERE Id=?  ";
        Connection conn;
        PreparedStatement pr1;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            pr1 = conn.prepareStatement(sql);
            pr1.setInt(1, idI);
            pr1.executeUpdate();
            pr1.close();
            conn.close();

        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

}
