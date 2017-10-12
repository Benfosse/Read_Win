package bookmanager.chalmers.edu.readwin.models;

import android.media.Image;

/**
 * Created by benedikt on 12/10/2017.
 */

public class Book {
    private int Id;
    private String Title;
    private String Author;
    private String ISBN;
    private String Date;
    private String Genre;
    private String Description;
    //private Image Avatar; // TODO: Decide which type the avatar image should be
    private String AgeCategory;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAgeCategory() {
        return AgeCategory;
    }

    public void setAgeCategory(String ageCategory) {
        AgeCategory = ageCategory;
    }
}
