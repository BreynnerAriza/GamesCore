package com.gamescore.model;

import com.gamescore.domain.Videogame;
import com.gamescore.util.Conexion;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class VideoGameModel {

    private MongoClient conexion = Conexion.getConnection();
    private MongoDatabase database = conexion.getDatabase("gamescore");
    private MongoCollection<Document> collection = database.getCollection("videogames");
    private final Gson gson = new Gson();

    public ArrayList<Videogame> find(int inicio, int ultimo){

        ArrayList<Videogame> videogames = new ArrayList<>();

        FindIterable<Document> videogamesDocument = collection.find().skip(inicio).limit(ultimo);
        for(Document videogame : videogamesDocument){
            Videogame videogameO = gson.fromJson(videogame.toJson(), Videogame.class);
            videogames.add(videogameO);
        }
        return videogames;
    }

    public Videogame findById(Videogame videogame){
        Document document = Document.parse(gson.toJson(videogame));
        Document videogameBd = collection.find(document).first();
        return videogame == null ? null : gson.fromJson(videogameBd.toJson(), Videogame.class);
    }

}
