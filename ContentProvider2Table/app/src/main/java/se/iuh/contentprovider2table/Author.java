package se.iuh.contentprovider2table;

import java.util.Objects;

public class Author {
    private int id_author;
    private String name, address, email;

    public Author(int id_author, String name, String address, String email) {
        this.id_author = id_author;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Author() {
    }

    public int getId() {
        return id_author;
    }

    public void setId(int id_author) {
        this.id_author = id_author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id_author == author.id_author;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_author);
    }

    @Override
    public String toString() {
        return this.id_author + "-" + this.name + "-" + this.address + "-" + this.email;
    }
}
