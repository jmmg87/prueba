package com.adea.prueba.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UsuarioDto {

    private long id;
    private String login;
    private String password;
    private String nombre;
    private String cliente;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaAlta;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaBaja;
    private String status;
    private String intentos;
    private Date fechaRevocada;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaVigencia;
    private Integer noAcceso;
    private String apellidoPaterno;
    private String apellidoMterno;
    private String area;
    private Date fechaModificacion;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIntentos() {
        return intentos;
    }

    public void setIntentos(String intentos) {
        this.intentos = intentos;
    }

    public Date getFechaRevocada() {
        return fechaRevocada;
    }

    public void setFechaRevocada(Date fechaRevocada) {
        this.fechaRevocada = fechaRevocada;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public Integer getNoAcceso() {
        return noAcceso;
    }

    public void setNoAcceso(Integer noAcceso) {
        this.noAcceso = noAcceso;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMterno() {
        return apellidoMterno;
    }

    public void setApellidoMterno(String apellidoMterno) {
        this.apellidoMterno = apellidoMterno;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public UsuarioDto(long id, String login, String password, String nombre, String cliente, String email, Date fechaAlta, Date fechaBaja, String status, String intentos, Date fechaRevocada, Date fechaVigencia, Integer noAcceso, String apellidoPaterno, String apellidoMterno, String area, Date fechaModificacion) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.cliente = cliente;
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
        this.status = status;
        this.intentos = intentos;
        this.fechaRevocada = fechaRevocada;
        this.fechaVigencia = fechaVigencia;
        this.noAcceso = noAcceso;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMterno = apellidoMterno;
        this.area = area;
        this.fechaModificacion = fechaModificacion;
    }

    public UsuarioDto() {
    }
}
