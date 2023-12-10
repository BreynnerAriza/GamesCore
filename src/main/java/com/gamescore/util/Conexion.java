package com.gamescore.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import javax.swing.*;

public class Conexion {

    //Constantes para realizar la conexion
    private final static String HOST = "localhost";
    private final static Integer PORT = 27017;

    public static MongoClient getConnection(){
        MongoClient mongoClient = null;
        try{
            mongoClient = new MongoClient(HOST, PORT);
        }catch (MongoException ex ){
            ex.printStackTrace(System.out);
            JOptionPane.showMessageDialog(null, "Error al realizar la conexion");
        }
        return mongoClient;
    }

}
