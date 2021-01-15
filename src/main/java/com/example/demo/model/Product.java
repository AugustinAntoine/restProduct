package com.example.demo.model;

public class Product {
    public Product(String nom, double prix){
        this.nom = nom;
        this.prix = prix;
    }

    public Product(String nom, double prix, String chemin, String description){
        this.nom = nom;
        this.prix = prix;
        this.cheminImage = chemin;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    private int id;
    private String nom;
    private double prix;
    private String description;
    private String cheminImage;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }


    public void update(Product product) {
        this.setNom(product.nom);
        this.setPrix(product.prix);
    }
}
