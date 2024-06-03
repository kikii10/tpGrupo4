package com.example.tpGrupo4.service;

import java.util.List;
import com.example.tpGrupo4.model.Usuario;

public interface IUsuarioService {
    List<Usuario> verUsuarios();
    void crearUsuario(Usuario usuario);
    void borrarUsuario(Long id);
    Usuario buscarUsuario(Long id);
    void modificarUsuario(Long id, Usuario usuario);
}