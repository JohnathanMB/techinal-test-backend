package org.example.model;

public record Client(
        String idType,
        String idNumber,
        String firstName,
        String secondName,
        String firstLastname,
        String secondLastName,
        String phoneNumber,
        String address,
        String city
) {
    public Client() {
        this("","","","","","","","","");
    }
}
