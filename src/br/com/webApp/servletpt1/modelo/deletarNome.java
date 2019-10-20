package br.com.webApp.servletpt1.modelo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deletarNome extends HttpServlet {

    public void deletar (HttpServletRequest req, HttpServletResponse resp, String sId) throws IOException {

        int id = Integer.parseInt(sId);
        BD bd = new BD ();
        int index =  bd.getIndex(id);
        bd.deletaNome(index);
        System.out.println("deletou");

        resp.sendRedirect("controle?function=listar");
    }
}


