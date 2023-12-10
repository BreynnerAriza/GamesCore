package com.gamescore.util;

import com.gamescore.domain.User;
import com.gamescore.model.AuthModel;
import com.gamescore.vendor.Encrypt;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AuthModel authModel = new AuthModel();

        User user = new User("MoeruTsuky", "123");
        authModel.register(user);
    }

    public static void pruebaLogin(){
        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("gamescore");
        MongoCollection<Document> collection = mongoDatabase.getCollection("users");

        Document document = new Document();
        document.put("userName","MoeruTsuky");
        document.put("password", Encrypt.encriptar("123456"));

        collection.insertOne(document);


        AuthModel authModel = new AuthModel();
        User user = authModel.login(new User("MoeruTsuky","123456"));

        if(user != null){
            System.out.println("user = " + user);
            System.out.println("Datos correctos");
        }else{
            System.out.println("Datos incorrectos");
        }
    }
}
