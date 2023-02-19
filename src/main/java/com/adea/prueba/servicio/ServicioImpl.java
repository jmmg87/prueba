package com.adea.prueba.servicio;

import com.adea.prueba.dto.UsuarioDto;
import com.adea.prueba.model.Usuario;
import com.adea.prueba.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class ServicioImpl implements IServicio{


    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @PersistenceContext
    private EntityManager entityManager;

    public ServicioImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Usuario guardar(UsuarioDto registrar) {
        Usuario user = new Usuario(registrar.getLogin(),registrar.getPassword(),
                                    registrar.getNombre(), registrar.getCliente(),
                                        registrar.getEmail(),registrar.getFechaAlta(),registrar.getFechaBaja(),
                                        registrar.getStatus(),registrar.getIntentos(),registrar.getFechaRevocada(),
                                        registrar.getFechaVigencia(),registrar.getNoAcceso(),registrar.getApellidoPaterno(),
                                        registrar.getApellidoMterno(), registrar.getArea(),registrar.getFechaModificacion());
        return usuarioRepositorio.save(user);
    }

    @Override
    public Usuario editar(UsuarioDto registrar) {
        Usuario usu = new Usuario(registrar.getId(),registrar.getLogin(),registrar.getPassword(),
                registrar.getNombre(), registrar.getCliente(),
                registrar.getEmail(),registrar.getFechaAlta(),registrar.getFechaBaja(),
                registrar.getStatus(),registrar.getIntentos(),registrar.getFechaRevocada(),
                registrar.getFechaVigencia(),registrar.getNoAcceso(),registrar.getApellidoPaterno(),
                registrar.getApellidoMterno(), registrar.getArea(),registrar.getFechaModificacion());
        return usuarioRepositorio.save(usu);
    }

    @Override
    public List<Usuario> mostrarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepositorio.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(long id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }
}
