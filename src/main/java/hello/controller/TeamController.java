package hello.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.entity.Child;
import hello.entity.Team;
import hello.repository.TeamRepository;
import hello.service.TeamService;

@RestController
public class TeamController {
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	TeamService service;
	
	@RequestMapping("/teams")
	public List<Team> getAll() {
		List<Team> teams = new ArrayList<>();
		
		for (Team t : teamRepository.findAll()) {
			teams.add(t);
		}
		
		return teams;
	}
	
	@RequestMapping("/team/add")
	public Team add(@RequestParam(value="name") String name,
					@RequestParam(value="teacherF") String teacherFirstName,
					@RequestParam(value="teacherL") String teacherLastName,
					@RequestParam(value="points") int points) {
		
		return teamRepository.save(new Team(name, teacherFirstName,teacherLastName, points));
	}
	
	@RequestMapping("/team/delete")
	public void delete(@RequestParam(value="id") Integer id) {
		teamRepository.deleteById(id);
	}
	
	@RequestMapping("/team/edit")
	public Team edit(@RequestParam(value="id") Integer id,
						@RequestParam(value="name") String name,
						@RequestParam(value="teacherF") String teacherFirstName,
						@RequestParam(value="teacherL") String teacherLastName) {
		
		Team editTeam = teamRepository.findById(id).get();
		editTeam.setName(name);
		editTeam.setTeacherFirstName(teacherFirstName);
		editTeam.setTeacherLastName(teacherLastName);
		
		return teamRepository.save(editTeam);
	}
	
	@RequestMapping("/team/{id}")
	public Team detail(@PathVariable Integer id) {
		return teamRepository.findById(id).get();
	}

	@RequestMapping("/team/{teamId}/points")
	public Team addPoints(@PathVariable Integer teamId, @RequestParam(value="points") int points) {
		Team editTeam = teamRepository.findById(teamId).get();
		editTeam.setPoints(points);
		
		return teamRepository.save(editTeam);
	}
	
	@RequestMapping("/team/{id}/children")
	public List<Child> getChildren(@PathVariable Integer id) {
		Team team = teamRepository.findById(id).get();
		return team.getChildren();
	}
	
	@RequestMapping("/team/{teamId}/children/add/{childId}")
	public boolean addChild(@PathVariable Integer teamId, @PathVariable int childId) {
		return service.addChildToTeam(teamId, childId);
	}
	
	@RequestMapping("/team/{teamId}/children/delete/{childId}")
	public boolean deleteChild(@PathVariable int teamId, @PathVariable int childId) {
		return service.deleteChildFromTeam(teamId, childId);
	}

}
