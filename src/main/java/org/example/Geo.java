package org.example;

import lombok.Builder;

import java.util.Objects;

@Builder
public class Geo {
    private double lat;
    private double lng;

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Geo geo = (Geo) o;
        return Double.compare(lat, geo.lat) == 0 && Double.compare(lng, geo.lng) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lng);
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public Geo(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }
}
