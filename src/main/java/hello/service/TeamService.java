package hello.service;

import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.entity.Child;
import hello.entity.Team;
import hello.repository.ChildRepository;
import hello.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	ChildRepository childRepository;
	
	@Transactional
	public boolean addChildToTeam(Integer teamId, Integer childId) {
		Team t = null;
		Child c = null;
		
		try {
			t = teamRepository.findById(teamId).get();
			c = childRepository.findById(childId).get();
		} catch (NoSuchElementException e) {
			return false;
		}
		
		c.setTeam(t);
		childRepository.save(c);
		t.getChildren().add(c);
		teamRepository.save(t);
		return true;
	}
	
	@Transactional
	public boolean deleteChildFromTeam(Integer teamId, Integer childId) {
		Team t = null;
		Child c = null;
		
		try {
			t = teamRepository.findById(teamId).get();
			c = childRepository.findById(childId).get();
		} catch (NoSuchElementException e) {
			return false;
		}
		
		t.removeChild(c);
		return true;
	}

}
