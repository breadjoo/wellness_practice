package org.example.springapi;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SportsInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double met;
    private String sport;
    private SportsInfo() {}


    public SportsInfo(Long id, double met, String sport) {
        this.id = id;
        this.met = met;
        this.sport = sport;
    }
}
