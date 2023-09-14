package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;


import java.util.List;

@Stateless(name = "usuarioService")
public class UsuarioService {
    @EJB
    private UsuarioDAO usuarioDAO;

    public void inserir(long id, String nome) {
        Usuario novoUsuario = new Usuario(id, nome);
        usuarioDAO.inserir(novoUsuario);
        if (id==3L) {
            throw new RuntimeException("Menor de idade não permitido!");
        }
        if (id == 4L) {
            novoUsuario.setNome(nome + " alterado");
        }
    }


    public List<Usuario> listar() {
        return this.usuarioDAO.listar();
    }
}
