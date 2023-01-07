package entity;

import enumeration.AuthorStatus;


public class Author implements Comparable<Author> {

    private Long id;
    private String name;
    private AuthorStatus status;

    public Author() {
    }
    
    public Author(Long id, String name, AuthorStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Author(String name, AuthorStatus status) {
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorStatus getStatus() {
        return status;
    }

    public void setStatus(AuthorStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "name=" + name + ", status=" + status;
    }

    @Override
    public int compareTo(Author a) {
        return a.name.compareTo(this.name);
    }
}
