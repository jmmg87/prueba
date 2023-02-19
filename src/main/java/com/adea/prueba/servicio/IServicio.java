package com.adea.prueba.servicio;

import com.adea.prueba.dto.UsuarioDto;
import com.adea.prueba.model.Usuario;

import java.util.List;

public interface IServicio {

    public Usuario guardar(UsuarioDto registrar);
    public Usuario editar(UsuarioDto registrar);
    public List<Usuario> mostrarUsuarios();
    public void eliminar(Long id);
    public Usuario buscarUsuario(long id);

}
