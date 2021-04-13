package com.fp.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

public class DatabaseConnection {
	private static final Logger logger = Logger.getLogger(DatabaseConnection.class);
	
	
    // init connection object
    private Connection connection;
    // init properties object
    private Properties properties;
    
    Properties config = new Properties();

    InputStream configInput = null;
    
    
    
    public void loadConfig(){
        try{
            configInput = new FileInputStream("target/XuntaAyudas/WEB-INF/classes/config.properties");
            config.load(configInput);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error cargando configuración\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
//    protected void loadProperties(String ruta) {
//
//		InputStream in = null;
//
//		
//		try {
//
//			//String mruta = System.getProperty(APP_CONFIG_FILE_KEY, ruta);
//			//logger.info("mruta: " + mruta);
//			String mruta= ruta;
//
//			File jarPath = new File(Configuration.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//			String jarDirectory = jarPath.getParent();
//			logger.info(" propertiesPath- jarDirectory" + jarDirectory);
//
//			String fs = File.separator;
//
//			logger.info("File.Separator: " + fs);
//
//			String sepMruta = fs + mruta;
//
//			if (new File(jarPath + sepMruta).exists()) {
//				logger.info(" load properties from: " + jarPath + sepMruta);
//				in = new FileInputStream(jarPath + sepMruta);
//			} else if (new File(jarDirectory + sepMruta).exists()) {
//				logger.info(" load properties from ext dir: " + jarDirectory + sepMruta);
//				in = new FileInputStream(jarDirectory + sepMruta);
//			} else {
//				logger.info(" load properties from class loader: " + mruta);
//				in = Configuration.class.getClassLoader().getResourceAsStream(mruta);
//			}
//
//			config.load(in);
//
//		} catch (Exception e) {
//			logger.error("Error leyendo ficero propiedades <" + ruta + ">", e);
//			//TODO throw--- 
//
//		} finally {
//			if (in != null) {
//				try {
//					in.close();
//				} catch (IOException e) {
//					logger.error("Error cerrando fichero propiedades <" + ruta + ">", e);
//					//TODO throw
//				}
//			}
//		}
//	}
    
    // connect database
    public Connection connect() {
    	loadConfig();
    	//loadProperties("/XuntaAyudas/target");
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(config.getProperty("DATABASE_URL"),config.getProperty("USERNAME"),config.getProperty("PASSWORD"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}