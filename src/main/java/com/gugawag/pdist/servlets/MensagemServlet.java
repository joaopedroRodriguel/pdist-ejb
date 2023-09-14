package com.gugawag.pdist.servlets;

import com.gugawag.pdist.ejb.session.MensagemService;
import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/mensagem.do"})
public class MensagemServlet extends javax.servlet.http.HttpServlet {

    @EJB(lookup="java:module/mensagemService")
    private MensagemService mensagemService;

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String operacao = request.getParameter("oper");
        PrintWriter resposta = response.getWriter();
        switch (operacao) {
            case "1": {
                long id = Integer.parseInt(request.getParameter("id"));
                String mensagem = request.getParameter("mensagem");
                mensagemService.inserir(id, mensagem);
            }
            case "2": {
                for(Mensagem mensagem: mensagemService.listar()){
                    resposta.println(mensagem.getTexto());
                }
                break;
            }
            case "3": {
                String id = request.getParameter("id");
                resposta.println(mensagemService.buscarById(Long.parseLong(id)).getTexto());
                break;
            }

        }
    }
}
