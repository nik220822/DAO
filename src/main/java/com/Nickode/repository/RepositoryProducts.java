package com.Nickode.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryProducts {
    private final String theScript = read("select.sql");
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public RepositoryProducts(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
    }

    public List<String> getProductName(String name) throws SQLException {
        SqlParameterSource paramMap = new MapSqlParameterSource("name", name);
        return namedParameterJdbcTemplate.queryForList(
                theScript,
                paramMap,
                String.class);
    }

    public static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
