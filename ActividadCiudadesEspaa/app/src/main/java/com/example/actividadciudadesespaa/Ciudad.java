package com.example.actividadciudadesespaa;

public class Ciudad {
    private String city, lat, lng, population;

    public Ciudad(String city, String lat, String lng, String population) {
        this.city = city;
        this.lat = lat;
        this.lng = lng;
        this.population = population;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return
                 city ;

    }
}
