package bookmanager.chalmers.edu.readwin.models;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by benedikt on 12/10/2017.
 */

public class Book implements Parcelable {
    private int Id;
    private String Title;
    private String Author;
    private String ISBN;
    private String Date;
    private String Genre;
    private String Description;
    private String Image; // TODO: Decide which type the avatar image should be
    private String AgeCategory;

    public Book(int id, String title, String author, String isbn, String date, String genre, String description, String image, String ageCategory) {
        Id = id;
        Title = title;
        Author = author;
        ISBN = isbn;
        Date = date;
        Genre = genre;
        Description = description;
        Image = image;
        AgeCategory = ageCategory;
    }

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

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getAgeCategory() {
        return AgeCategory;
    }

    public void setAgeCategory(String ageCategory) {
        AgeCategory = ageCategory;
    }

    public Book(Parcel parcel) {
        String[] data = new String[9];

        parcel.readStringArray(data);

        this.Id = Integer.parseInt(data[0]);
        this.Title = data[1];
        this.Author = data[2];
        this.ISBN = data[3];
        this.Date = data[4];
        this.Genre = data[5];
        this.Description = data[6];
        this.Image = data[7];
        this.AgeCategory = data[8];
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[] { String.valueOf(this.Id), this.Title, this.Author, this.ISBN, this.Date, this.Genre, this.Description, this.Image, this.AgeCategory });
    }
}