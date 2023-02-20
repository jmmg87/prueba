package com.adea.prueba.servicio;

import com.adea.prueba.model.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class IRepositoryImpl implements IRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Usuario> mostrarUsuariosTipo(String status) {
        String query = "FROM Usuario WHERE status = :status";
        List<Usuario> listUsuario = entityManager.createQuery(query)
                .setParameter("status",status).getResultList();
        return listUsuario;
    }

    @Override
    public List<Usuario> mostrarUsuariosNombre(String nombre) {
        String query = "FROM Usuario WHERE nombre = :nombre";
        List<Usuario> listUsuario = entityManager.createQuery(query)
                .setParameter("nombre",nombre).getResultList();
        return listUsuario;
    }

    @Override
    public List<Usuario> mostrarUsuariosFecha(Date ini, Date fin)  {
        String query = "FROM Usuario WHERE fechaAlta BETWEEN :ini AND :fin";
        List<Usuario> listUsuario = entityManager.createQuery(query)
                .setParameter("ini",ini)
                .setParameter("fin",fin).getResultList();
        return listUsuario;
    }

    @Override
    public Usuario buscarLogou(String logou) {
        String query = "FROM Usuario WHERE login = :login ";
        Usuario usu = new Usuario();
        List <Usuario> lista = entityManager.createQuery(query).
                setParameter("login",logou).getResultList();
        if(lista.size() > 0){
            usu = lista.get(0);
            return usu;
        }
        return null;
    }
}
