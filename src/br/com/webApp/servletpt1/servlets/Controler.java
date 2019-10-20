package br.com.webApp.servletpt1.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.webApp.servletpt1.modelo.*;

@WebServlet(urlPatterns = "/controle")

public class Controler extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //recebe a requisicao dos jsps
        String param = req.getParameter("function");
        String id = req.getParameter("id");


        if (param.equals("listar")){
            listarNome le = new listarNome();
            le.listar(req, resp);
        }else if (param.equals("cadastrar")){
            cadastrarNome cadastrar = new cadastrarNome();
            cadastrar.cadastrar(req,resp);

        }else if(param.equals("deletar") && id != null){
            deletarNome deletar = new deletarNome();
            deletar.deletar(req,resp, id);
        }else if (param.equals("editar") && id != null){
            EditarNomeModelo editar = new EditarNomeModelo();
            editar.editar(req, resp, id);
        }else {
            PrintWriter out = resp.getWriter();
            out.println("<html><body><h1>Ops deu errado"
            + "id value: " + id
            + "function value: " + param +
                    "</html></body></h1>");
        }


    }
}
