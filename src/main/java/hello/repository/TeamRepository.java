package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.entity.Team;

public interface TeamRepository extends CrudRepository<Team, Integer>{

}
