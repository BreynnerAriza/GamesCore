package com.gamescore.model;

import com.gamescore.domain.Videogame;
import com.gamescore.domain.VideogameAcquired;
import com.gamescore.util.Conexion;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

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
            videogameO.set_id(new ObjectId(videogame.get("_id").toString()));
            videogames.add(videogameO);
        }
        return videogames;
    }

    public Videogame findById(Videogame videogame){
        System.out.println("videogame = " + videogame);
        Document document = new Document();
        document.put("_id", videogame.get_id());

        Document videogameDoc = collection.find(document).first();
        Videogame videogameBd = gson.fromJson(videogameDoc.toJson(), Videogame.class);
        videogameBd.set_id(new ObjectId(videogameDoc.get("_id").toString()));

        return videogameBd;
    }


    public ArrayList<Videogame> findByName(Videogame videogame) {

        ArrayList<Videogame> videogames = new ArrayList<>();

        String nombre = videogame.getName();
        Document regexQuery = new Document("name", new Document("$regex", ".*" + nombre + ".*").append("$options", "i"));
        // Realizar la consulta y obtener los resultados
        for (Document document : collection.find(regexQuery)) {
            Videogame videogameO = gson.fromJson(document.toJson(), Videogame.class);
            videogameO.set_id(new ObjectId(document.get("_id").toString()));
            videogames.add(videogameO);
        }

        // Cerrar la conexión
        return videogames;
    }
}
