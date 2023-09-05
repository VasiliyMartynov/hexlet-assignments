package exercise.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

@RequiredArgsConstructor
public class PeopleController {


    private final JdbcTemplate jdbc;


    @PostMapping("/people")
    public void createPerson(@RequestBody Map<String, Object> person) {
        String query = "INSERT INTO person (first_name, last_name) VALUES (?, ?)";
        jdbc.update(query, person.get("first_name"), person.get("last_name"));
    }

    // BEGIN
    @GetMapping("/people")
    public List<Map<String, Object>> getPeoples(){
        String query = "SELECT first_name, last_name from person";
        return jdbc.queryForList(query);
    }

    @GetMapping("people/{id}")
    public Map<String, Object> getPeople(@PathVariable long id){
        String query = "SELECT first_name, last_name FROM person WHERE id=?";
        return jdbc.queryForMap(query, id);
    }
    // END
}
