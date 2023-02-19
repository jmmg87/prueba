package com.adea.prueba.servicio;

import com.adea.prueba.dto.Login;
import com.adea.prueba.model.Usuario;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IRepository {

    public List<Usuario> mostrarUsuariosTipo(String status);
    public List<Usuario> mostrarUsuariosNombre(String nombre);
    public List<Usuario> mostrarUsuariosFecha(Date fechIni, Date fechFin);
    public Usuario buscarLogou(String logou);
}
