/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Usuario
 */
public class ReadJson {
    //Trae un arraylist
    /*public List<AuxBook> readJson() throws FileNotFoundException {
        // LEER JSON
        Reader reader = new FileReader("LibrosPrueba.json");

        Type type = new TypeToken<Collection<AuxBook>>() {
        }.getType();


        List<AuxBook> result = WriteJson.gson.fromJson(reader, type);
        return result;
    }*/

    //Trae un arr
    public AuxBook[] readJson() throws FileNotFoundException {
        // LEER JSON
        Reader reader = new FileReader("LibrosPrueba.json");

        /* Type type = new TypeToken<Collection<AuxBook>>() {
        }.getType();*/

        return  WriteJson.gson.fromJson(reader, AuxBook[].class);
    }
}
