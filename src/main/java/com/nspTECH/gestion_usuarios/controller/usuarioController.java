package com.nspTECH.gestion_usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nspTECH.gestion_usuarios.model.usuario;
import com.nspTECH.gestion_usuarios.services.usuarioServices;




@RestController
@RequestMapping("/api/v1/Usuarios")
public class usuarioController {


@Autowired

    private usuarioServices usuarioservices;

    @GetMapping
    public ResponseEntity<?> ListarUsuarios(){
        List<usuario> usuarios = usuarioservices.BuscarTodoUsuario();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentran dato");
        } else {
            return ResponseEntity.ok(usuarios);
        }
    }
    @GetMapping("/{ID_USUARIO}")
    public ResponseEntity<?> BuscarProducto(@PathVariable Long ID_USUARIO){

        try {
            usuario usuarioBuscado = usuarioservices.BuscarUnUsuario(ID_USUARIO);
            return ResponseEntity.ok(usuarioBuscado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentran Usuario");
        }
        
    }


    @PostMapping
    public ResponseEntity<?> GuardarUsuario(@RequestBody usuario usuarioGuardar){
    try {
            usuario usuarioRegistrar = usuarioservices.GuardarUsuario(usuarioGuardar);
            return ResponseEntity.ok(usuarioRegistrar);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("No se puede registrar el Usuario");
    }
    }
    
    @PutMapping("/{ID_USUARIO}") //SOLO PERMITE ACTUALIZAR ESCRIBIENDO TODOS LOS DATOS
        
    public ResponseEntity<?> ActualizarUsuarios(@PathVariable Long ID_USUARIO, @RequestBody usuario usuarioActualizar){
        try {
            usuario usuarioActualizado = usuarioservices.BuscarUnUsuario(ID_USUARIO);
            usuarioActualizado.setNOMBRE(usuarioActualizar.getNOMBRE());
            usuarioActualizado.setApellido_paterno(usuarioActualizar.getNOMBRE());
            usuarioActualizado.setApellido_materno(usuarioActualizar.getApellido_materno());
            usuarioActualizado.setFecha_nacimiento(usuarioActualizar.getFecha_nacimiento());
            usuarioActualizado.setCORREO(usuarioActualizar.getCORREO());
            usuarioActualizado.setDIRECCION(usuarioActualizar.getDIRECCION());
            usuarioActualizado.setTELEFONO(usuarioActualizar.getTELEFONO());
            usuarioActualizado.setCONTRASENA(usuarioActualizar.getCONTRASENA());
            usuarioActualizado.setRun(usuarioActualizar.getRun());
            usuarioActualizado.setDv(usuarioActualizar.getDv());
            usuarioservices.GuardarUsuario(usuarioActualizado);
            return ResponseEntity.ok(usuarioActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no esta registrado");
        }
    }
    
    /*
        S@DeleteMapping("/{ID_USUARIO}")
        public ResponseEntity<String> EliminarUsuario(@PathVariable Long ID_USUARIO){
            try {
                usuario usuarioBuscado = usuarioservices.BuscarUnUsuario(ID_USUARIO);
                usuarioservices.EliminarUsuario(ID_USUARIO);
                return ResponseEntity.status(HttpStatus.OK).body("Se elimina Usuario");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no esta registrado");
            }
        }
            */

}
