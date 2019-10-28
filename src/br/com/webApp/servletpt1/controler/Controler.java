package br.com.webApp.servletpt1.controler;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.com.webApp.servletpt1.controler.*;

@WebServlet(urlPatterns = "/controle")

public class Controler extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //recebe a requisicao dos jsps
        String param = req.getParameter("function");
        String endereco = "";

        try {
            Class cl = Class.forName("br.com.webApp.servletpt1.controler." + param);
            Acao acao = (Acao) cl.newInstance();
            endereco =  acao.executa(req, resp);
        }catch (Throwable e){
            System.out.println(e);
        }

        String enderecoSplit [] = endereco.split(":");

        if(enderecoSplit[0].equals("forward")){
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/" + enderecoSplit[1]);
            rd.forward(req, resp);
        }else if (enderecoSplit[0].equals("redirect")){
            resp.sendRedirect(enderecoSplit[1]);
        }
    }
}
