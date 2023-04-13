/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnaliga;

/**
 *
 * @author JakaKralj
 */
public class Ekipa {
    protected int id;
    protected String naziv;
    protected String naslov;
    protected int posta;
    protected String glavni_trener;
    protected int stevilo_naslovov;

    public Ekipa(String naziv, String naslov, int posta, String glavni_trener, int stevilo_naslovov) {
        this.naziv = naziv;
        this.naslov = naslov;
        this.posta = posta;
        this.glavni_trener = glavni_trener;
        this.stevilo_naslovov = stevilo_naslovov;
    }
    
    public Ekipa(int id, String naziv, String naslov, int posta, String glavni_trener, int stevilo_naslovov) {
        this(naziv, naslov, posta, glavni_trener, stevilo_naslovov);
        this.id = id;
    }
    
    public Ekipa() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public void setPosta(int posta) {
        this.posta = posta;
    }

    public void setGlavni_trener(String glavni_trener) {
        this.glavni_trener = glavni_trener;
    }

    public void setStevilo_naslovov(int stevilo_naslovov) {
        this.stevilo_naslovov = stevilo_naslovov;
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getNaslov() {
        return naslov;
    }

    public int getPosta() {
        return posta;
    }

    public String getGlavni_trener() {
        return glavni_trener;
    }

    public int getStevilo_naslovov() {
        return stevilo_naslovov;
    }
    
}
