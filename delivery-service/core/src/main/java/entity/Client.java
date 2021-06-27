package entity;

import java.util.Objects;

public class Client {

    private Long id;
    private String name;
    private String address;

    public Client(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Client(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id) &&
                name.equals(client.name) &&
                address.equals(client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
