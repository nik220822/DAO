package com.Nickode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class Rep {
    private final String theScript = read("select.sql");
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//    private final DataSource dataSource;

//    Rep(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
//        this.dataSource = dataSource;
//        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//        this.theScript = read("select.sql");
//    }

//    public String getProductName(String name) throws SQLException {
//        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("name", name);
//        return this.namedParameterJdbcTemplate.queryForObject(theScript, sqlParameterSource, String.class);
//    }

    public List<String> getProductName(String name) throws SQLException {
        ConcurrentHashMap<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("name", name);
        return namedParameterJdbcTemplate.query(
                theScript,
                paramMap,
                (resultSet, rowNum) -> resultSet.getString("product_name"));
//        return namedParameterJdbcTemplate.queryForList(theScript, paramMap, String.class);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
