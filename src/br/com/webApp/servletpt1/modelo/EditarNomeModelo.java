package br.com.webApp.servletpt1.modelo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditarNomeModelo extends HttpServlet {

    public void editar (HttpServletRequest req, HttpServletResponse resp, String sid) throws ServletException, IOException {

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
