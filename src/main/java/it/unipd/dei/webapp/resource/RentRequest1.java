package it.unipd.dei.webapp.resource;

public class RentRequest1 {
    private final String student;
    private final String address;
    private final int badge;

    public RentRequest1(String student, String address, int badge){
        this.student = student;
        this.address = address;
        this.badge = badge;
    }

    public String getAddress() {
        return address;
    }

    public int getBadge() {
        return badge;
    }

    public String getStudent() {
        return student;
    }
}