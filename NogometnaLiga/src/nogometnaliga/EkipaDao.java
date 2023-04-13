/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnaliga;

import java.util.ArrayList;

/**
 *
 * @author JakaKralj
 */
public interface EkipaDao {
    public ArrayList<Ekipa> getAllEkipe();
    public Ekipa getEkipaById(int id);
    public void insertEkipa(Ekipa ek);
    public void updateEkipa(Ekipa ek);
    public void deleteEkipa(int id);
}
