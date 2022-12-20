package entity;

public class Publisher implements Comparable<Publisher>{
    private Long id;
    private String name;
    private String status;
    
    public Publisher() {
    }
    
    public Publisher(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "name=" + name + ", status=" + status ;
    }
    
    @Override public int compareTo(Publisher a) {
        return a.name.compareTo(this.name);
    }
}