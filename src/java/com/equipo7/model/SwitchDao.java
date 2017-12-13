package com.equipo7.model;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SwitchDao {
    
    public void insertSwitch(SwitchCisco switchCisco) {
        try {
            ConnectionSource connectionSource = (ConnectionSource) new DBConnection();
            Dao<SwitchCisco, String> dao = DaoManager.createDao(connectionSource, SwitchCisco.class);
            
            dao.create(switchCisco);
            connectionSource.close();
        } catch (SQLException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public SwitchCisco findSwitchByIP(String ip) {
        final String FIELD_NAME = "host";
        int id = -1;
        SwitchCisco switchCisco = new SwitchCisco();
        
        try {
            ConnectionSource connectionSource = (ConnectionSource) new DBConnection();
            Dao<SwitchCisco, String> dao = DaoManager.createDao(connectionSource, SwitchCisco.class);
            
            QueryBuilder<SwitchCisco, String> queryBuilder = dao.queryBuilder();
            
            queryBuilder.where().eq(FIELD_NAME, ip);
            
            PreparedQuery<SwitchCisco> preparedQuery = queryBuilder.prepare();
            
            if (!dao.query(preparedQuery).isEmpty()) {
                switchCisco = dao.query(preparedQuery).get(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return switchCisco;
    }
}
