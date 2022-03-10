package br.com.project.csgo.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamDTO {

    public Long idTeam;
    public String txName;
    private String txCountry;
    private String txContinent;

}
