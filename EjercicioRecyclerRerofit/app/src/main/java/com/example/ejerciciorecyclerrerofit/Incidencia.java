package com.example.ejerciciorecyclerrerofit;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Root;

@Root(name ="Incidencias", strict=false)
public class Incidencia {
    @Element(name="fh_inicio")
    private String fh_inicio;
    @Element(name="fh_final")
    private String  fh_fin;
    @Element(name="descripcion")
    private String descripcion;

    public Incidencia(String fh_inicio, String fh_fin, String descripcion) {

        this.fh_inicio = fh_inicio;
        this.fh_fin = fh_fin;
        this.descripcion = descripcion;
    }

    public String getFh_inicio() {
        return fh_inicio;
    }

    public void setFh_inicio(String fh_inicio) {
        this.fh_inicio = fh_inicio;
    }

    public String getFh_fin() {
        return fh_fin;
    }

    public void setFh_fin(String fh_fin) {
        this.fh_fin = fh_fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
