package br.com.webApp.servletpt1.modelo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class listarNome extends HttpServlet {

    public void listar (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BD bd = new BD ();
        req.setAttribute("listNomes",  bd.getListNomes());
        RequestDispatcher rd = req.getRequestDispatcher("/listarNome.jsp");
        rd.forward(req, resp);
    }
}
