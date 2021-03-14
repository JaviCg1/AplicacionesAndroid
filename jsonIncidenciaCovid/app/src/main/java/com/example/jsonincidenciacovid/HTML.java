package com.example.jsonincidenciacovid;

import java.util.ArrayList;

public class HTML {
    public String crearTablaHTML(data d) {
        ArrayList<Integer> casos = new ArrayList<Integer>();
        for (Incidencia incidencia : d.getData()) {
            casos.add(incidencia.getCasos_confirmados_ultimos_14dias());
        }
        int[] casosMaxMin = maxMin(casos);

        String cabecera = "<table><tr><th>DISTRITOS</th><th>FECHA</th><th>CASOS</th></tr>";
        String contenido = "";
        String fin = "</table>";

        for (Incidencia incidencia : d.getData()) {
            contenido += "<tr>";
            contenido += "<td>" + incidencia.getMunicipio_distrito() + "</td>";
            contenido += "<td>" + incidencia.getFecha_informe() + "</td>";
            contenido += "<td style=" + "\""
                    + pintarTabla(casosMaxMin, incidencia.getCasos_confirmados_ultimos_14dias()) + "\"" + ">"
                    + incidencia.getCasos_confirmados_ultimos_14dias() + "</td>";
            contenido += "</tr>";
        }

        String tabla = cabecera + contenido + fin;
        return tabla;
    }

    public String pintarTabla(int[] values, int valorCasos) {
        int max = values[0], min = values[1], c;

        c = (int) ((double) 120 - (((double) (120 / (double) (max - min))) * (double) valorCasos
                + ((double) ((double) 120 / (double) (max - min)) * (double) min)));

        String color = "background-color: hsl(" + c + ",100%,35%)";
        return color;
    }

    public int[] maxMin(ArrayList<Integer> casos) {
        int max = casos.get(0), min = casos.get(0);

        for (int i = 0; i < casos.size() - 1; i++) {
            if (casos.get(i) > max) {
                max = casos.get(i);
            } else if (casos.get(i) < min) {
                min = casos.get(i);
            }
        }

        int[] maxiMin = { max, min };

        return maxiMin;
    }
}
