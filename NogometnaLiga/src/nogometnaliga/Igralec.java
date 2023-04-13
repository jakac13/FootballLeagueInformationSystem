/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnaliga;

/**
 *
 * @author JakaKralj
 */
public class Igralec {
    protected int id;
    protected String ime;
    protected String priimek;
    protected int visina;
    protected int teza;
    protected int davcna_stevilka;
    protected String naslov;
    protected int idEkipa;

    public Igralec(String ime, String priimek, int visina, int teza, int davcna_stevilka, String naslov, int idEkipa) {
        this.ime = ime;
        this.priimek = priimek;
        this.visina = visina;
        this.teza = teza;
        this.davcna_stevilka = davcna_stevilka;
        this.naslov = naslov;
        this.idEkipa = idEkipa;
    }
    
    public Igralec(int id, String ime, String priimek, int visina, int teza, int davcna_stevilka, String naslov, int idEkipa) {
        this(ime, priimek, visina, teza, davcna_stevilka, naslov, idEkipa);
        this.id = id;
    }
    
    public Igralec(){};

    public void setId(int id) {
        this.id = id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public void setVisina(int visina) {
        this.visina = visina;
    }

    public void setTeza(int teza) {
        this.teza = teza;
    }

    public void setDavcna_stevilka(int davcna_stevilka) {
        this.davcna_stevilka = davcna_stevilka;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public void setIdEkipa(int idEkipa) {
        this.idEkipa = idEkipa;
    }

    public int getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public int getVisina() {
        return visina;
    }

    public int getTeza() {
        return teza;
    }

    public int getDavcna_stevilka() {
        return davcna_stevilka;
    }

    public String getNaslov() {
        return naslov;
    }

    public int getIdEkipa() {
        return idEkipa;
    }
    
    
    
    
}
