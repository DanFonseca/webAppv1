package br.com.webApp.servletpt1.servlets;

import br.com.webApp.servletpt1.classes.BD;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/editarNome")
public class editarNome extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        BD bd = new BD();
        int index = bd.getIndex(id);

        req.setAttribute("nome", bd.getListNomeByID(index).getNome());
        req.setAttribute("data", bd.getListNomeByID(index).getData());
        req.setAttribute("index", index);

        RequestDispatcher rd = req.getRequestDispatcher("editarNome.jsp");
        rd.forward(req, resp);
    }
}
