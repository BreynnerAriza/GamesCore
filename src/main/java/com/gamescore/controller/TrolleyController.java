package com.gamescore.controller;

import com.gamescore.domain.Videogame;
import com.gamescore.model.VideoGameModel;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/TrolleyController")
public class TrolleyController extends HttpServlet {

    private final ArrayList<ObjectId> trolley = new ArrayList<>();
    private final VideoGameModel videoGameModel = new VideoGameModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        String accion = request.getParameter("action");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String accion = request.getParameter("action");
        switch (accion){
            case "Add":
                agregar(request, response);
                break;
        }
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response) {
        ObjectId _id = leerBody(request, response);
        JSONObject respuesta = new JSONObject();
        if (trolley.contains(_id)){
            respuesta.put("fallos", "El juego ya se encuentra en el carrito");
        }else{
            respuesta.put("message", "Añadido al carrito");
            respuesta.put("count", trolley.size());
        }
        enviarRespuesta(response, respuesta);
    }

    private ObjectId leerBody(HttpServletRequest request, HttpServletResponse response){
        ObjectId id = null;
        try {
            String body = request.getReader().readLine();
            id = new ObjectId(body);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return id;
    }

    private void enviarRespuesta(HttpServletResponse response, JSONObject respuesta){
        try {
            response.setContentType("application/json");
            response.getWriter().print(respuesta.toJSONString());
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

}
