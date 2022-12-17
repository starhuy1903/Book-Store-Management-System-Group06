package entity;

public class Publisher implements Comparable<Publisher>{
    int id;
    String name;
    String status;
    
    @Override public int compareTo(Publisher a)
    {
        return a.name.compareTo(this.name);
    }

    public Publisher() {
    }
    
    public Publisher(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
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
}
