package br.com.project.csgo.service;

import br.com.project.csgo.model.Team;
import br.com.project.csgo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team create(Team teamDTO){
        Team team = new Team();
        team.setTxName(teamDTO.getTxName());
        team.setTxCountry(teamDTO.getTxCountry());
        team.setTxContinent(teamDTO.getTxContinent());
        return teamRepository.save(teamDTO);
    }

    public List<Team> findAll(){
       return teamRepository.findAll();
    }
}
