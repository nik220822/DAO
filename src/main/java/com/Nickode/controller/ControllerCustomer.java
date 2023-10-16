package com.Nickode.controller;

import com.Nickode.repository.RepositoryProducts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/")
public class ControllerCustomer {
    private RepositoryProducts repository;
    public ControllerCustomer(RepositoryProducts repository){
        this.repository = repository;
    }
    @GetMapping("/products/fetch-product")
    public List<String> getName(@RequestParam("name") String name) throws SQLException {
        return repository.getProductName(name);
    }
}
