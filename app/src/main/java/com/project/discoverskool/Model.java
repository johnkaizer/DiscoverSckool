package com.project.discoverskool;

public class Model {
    private String name;
    private String location;
    private String vacancy;
    private String status;
    private String description;
    private String about;
    private  int id;

    public Model() {
    }

    public Model(String name, String location, String vacancy, String status, String description, String about) {
        this.name = name;
        this.location = location;
        this.vacancy = vacancy;
        this.status = status;
        this.description = description;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
