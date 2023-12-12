package com.gamescore.model;

import com.gamescore.domain.User;
import com.gamescore.domain.VideogameAcquired;
import com.gamescore.util.Conexion;
import com.gamescore.vendor.Encrypt;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AuthModel {

    private MongoClient conexion = Conexion.getConnection();
    private MongoDatabase database = conexion.getDatabase("gamescore");
    private MongoCollection<Document> collection = database.getCollection("users");
    private final Gson gson = new Gson();

    public User login(User user) {
        User userBd = null;

        //Crear el documento
        user.setPassword(Encrypt.encriptar(user.getPassword()));
        Document userDocument = Document.parse(gson.toJson(user));

        //Crear la consulta
        Document userLogin = collection.find(Filters.and(userDocument)).first();

        if (userLogin != null) {
            userBd = gson.fromJson(userLogin.toJson(), User.class);
            userBd.set_id(new ObjectId(userLogin.get("_id").toString()));
            asingarLibreria(userBd, userLogin);
        }
        return userBd; //Retornar lo encontrado
    }

    private void asingarLibreria(User user, Document document) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject j = (JSONObject) parser.parse(document.toJson());
            JsonObject jsonObject = JsonParser.parseString(j.toJSONString()).getAsJsonObject();
            JsonArray arrays = jsonObject.getAsJsonArray("videogameAcquired");

            if(arrays != null){
                System.out.println("entro");
                VideogameAcquired b[] = new VideogameAcquired[arrays.size()];
                // Recorrer el JsonArray
                for (int i = 0; i < arrays.size(); i++) {
                    // Obtener el objeto en la posición i
                    JsonObject objectIdObjeto = arrays.get(i).getAsJsonObject();
                    // Obtener el valor del ObjectId como String
                    String objectIdAsString = objectIdObjeto.getAsJsonObject("videogame_id").getAsJsonPrimitive("$oid").getAsString();
                    // Crear un BsonObjectId a partir del String
                    b[i] = new VideogameAcquired(new ObjectId(objectIdAsString));
                }
                user.setVideogameAcquired(b);
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    //Metodo para registrar
    public String register(User user) {
        user.setPassword(Encrypt.encriptar(user.getPassword()));
        String v = validarUnicos("nick", user.getNick());
        if (v.equals("libre")) {
            v = validarUnicos("email", user.getEmail());
            if (v.equals("libre")) {
                Document userDocument = Document.parse(gson.toJson(user));
                collection.insertOne(userDocument);
                return "registrado";
            } else {
                return v;
            }
        } else {
            return v;
        }
    }

    private String validarUnicos(String dato, String valor) {
        Document document = new Document(dato, valor);
        Long count = collection.countDocuments(document);
        return count > 0 ? "El " + dato + " es usado por otro usuario" : "libre";
    }

}
