package br.com.webApp.servletpt1.servlets;

import br.com.webApp.servletpt1.modelo.BD;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/listarNomes")
public class listarNomes extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BD bd = new BD ();
        req.setAttribute("listNomes",  bd.getListNomes());

        RequestDispatcher rd = req.getRequestDispatcher("/listarNome.jsp");
        rd.forward(req, resp);
    }
}
