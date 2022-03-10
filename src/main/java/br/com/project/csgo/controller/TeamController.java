package br.com.project.csgo.controller;

import br.com.project.csgo.model.Team;
import br.com.project.csgo.model.dto.TeamDTO;
import br.com.project.csgo.repository.TeamRepository;
import br.com.project.csgo.service.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/csgo")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    ModelMapper modelMapper;

//    @GetMapping("/all")
//    public ResponseEntity<?> listAll(){
//        teamService.listAll();
//        return ResponseEntity.ok().build();
//    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(Team team) {
        List<Team> result = teamService.findAll(team);
        List<TeamDTO> dto = result.stream().map(teamService::convertToDto).collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{idTeam}")
    public Optional<Team> findById(@PathVariable("idTeam") Long id) {
        return teamRepository.findById(id);
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TeamDTO teamDTO){
        teamService.create(teamDTO);
        return ResponseEntity.ok().build();
    }
}
