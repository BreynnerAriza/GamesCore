package com.gamescore.controller;

import com.gamescore.domain.Videogame;
import com.gamescore.model.VideoGameModel;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/VideoGameController")
public class VideoGameController extends HttpServlet {

    private final VideoGameModel videoGameModel = new VideoGameModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        String accion = request.getParameter("action");
        switch (accion){
            case "Listar":
                listar(request, response);
                break;
            case "Mostrar":
                mostrar(request, response);
                break;
            case "Buscar":
                buscar(request, response);
                break;
        }
    }

    private void buscar(HttpServletRequest request, HttpServletResponse response) {
        JSONObject respuesta = new JSONObject();
        String nombre = request.getParameter("name");
        ArrayList<Videogame> videogames = videoGameModel.findByName(new Videogame(nombre));
        try{
            request.setAttribute("videogames", videogames);
            request.getRequestDispatcher("/assets/views/StoreView.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    private void mostrar(HttpServletRequest request, HttpServletResponse response) {

        Object id = request.getParameter("VideoGameReq");

        Videogame videoGameReq = new Videogame(new ObjectId(id.toString()));
        Videogame videogameBd = videoGameModel.findById(videoGameReq);

        try {
            request.setAttribute("videoGame", videogameBd);
            request.getRequestDispatcher("/assets/views/VideoGameView.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }


    private void listar(HttpServletRequest request, HttpServletResponse response) {
        String n = request.getParameter("n");
        int indice = (n==null) ? 1 : Integer.parseInt(n);

        ArrayList<Videogame> videogames = videoGameModel.find(12 * (indice - 1), 12 * indice);

        try{
            request.setAttribute("videogames", videogames);
            request.getRequestDispatcher("/assets/views/StoreView.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
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
