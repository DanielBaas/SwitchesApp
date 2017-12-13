package com.equipo7.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBConnection {
    
    public DriverManagerDataSource connect () {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/CiscoSwitches");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        
        return dataSource;
    }
    
}
