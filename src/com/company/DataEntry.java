package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataEntry {

    private Date date;
    // moisture and light_intensity may not be integers in final product, but I'll just consider them ints for the time being
    private int moisture;
    private int lightIntensity;
    private boolean isRaining;

    public DataEntry(Date date, int moisture, int lightIntensity, boolean isRaining) {
        this.date = date;
        this.moisture = moisture;
        this.lightIntensity = lightIntensity;
        this.isRaining = isRaining;
    }

    // Getters and setters

    public Date getDate() {return date;}

    public String getDateString() {return new SimpleDateFormat("yyyy-MM-dd").format(date);}

    public int getMoisture() {return moisture;}

    public int getLightIntensity() {return lightIntensity;}

    public boolean getRaining() {return isRaining;}

    public int getRainingInt() {return isRaining ? 1 : 0;}

    public void setDate (Date date) {this.date = date; }

    public void setMoisture (int moisture) {this.moisture = moisture; }

    public void setLightIntensity (int lightIntensity) {this.lightIntensity = lightIntensity;}

    public void setRaining (boolean isRaining) {this.isRaining = isRaining;}

    @Override
    public String toString () {
        return "Date: " + date + ", Moisture: " + moisture + ", Light intensity: " + lightIntensity + ", Was it raining: " + isRaining;
    }
}
