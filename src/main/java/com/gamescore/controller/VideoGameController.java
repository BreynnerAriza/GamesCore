package com.gamescore.controller;

import com.gamescore.domain.Videogame;
import com.gamescore.model.VideoGameModel;

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
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }


    private void listar(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Videogame> videogames = videoGameModel.find(0, 12);
        try{
            request.setAttribute("videogames", videogames);
            request.getRequestDispatcher("/assets/views/StoreView.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

}