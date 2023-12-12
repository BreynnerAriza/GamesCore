package com.gamescore.controller;

import com.gamescore.domain.Videogame;
import com.gamescore.model.VideoGameModel;
import com.google.gson.Gson;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet("/TrolleyController")
public class TrolleyController extends HttpServlet {

    private final ArrayList<Videogame> videogames = new ArrayList<>();
    private final ArrayList<ObjectId> trolley = new ArrayList<>();
    private final VideoGameModel videoGameModel = new VideoGameModel();
    private final Gson gson = new Gson();
    private final JSONParser jsonParser = new JSONParser();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String accion = request.getParameter("action");
        switch (accion) {
            case "Listar":
                listar(request, response);
                break;
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("count", trolley.size());
        request.getSession().setAttribute("trolley", videogames);
        try {

            request.getRequestDispatcher("/assets/views/TrolleyView.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String accion = request.getParameter("action");
        switch (accion) {
            case "Add":
                agregar(request, response);
                break;
        }
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response) {
        ObjectId _id = leerBody(request, response);
        JSONObject respuesta = new JSONObject();
        if (trolley.contains(_id)) {
            respuesta.put("fallos", "El juego ya se encuentra en el carrito");
        } else {
            trolley.add(_id);
            videogames.add(videoGameModel.findById(new Videogame(_id)));
            actualizarTotal(request);

            respuesta.put("message", "Añadido al carrito");
            respuesta.put("url", request.getContextPath() + "/FrontController?path=VideoGame&action=Listar");
            request.getSession().setAttribute("countTrolley", trolley.size());
        }
        enviarRespuesta(response, respuesta);
    }


    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response){

        System.out.println("lLENGADO");
        String accion = request.getParameter("action");
        String id = request.getParameter("VideoGameReq");
        ObjectId _id = new ObjectId(id);

        JSONObject respuesta = new JSONObject();

        if(trolley.remove(_id)){
            Videogame videogameBd = videoGameModel.findById(new Videogame(_id));
            videogames.remove(videogameBd);
            actualizarTotal(request);

            respuesta.put("message", "Eliminado del carrito");
            respuesta.put("url", request.getContextPath() + "/FrontController?path=Trolley&action=Listar");
            request.getSession().setAttribute("countTrolley", trolley.size());
        }else{
            respuesta.put("fallos", "No se pudo eliminar del carrito");
        }

        enviarRespuesta(response, respuesta);
    }


    private ObjectId leerBody(HttpServletRequest request, HttpServletResponse response) {
        ObjectId id = null;
        try {
            String body = request.getReader().readLine();
            JSONObject _id = (JSONObject) jsonParser.parse(body);
            id = new ObjectId(_id.get("_id").toString());
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } catch (ParseException e) {
            e.printStackTrace(System.out);
        }
        return id;
    }



    /*--------------------------------------------------------------------------------------*/
    private void enviarRespuesta(HttpServletResponse response, JSONObject respuesta) {
        try {
            response.setContentType("application/json");
            response.getWriter().print(respuesta.toJSONString());
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private void actualizarTotal(HttpServletRequest request){
        AtomicReference<Double> a = new AtomicReference<>((double) 0);
        for (Videogame videogame : videogames) {
            a.updateAndGet(currentValue -> currentValue + videogame.getPrice());
        }
       request.getSession().setAttribute("total", a.get());
    }

}
