package com.adea.prueba.controlador;


import com.adea.prueba.dto.Login;
import com.adea.prueba.dto.UsuarioDto;
import com.adea.prueba.model.Usuario;
import com.adea.prueba.servicio.IRepository;
import com.adea.prueba.servicio.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;
import java.util.Date;

@Controller
@RequestMapping("/home")
public class ControllerUsuario {

    @Autowired
    private IServicio servicio;

    @Autowired
    private IRepository iRepository;

    @ModelAttribute("usuario")
    public UsuarioDto nuevoUsuario(){
        return new UsuarioDto();
    }

    @ModelAttribute("login")
    public Login nuevoInicio(){
        return new Login();
    }

    @GetMapping("/inicio")
    public String mostrarInicio(){
        return "login";
    }

    @GetMapping("/registrar")
    public String mostrarFormulario(){
        return "registrar";
    }

    @GetMapping("/menu")
    public String mostrarMenu(){
        return "menu";
    }

    @GetMapping("/mostrar")
    public String muestraLista(Model model){
        model.addAttribute("usuarios", servicio.mostrarUsuarios());
        return "mostrar";
    }

    @PostMapping("/validaUsuario")
    public String validarUsuario(@ModelAttribute("login") Login lgn) {
        Usuario usu = iRepository.buscarLogou(lgn.getLogin());
        Date myDate = new Date();
        byte[] decodedBytes = Base64.getDecoder().decode(usu.getPassword());
        String usudecodificado = new String(decodedBytes);
        if (usu.getLogin().equals(lgn.getLogin()) && lgn.getPassword().equals(usudecodificado)){
            if(myDate.before(usu.getFechaVigencia())){
                return "menu";
            }else{
                return "redirect:/home/inicio?fecha";
            }
        }else{
            return "redirect:/home/inicio?incorrecto";
        }

    }

    @PostMapping("/registrar")
    public String registraUsuario(@ModelAttribute("usuario") UsuarioDto registro) {
        String codificacion = Base64.getEncoder().encodeToString(registro.getPassword().getBytes());
        Date myDate = new Date();
        UsuarioDto user = registro;
        user.setPassword(codificacion);
        user.setFechaAlta(myDate);
        servicio.guardar(user);
        return "redirect:/home/registrar?correcto";
    }

    @PostMapping("/editarUsuario")
    public String actualizarUsuario(@ModelAttribute("usuario") UsuarioDto registro) {
        Date myDate = new Date();
        UsuarioDto user = registro;
        user.setFechaModificacion(myDate);
        servicio.editar(user);
        return "editar";
    }

    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id) {
        if(id > 0) {
            servicio.eliminar(id);
        }
        return "redirect:/home/mostrar";
    }

    @RequestMapping(value="/modificarUsuario/{id}")
    public String editar(@PathVariable(value="id") Long id, Model model) {

        Usuario user = null;

        if(id > 0) {
            user = servicio.buscarUsuario(id);
        } else {
            return "redirect:/home/mostrar";
        }
        model.addAttribute("usuario",user );
        return "editar";
    }

    @RequestMapping(value="/mostraTipo/{status}")
    public String mostrarPorTipo(@PathVariable(value="status") String status, Model model) {
        model.addAttribute("usuarios", iRepository.mostrarUsuariosTipo(status));
        return "mostrar";
    }

    @RequestMapping(value="/mostrarNombre/{nombre}")
    public String mostrarPorNombre(@PathVariable(value="nombre") String nombre, Model model) {
        model.addAttribute("usuarios", iRepository.mostrarUsuariosNombre(nombre));
        return "mostrar";
    }

    @RequestMapping(value="/mostrarFecha/{fechaIni}/{fechaFni}")
    public String mostrarPorFecha(@PathVariable(value="fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date fechaIni, @PathVariable(value="fechaFni") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date fechaFni, Model model) {
        model.addAttribute("usuarios", iRepository.mostrarUsuariosFecha(fechaIni,fechaFni));
        return "mostrar";
    }
}
