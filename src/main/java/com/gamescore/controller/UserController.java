package com.gamescore.controller;

import com.gamescore.domain.User;
import com.gamescore.domain.VideogameAcquired;
import com.gamescore.model.UserModel;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

    private final UserModel userModel = new UserModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response){

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response){
        String accion = request.getParameter("action");
        switch (accion){
            case "TerminarCompra":
                comprarCarrito(request, response);
                break;
        }
    }

    private void comprarCarrito(HttpServletRequest request, HttpServletResponse response) {
        JSONObject respuesta = new JSONObject();

        ArrayList<ObjectId> trolley = (ArrayList<ObjectId>) request.getSession().getAttribute("deseos");
        User user = (User) request.getSession().getAttribute("user");

        VideogameAcquired videogameAcquired[] = new VideogameAcquired[trolley.size()];
        for (int i = 0; i < trolley.size(); i++) {
            videogameAcquired[i] = new VideogameAcquired(trolley.get(i), LocalDate.now());
        }


        User bd = userModel.buyVideoGames(user, videogameAcquired);
        request.getSession().setAttribute("user", bd);
        request.getSession().setAttribute("count", 0);

        respuesta.put("message", "Añadido al carrito");
        respuesta.put("url", request.getContextPath() + "/FrontController?path=VideoGame&action=Listar");

        enviarRespuesta(response, respuesta);
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
