package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.entity.Child;

public interface ChildRepository extends CrudRepository<Child, Integer>{

}
