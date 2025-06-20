package com.nspTECH.gestion_usuarios.Assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Component;

import com.nspTECH.gestion_usuarios.controller.usuarioController;
import com.nspTECH.gestion_usuarios.model.usuario;

@Component
public class UsuarioModelAssembler implements RepresentationModelAssembler<usuario, EntityModel<usuario>>{

    @Override
    public EntityModel<usuario> toModel(usuario u){
        return EntityModel.of(
            u,
            linkTo(methodOn(usuarioController.class).BuscarUsuario(u.getID_USUARIO())).withRel("LINKS"),
            linkTo(methodOn(usuarioController.class).ListarUsuarios()).withRel("todas-los-Usuario"),
            linkTo(methodOn(usuarioController.class).ActualizarUsuarios(u.getID_USUARIO(), u)).withRel("actualiza-una-pruducto")
        );

    }

}
/*  linkTo(methodOn(usuarioController.class).EliminarProducto(p.getID_PRODUCTO())).withRel("elimina-una-venta"),*/