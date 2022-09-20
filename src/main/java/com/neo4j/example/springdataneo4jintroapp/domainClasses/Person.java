package com.neo4j.example.springdataneo4jintroapp.domainClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Node
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @Property("born")
    private Integer birthYear;

    @JsonIgnoreProperties("person")
    @Relationship(type = "ACTED_IN")
    private List<Movie> actedIn = new ArrayList<>();

    @JsonIgnoreProperties({ "actors", "directors" })
    @Relationship(type = "DIRECTED")
    private List<Movie> directed = new ArrayList<>();

    public Person(String name, Integer birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

}
