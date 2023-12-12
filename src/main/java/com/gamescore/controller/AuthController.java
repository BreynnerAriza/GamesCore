package com.gamescore.controller;

import com.gamescore.domain.User;
import com.gamescore.model.AuthModel;
import com.gamescore.vendor.Dates;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/AuthController")
public class AuthController extends HttpServlet {

    //Modelo
    private final AuthModel authModel = new AuthModel();
    private final Gson gson = new Gson();
    private final JSONParser jsonParser = new JSONParser();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("action");
        switch (accion) {
            case "Register":
                request.getRequestDispatcher("/assets/views/RegisterView.jsp").forward(request, response);
                break;
            case "Login":
                request.getRequestDispatcher("/assets/views/LoginView.jsp").forward(request, response);
                break;
            case "CerrarSesion":
                cerrarSesion(request, response);
                break;
        }
    }

    //Metodo para cerar una sesion
    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().removeAttribute("usuario");
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String accion = request.getParameter("action");
        System.out.println("Anda aqui");
        switch (accion) {
            case "Register":
                register(request, response);
                break;
            case "Login":
                loging(request, response);
                break;
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) {
        JSONObject respuesta = new JSONObject();
        User user = leerBody(request, response);
        if (user != null) {
            String registro = authModel.register(user); //Registrar al usuario
            if(registro.equals("registrado")){
                //Redireccionar y enviar respuesta
                respuesta.put("message", "Registro completado");
                respuesta.put("url", request.getContextPath() + "/assets/views/LoginView.jsp");
            }else{
                respuesta.put("fallos", registro);
            }
        }
        enviarRespuesta(response, respuesta);
    }

    //Metodo para validar el logueo de un usuario
    private void loging(HttpServletRequest request, HttpServletResponse response) {
        JSONObject respuesta = new JSONObject();
        User user = leerBody(request, response);
        if(user != null){
            User userBd = authModel.login(user);
            if (userBd != null) {
                request.getSession().setAttribute("user", userBd);
                respuesta.put("message", "Bienvenido " + userBd.getNick());
                respuesta.put("url", request.getContextPath() + "/index.jsp");
            }else{
                respuesta.put("fallos", "Credenciales incorrectas");
            }

        }
        enviarRespuesta(response, respuesta);
    }

    private User leerBody(HttpServletRequest request, HttpServletResponse response) {
        try {
            String body = request.getReader().readLine();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(body);
            return gson.fromJson(jsonObject.toJSONString(), User.class); //Retomar el usuario leido
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } catch (ParseException e) {
            e.printStackTrace(System.out);
        }
        return null;
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
