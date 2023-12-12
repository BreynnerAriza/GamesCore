package com.gamescore.model;

import com.gamescore.domain.User;
import com.gamescore.domain.VideogameAcquired;
import com.gamescore.util.Conexion;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonObjectId;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.util.*;


public class UserModel {

    private MongoClient conexion = Conexion.getConnection();
    private MongoDatabase database = conexion.getDatabase("gamescore");
    private MongoCollection<Document> collection = database.getCollection("users");
    private final Gson gson = new Gson();

    public User findById(User user) {
        Document filter = new Document("_id", user.get_id());

        Document documentBd = collection.find(filter).first();
        User bd = gson.fromJson(documentBd.toJson(), User.class);

        bd.set_id(user.get_id());
        return bd;
    }

    public User buyVideoGames(User user, VideogameAcquired videogameAcquired []) {

        Document filter = new Document("_id", user.get_id());
        Document bdDocument = collection.find(filter).first();

        User bd = gson.fromJson(bdDocument.toJson(), User.class);
        VideogameAcquired actualizacion [] = null;


        if (bd.getVideogameAcquired() == null) {
            actualizacion = videogameAcquired;
        } else {
            String bdList = bdDocument.toJson();

            JSONParser parser = new JSONParser();
            JSONObject j = null;

            try {
                j = (JSONObject) parser.parse(bdList);
            } catch (ParseException e) {
                e.printStackTrace(System.out);
            }

            // Crear un objeto JsonObject a partir del JSON de entrada
            JsonObject jsonObject = JsonParser.parseString(j.toJSONString()).getAsJsonObject();
            // Obtener el array de edades del JsonObject
            JsonArray arrays = jsonObject.getAsJsonArray("videogameAcquired");

            VideogameAcquired b [] = new VideogameAcquired[arrays.size()];

            // Recorrer el JsonArray
            for (int i = 0; i < arrays.size(); i++) {
                // Obtener el objeto en la posición i
                JsonObject objectIdObjeto = arrays.get(i).getAsJsonObject();
                // Obtener el valor del ObjectId como String
                String objectIdAsString = objectIdObjeto.getAsJsonObject("videogame_id").getAsJsonPrimitive("$oid").getAsString();
                // Crear un BsonObjectId a partir del String
                b[i] = new VideogameAcquired(new ObjectId(objectIdAsString));
            }

            int userL = user.getVideogameAcquired().length;
            int bdL = user.getVideogameAcquired().length;

            VideogameAcquired a [] = new VideogameAcquired[userL + bdL];

            System.arraycopy(b, 0, a, 0, b.length);
            System.arraycopy(videogameAcquired, 0, a, b.length, videogameAcquired.length);

            Map<ObjectId, VideogameAcquired> duplicados = new HashMap();
            for(VideogameAcquired acquired : a){
                if(!esta(b, acquired.getVideogame_id())){
                    duplicados.put(acquired.getVideogame_id(), acquired);
                }

            }

            actualizacion = new VideogameAcquired[duplicados.size()];
            int i = 0;
            for (Map.Entry<ObjectId, VideogameAcquired> entrada : duplicados.entrySet()) {
                actualizacion[i] = entrada.getValue();
                i++;
            }
        }

        List<Document> documentos = new ArrayList<>();
        for (VideogameAcquired acquired : actualizacion) {
            Document acquiredD = new Document();
            acquiredD.put("videogame_id", acquired.getVideogame_id());
            acquiredD.put("adquisition_date", acquired.getAdquisition_date());
            documentos.add(acquiredD);
        }

        Document update = new Document("$push", new Document("videogameAcquired", new Document("$each", documentos)));
        collection.updateOne(filter, update); //Realizar actualizacion
        return findById(user);
    }

    private boolean esta(VideogameAcquired v [], ObjectId id){
        for (VideogameAcquired videogameAcquired : v){
            if(videogameAcquired.getVideogame_id().equals(id)){
                return true;
            }
        }
        return false;
    }
}
