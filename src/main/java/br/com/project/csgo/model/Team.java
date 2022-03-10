package br.com.project.csgo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
@Data
@Table(name = "team")
public class Team implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_team")
    private Long idTeam;

    @Column(name = "tx_name")
    private String txName;

    @Column(name = "tx_country")
    private String txCountry;

    @Column(name = "tx_continent")
    private String txContinent;

    @Column(name = "dt_create")
    private LocalDateTime dtCreate = LocalDateTime.now();


}
