package br.com.webApp.servletpt1.modelo;

import br.com.webApp.servletpt1.exceptions.excpetions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class cadastrarNome extends HttpServlet {

    public void cadastrar (HttpServletRequest req, HttpServletResponse resp) throws IOException {

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
            resp.sendRedirect("controle?function=listar");
        }

}
