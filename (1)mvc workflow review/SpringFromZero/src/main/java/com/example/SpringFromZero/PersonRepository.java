package com.example.SpringFromZero;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  //added dependency "starter-data-rest"


//PagingAndSortingRepository allows you to use the method findAll(a) but it will let you sort based on the argument
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, CrudRepository<Person,Long> {

  List<Person> findByLastName(@Param("name") String name);// will allow you to sort based in name field of Person
  //find by whatever you can make then up 
  
  List<Person> findByFirstName(@Param("name") String name);


}