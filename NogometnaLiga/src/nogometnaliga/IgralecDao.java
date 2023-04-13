/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nogometnaliga;

import java.util.ArrayList;

/**
 *
 * @author JakaKralj
 */
public interface IgralecDao {
    public ArrayList<Igralec> getAllIgralci();
    public Igralec getIgralecById(int idI);
    public void insertIgralec(Igralec igr);
    public void updateIgralec(Igralec igr);
    public void deleteIgralec(int idI);
}
