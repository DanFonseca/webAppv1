package br.com.webApp.servletpt1.servlets;
import br.com.webApp.servletpt1.classes.exceptions.excpetions;
import br.com.webApp.servletpt1.classes.BD;
import br.com.webApp.servletpt1.classes.Nome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(urlPatterns = "/cadastrarNome")
public class cadastrarNome extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nomeParam = req.getParameter("nome");
        String Sdata = req.getParameter("data");
        String sindex = req.getParameter("index");

        BD bd = new BD();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fdata;

        try {
            fdata = formato.parse(Sdata);
        } catch (ParseException e) {
            throw new excpetions("erro ao converter a data");

        }

        System.out.println(sindex);
        if(sindex != null){
            int index = Integer.parseInt(sindex);
            bd.editarNome(index, nomeParam, fdata);
        }else{
            Nome nome = new Nome (nomeParam, fdata);
            bd.adicionarNaLista(nome);
        }

        resp.sendRedirect("listarNomes");
    }

}
