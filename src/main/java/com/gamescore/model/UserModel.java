package com.gamescore.model;

import com.gamescore.domain.User;
import com.gamescore.domain.VideogameAcquired;
import com.gamescore.util.Conexion;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserModel {

    private MongoClient conexion = Conexion.getConnection();
    private MongoDatabase database = conexion.getDatabase("gamescore");
    private MongoCollection<Document> collection = database.getCollection("users");
    private final Gson gson = new Gson();

    public User findById(User user) {
        System.out.println("a");
        Document filter = new Document("_id", user.get_id());
        Document documentBd = collection.find(filter).first();
        User bd = gson.fromJson(documentBd.toJson(), User.class);
        bd.set_id(user.get_id());
        System.out.println("bd = " + bd);
        return bd;
    }

    public User buyVideoGames(User user, VideogameAcquired videogameAcquired []) {

        Document filter = new Document("_id", user.get_id());
        Document bdDocument = collection.find(filter).first();

        User bd = gson.fromJson(bdDocument.toJson(), User.class);

        VideogameAcquired actualizacion [] = null;

        if (bd.getVideogameAcquired() == null) {

            actualizacion = videogameAcquired;
            List<Document> documentos = new ArrayList<>();

            for (VideogameAcquired acquired : videogameAcquired) {
                Document acquiredD = new Document();
                acquiredD.put("videogame_id", acquired.getVideogame_id());
                acquiredD.put("adquisition_date", acquired.getAdquisition_date());
                documentos.add(acquiredD);
            }
            Document update = new Document("$push", new Document("videogameAcquired", new Document("$each", documentos)));
            collection.updateOne(filter, update); //Realizar actualizacion

        } else {
            int userL = user.getVideogameAcquired().length;
            int bdL = user.getVideogameAcquired().length;

            VideogameAcquired a [] = new VideogameAcquired[(userL + bdL)];
            a = Arrays.copyOf(user.getVideogameAcquired(), (userL + bdL));
            System.arraycopy(bd.getVideogameAcquired(), 0, a, userL, bdL);

            // Eliminar duplicados
            VideogameAcquired arraySinDuplicados [] = (VideogameAcquired[]) Arrays.stream(a).distinct().toArray();

            System.out.println("4");
            Document videgamesBuy = Document.parse(gson.toJson(arraySinDuplicados));
            System.out.println("5");
            Document update = new Document("$addToSet", new Document("videogameAcquired", new Document("$each", videgamesBuy)));
            System.out.println("6");
            collection.updateOne(filter, update); //Realizar actualizacion
            System.out.println("7");
        }

        return findById(user);
    }
}
