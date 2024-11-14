/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author lacab
 */
public class Contacto {
    private String nombre;
    private String numeroTlf;
    private Image foto;
    private String direccionCasa;
    private String direccionTrabajo;
    private String emailPersonal;
    private String trabajo;
    private ArrayList<String> numerosTlfs;

    public Contacto(String numeroTlf) {
        this.numeroTlf = numeroTlf;
    }

    public Contacto(String nombre, String numeroTlf, Image foto, String direccionCasa, String direccionTrabajo, String emailPersonal, String trabajo, ArrayList<String> numerosTlfs) {
        this.nombre = nombre;
        this.numeroTlf = numeroTlf;
        this.foto = foto;
        this.direccionCasa = direccionCasa;
        this.direccionTrabajo = direccionTrabajo;
        this.emailPersonal = emailPersonal;
        this.trabajo = trabajo;
        this.numerosTlfs = numerosTlfs;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroTlf() {
        return numeroTlf;
    }

    public void setNumeroTlf(String numeroTlf) {
        this.numeroTlf = numeroTlf;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public String getDireccionCasa() {
        return direccionCasa;
    }

    public void setDireccionCasa(String direccionCasa) {
        this.direccionCasa = direccionCasa;
    }

    public String getDireccionTrabajo() {
        return direccionTrabajo;
    }

    public void setDireccionTrabajo(String direccionTrabajo) {
        this.direccionTrabajo = direccionTrabajo;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public ArrayList<String> getNumerosTlfs() {
        return numerosTlfs;
    }

    public void setNumerosTlfs(ArrayList<String> numerosTlfs) {
        this.numerosTlfs = numerosTlfs;
    }
}