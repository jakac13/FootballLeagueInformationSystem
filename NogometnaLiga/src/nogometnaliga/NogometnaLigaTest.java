/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nogometnaliga;

import java.util.ArrayList;

/**
 *
 * @author JakaKralj
 */
public class NogometnaLigaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EkipaDaoImpl ekipaDao = new EkipaDaoImpl();
        
        ArrayList<Ekipa> ekipe = ekipaDao.getAllEkipe();
        for (Ekipa ekipa : ekipe) {
            System.out.println(ekipa.getId() + ", " + ekipa.getNaziv()+ ", " + ekipa.getGlavni_trener());
        }
        
        Ekipa jaka = new Ekipa();
        jaka = ekipaDao.getEkipaById(1);
        System.out.println(jaka.glavni_trener);
        
        /*
        Ekipa tine = new Ekipa("Fajfar FC", "Smartinska 12", 1000, "Nace Nacarski", 2);
        ekipaDao.insertEkipa(tine);
        */
        
        ekipaDao.deleteEkipa(5);
    }
    
}
