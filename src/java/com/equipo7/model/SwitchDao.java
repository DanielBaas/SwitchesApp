package com.equipo7.model;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SwitchDao {
    
    final String URL = "jdbc:mysql://localhost/CiscoSwitches";
    final String USERNAME = "root";
    final String PASSWORD = "cisco";
    
    public void insertSwitch(SwitchCisco switchCisco) {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(URL, USERNAME, PASSWORD);
            Dao<SwitchCisco, String> dao = DaoManager.createDao(connectionSource, SwitchCisco.class);
            
            dao.create(switchCisco);
            connectionSource.close();
        } catch (SQLException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertInterface(SwitchInterface switchInterface) {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(URL, USERNAME, PASSWORD);
            Dao<SwitchInterface, String> dao = DaoManager.createDao(connectionSource, SwitchInterface.class);
            
            dao.create(switchInterface);
            connectionSource.close();
        } catch (SQLException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateSwitch(SwitchCisco switchCisco) {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(URL, USERNAME, PASSWORD);
            Dao<SwitchCisco, String> dao = DaoManager.createDao(connectionSource, SwitchCisco.class);
            
            UpdateBuilder<SwitchCisco, String> updateBuilder = dao.updateBuilder();
            
            updateBuilder.updateColumnValue("user", switchCisco.getUser());
            updateBuilder.updateColumnValue("host", switchCisco.getHost());
            updateBuilder.updateColumnValue("port", switchCisco.getPort());
            updateBuilder.updateColumnValue("pass", switchCisco.getPass());
            updateBuilder.updateColumnValue("software", switchCisco.getSoftware());
            updateBuilder.updateColumnValue("version", switchCisco.getVersion());
            updateBuilder.updateColumnValue("isAvailable", switchCisco.isAvailable());
            
            updateBuilder.where().eq("pk", switchCisco.getPk());
            updateBuilder.update();
        } catch (SQLException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateInterface(SwitchInterface switchInterface) {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(URL, USERNAME, PASSWORD);
            Dao<SwitchInterface, String> dao = DaoManager.createDao(connectionSource, SwitchInterface.class);
            
            UpdateBuilder<SwitchInterface, String> updateBuilder = dao.updateBuilder();
            
            updateBuilder.updateColumnValue("interfaceType", switchInterface.getInterfaceType());
            updateBuilder.updateColumnValue("ip", switchInterface.getIp());
            updateBuilder.updateColumnValue("okStatus", switchInterface.getOkStatus());
            updateBuilder.updateColumnValue("method", switchInterface.getMethod());
            updateBuilder.updateColumnValue("status", switchInterface.getStatus());
            updateBuilder.updateColumnValue("protocol", switchInterface.getProtocol());
            updateBuilder.updateColumnValue("switchCisco", switchInterface.getSwitchCisco());
            
            updateBuilder.where().eq("pk", switchInterface.getPk());
            updateBuilder.update();
        } catch (SQLException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public SwitchCisco findSwitchByIP(String ip) {
        final String FIELD_NAME = "host";
        int id = -1;
        SwitchCisco switchCisco = new SwitchCisco();
        
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(URL, USERNAME, PASSWORD);
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
    
    public List<SwitchCisco> getAllSwitches() {
        List<SwitchCisco> switches = new ArrayList<SwitchCisco>();
        
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(URL, USERNAME, PASSWORD);
            Dao<SwitchCisco, String> dao = DaoManager.createDao(connectionSource, SwitchCisco.class);
            
            QueryBuilder<SwitchCisco, String> queryBuilder = dao.queryBuilder();
            
            
            PreparedQuery<SwitchCisco> preparedQuery = queryBuilder.prepare();
            
            if (!dao.query(preparedQuery).isEmpty()) {
                switches = dao.queryForAll();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return switches;
    }
    
    public SwitchCisco findSwitchByID(int id) {
        final String FIELD_NAME = "pk";
        SwitchCisco switchCisco = new SwitchCisco();
        
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(URL, USERNAME, PASSWORD);
            Dao<SwitchCisco, String> dao = DaoManager.createDao(connectionSource, SwitchCisco.class);
            
            QueryBuilder<SwitchCisco, String> queryBuilder = dao.queryBuilder();
            
            queryBuilder.where().eq(FIELD_NAME, id);
            
            PreparedQuery<SwitchCisco> preparedQuery = queryBuilder.prepare();
            
            if (!dao.query(preparedQuery).isEmpty()) {
                switchCisco = dao.query(preparedQuery).get(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return switchCisco;
    }
    
    public List<SwitchInterface> findInterfacesBySwitchID(int switchCiscoId) {
        final String FIELD_NAME = "switchCisco";
        int id = -1;
        List<SwitchInterface> switchInterface = new ArrayList<SwitchInterface>();
        
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(URL, USERNAME, PASSWORD);
            Dao<SwitchInterface, String> dao = DaoManager.createDao(connectionSource, SwitchInterface.class);
            
            QueryBuilder<SwitchInterface, String> queryBuilder = dao.queryBuilder();
            
            queryBuilder.where().eq(FIELD_NAME, switchCiscoId);
            
            PreparedQuery<SwitchInterface> preparedQuery = queryBuilder.prepare();
            
            if (!dao.query(preparedQuery).isEmpty()) {
                switchInterface = dao.query(preparedQuery);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return switchInterface;
    }
    
    public void deleteSwitch(SwitchCisco switchCisco) {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(URL, USERNAME, PASSWORD);
            Dao<SwitchCisco, String> dao = DaoManager.createDao(connectionSource, SwitchCisco.class);
            DeleteBuilder<SwitchCisco, String> deleteBuilder = dao.deleteBuilder();
            
            deleteInterfaceBySwitch(switchCisco);
            
            deleteBuilder.where().eq("pk", switchCisco.getPk());
            deleteBuilder.delete();
        } catch (SQLException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteInterfaceBySwitch(SwitchCisco switchCisco) {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(URL, USERNAME, PASSWORD);
            Dao<SwitchInterface, String> dao = DaoManager.createDao(connectionSource, SwitchInterface.class);
            DeleteBuilder<SwitchInterface, String> deleteBuilder = dao.deleteBuilder();
            
            deleteBuilder.where().eq("pk", switchCisco.getPk());
            deleteBuilder.delete();
        } catch (SQLException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteInterfaceByID(SwitchInterface switchInterface) {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(URL, USERNAME, PASSWORD);
            Dao<SwitchInterface, String> dao = DaoManager.createDao(connectionSource, SwitchInterface.class);
            DeleteBuilder<SwitchInterface, String> deleteBuilder = dao.deleteBuilder();
            
            deleteBuilder.where().eq("pk", switchInterface.getPk());
            deleteBuilder.delete();
        } catch (SQLException ex) {
            Logger.getLogger(SwitchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
