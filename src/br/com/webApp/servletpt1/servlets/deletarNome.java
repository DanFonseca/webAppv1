package br.com.webApp.servletpt1.servlets;

import br.com.webApp.servletpt1.modelo.BD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deletaNome")
public class deletarNome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId = req.getParameter("id");
        int id = Integer.parseInt(sId);
        BD bd = new BD ();
        int index =  bd.getIndex(id);
        bd.deletaNome(index);
        resp.sendRedirect("listarNomes");
    }
}
