package entity;

import enumeration.CategoryStatus;

public class Category implements Comparable<Category> {

    private Long id;
    private String name;
    private CategoryStatus status;

    public Category() {
    }
    
    public Category(Long id, String name, CategoryStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Category(String name, CategoryStatus status) {
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

    public CategoryStatus getStatus() {
        return status;
    }

    public void setStatus(CategoryStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "name=" + name + ", status=" + status;
    }

    @Override
    public int compareTo(Category a) {
        return a.name.compareTo(this.name);
    }
}
