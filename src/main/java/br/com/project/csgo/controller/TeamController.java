package br.com.project.csgo.controller;

import br.com.project.csgo.model.Team;
import br.com.project.csgo.repository.TeamRepository;
import br.com.project.csgo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/csgo")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/find")
    public ResponseEntity<Team> findAll(){
        teamService.findAll();
       return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Team team){
        teamService.create(team);
        return ResponseEntity.ok().build();
    }
}
