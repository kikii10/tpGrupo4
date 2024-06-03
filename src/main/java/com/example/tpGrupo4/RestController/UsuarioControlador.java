package com.example.tpGrupo4.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.tpGrupo4.model.Usuario;
import com.example.tpGrupo4.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private IUsuarioService usuarioSer;

    @PostMapping("/new")
    public void agregarUsuario(@RequestBody Usuario usuario) {
        usuarioSer.crearUsuario(usuario);
    }

    @GetMapping("/mostrar")
    @ResponseBody
    public List<Usuario> verUsuarios() {
        return usuarioSer.verUsuarios();
    }

    @GetMapping("/getById/{id}")
    public Usuario buscarUsuario(@PathVariable Long id) {
        return usuarioSer.buscarUsuario(id);
    }

    @PutMapping("/update/{id}")
    public void actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuarioSer.modificarUsuario(id, usuario);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioSer.borrarUsuario(id);
    }
}
