package com.Nickode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/")
public class Contr {
    Rep repository;
    Contr(Rep repository){
        this.repository = repository;
    }
    @GetMapping("/products/fetch-product")
    List<String> getName(@RequestParam("name") String name) throws SQLException {
        return repository.getProductName(name);
    }
}