package model;

import java.time.LocalDate;

public class Record {

    // Encapsulation: private variables
    private int id;
    private String name;
    private String category;
    private LocalDate date;
    private double value;

    // Constructor
    public Record(int id, String name, String category, LocalDate date, double value) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.value = value;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setValue(double value) {
        this.value = value;
    }

    // Display Record
    @Override
    public String toString() {
        return String.format(
            "ID: %-3d | Name: %-25s | Category: %-12s | Date: %s | Value: %.2f",
            id, name, category, date, value
        );
    }
}