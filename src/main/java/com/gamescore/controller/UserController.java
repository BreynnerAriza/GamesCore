package com.gamescore.controller;

import com.gamescore.domain.User;
import com.gamescore.domain.Videogame;
import com.gamescore.domain.VideogameAcquired;
import com.gamescore.model.UserModel;
import com.gamescore.model.VideoGameModel;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
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
    private final VideoGameModel videoGameModel = new VideoGameModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String accion = request.getParameter("action");
        switch (accion) {
            case "Profile":
                verPerfil(request, response);
                break;
        }
    }

    private void verPerfil(HttpServletRequest request, HttpServletResponse response) {
        Object u = request.getSession().getAttribute("user");
        if (u != null) {

            User user = (User) request.getSession().getAttribute("user");
            VideogameAcquired videogameAcquired[] = user.getVideogameAcquired();

            ArrayList<Videogame> videogames = new ArrayList<>();
            for (VideogameAcquired v : videogameAcquired) {
                System.out.println(v.getVideogame_id());
                videogames.add(videoGameModel.findById(new Videogame(v.getVideogame_id())));
            }

            try {
                request.setAttribute("library", videogames);
                request.getRequestDispatcher("/assets/views/ProfileView.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace(System.out);
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        } else {
            try {
                request.getRequestDispatcher("/assets/views/LoginView.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace(System.out);
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        String accion = request.getParameter("action");
        switch (accion) {
            case "TerminarCompra":
                comprarCarrito(request, response);
                break;
        }
    }

    private void comprarCarrito(HttpServletRequest request, HttpServletResponse response) {
        Object u = request.getSession().getAttribute("user");
        JSONObject respuesta = new JSONObject();
        if (u != null) {

            ArrayList<ObjectId> trolley = (ArrayList<ObjectId>) request.getSession().getAttribute("deseos");
            ArrayList<ObjectId> videogames = (ArrayList<ObjectId>) request.getSession().getAttribute("trolley");
            User user = (User) request.getSession().getAttribute("user");

            VideogameAcquired videogameAcquired[] = new VideogameAcquired[trolley.size()];
            for (int i = 0; i < trolley.size(); i++) {
                System.out.println(trolley.get(i).toString());
                videogameAcquired[i] = new VideogameAcquired(trolley.get(i), LocalDate.now());
            }

            User bd = userModel.buyVideoGames(user, videogameAcquired);
            request.getSession().setAttribute("user", bd);
            request.getSession().setAttribute("countTrolley", 0);
            videogames.clear();
            trolley.clear();

            respuesta.put("message", "Añadido al carrito");
            respuesta.put("url", request.getContextPath() + "/FrontController?path=VideoGame&action=Listar");

            enviarRespuesta(response, respuesta);
        } else {
            respuesta.put("message", "Login necesario");
            respuesta.put("url", request.getContextPath() + "/FrontController?path=Auth&action=Login");
        }
        enviarRespuesta(response, respuesta);
    }


    private void enviarRespuesta(HttpServletResponse response, JSONObject respuesta) {
        try {
            response.setContentType("application/json");
            response.getWriter().print(respuesta.toJSONString());
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

}
