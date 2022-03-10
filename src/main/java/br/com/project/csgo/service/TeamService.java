package br.com.project.csgo.service;

import br.com.project.csgo.controller.TeamController;
import br.com.project.csgo.model.Team;
import br.com.project.csgo.model.dto.TeamDTO;
import br.com.project.csgo.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    ModelMapper modelMapper;


    public Team convertDToEntity(TeamDTO teamDTO){
        Team team = new Team();
        team.setTxName(teamDTO.getTxName());
        team.setTxCountry(teamDTO.getTxCountry());
        team.setTxContinent(teamDTO.getTxContinent());
        return save(team);
    }

    private Team save(Team team) {
        return teamRepository.save(team);
    }

    public TeamDTO convertToDto(Team team){
        return modelMapper.map(team, TeamDTO.class);
    }

    public List<Team> findAll(Team team) {
        return teamRepository.findAll();
    }

    public Team create(TeamDTO teamDTO){
        Team team;
        team = convertDToEntity(teamDTO);
        return save(team);
    }


}
