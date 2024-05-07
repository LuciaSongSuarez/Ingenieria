/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Clase para serializar y deserializar usando ficheros y objetos serializables
 * incluidos en una lista
 * @author Fernando
 */
public class FileUtil{
    private String path;
    public FileUtil(String path) {
    	this.path=path;
    }
    /**
     * guarda en el archivo indicado en path la lista
     * @param l lista que se va a guardar
     */
    public void save(List l){
        try(FileOutputStream fos=new FileOutputStream(path);
            ObjectOutputStream oos=new ObjectOutputStream(fos)){
            oos.writeObject(l);
        }catch(IOException e){
            System.out.println("Problema de IO al serializar");
            System.out.println(e.toString());
        }
    }
    /**
     * lee la lista que hay en path
     * @return devuelve la lista o null si hay error 
     */
    public List readList(){
        try(FileInputStream fis=new FileInputStream(path);
            ObjectInputStream oos=new ObjectInputStream(fis)){
            return (List) oos.readObject();
        }catch(ClassNotFoundException e){
            System.out.println("No se ha encontrado la clase al deserializar");
            System.out.println(e.toString());
            return null;
        } catch (IOException e) {
            System.out.println("Problema de IO al deserializar");
            System.out.println(e.toString());
            return null;
        }
    }
    
}
