package com.nspTECH.gestion_usuarios.Service;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.nspTECH.gestion_usuarios.model.usuario;
import com.nspTECH.gestion_usuarios.repository.usuariosRepository;
import com.nspTECH.gestion_usuarios.services.usuarioServices;

public class usuariosServiceTest {

    @Mock
    private usuariosRepository usuariorepository;
    
    @InjectMocks
    private usuarioServices usuarioservices;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    
    @Test
    public void testBuscarTodo(){
    java.util.List<usuario> lista = new  ArrayList<>();

    usuario user1 = new usuario();
    usuario user2 = new usuario();

    
    user1.setId_usuario(11L);
    user1.setId_rol(3L);
    user1.setNombre("Bastian");
    user1.setApellido_paterno("Brisso");
    user1.setApellido_materno("Rojas");
    user1.setTelefono(789625632L);
    user1.setDireccion("siempre viva 123");
    user1.setFecha_nacimiento(null);
    user1.setCorreo("xxxx@xxxx.xx");
    user1.setContrasena("xxxxxx");
    user1.setRun(1111111111);
    user1.setDv("1");
    user1.setEstado("a");


    user2.setId_usuario(12L);
    user2.setId_rol(2L);
    user2.setNombre("MAryanne");
    user2.setApellido_paterno("Soto");
    user2.setApellido_materno(null);
    user2.setTelefono(789625632L);
    user2.setDireccion("siempre viva 1233");
    user2.setFecha_nacimiento(null);
    user2.setCorreo("xxxx@xxxx.xx");
    user2.setContrasena("xxxxxx");
    user2.setRun(222222222);
    user2.setDv("1");
    user2.setEstado("a");
    

    lista.add(user1);
    lista.add(user2);

    when(usuariorepository.findAll()).thenReturn(lista);

    java.util.List<usuario> resultadoBusqueda = usuarioservices.BuscarTodoUsuario();

    assertEquals(2,resultadoBusqueda.size());
    verify(usuariorepository, times(1)).findAll();

}

    @Test
    public void TestBuscarUnUsuario(){
    usuario user1 = new usuario();
    
    user1.setId_usuario(11L);
    user1.setId_rol(3L);
    user1.setNombre("Bastian");
    user1.setApellido_paterno("Brisso");
    user1.setApellido_materno("Rojas");
    user1.setTelefono(789625632L);
    user1.setDireccion("siempre viva 123");
    user1.setFecha_nacimiento(null);
    user1.setCorreo("xxxx@xxxx.xx");
    user1.setContrasena("xxxxxx");
    user1.setRun(1111111111);
    user1.setDv("1");
    user1.setEstado("a");

    when(usuariorepository.findById(11L)).thenReturn(Optional.of(user1));

    usuario usuarioBuscado = usuarioservices.BuscarUnUsuario(11L);
    assertEquals(11L,usuarioBuscado.getId_usuario());
    verify(usuariorepository, times(1)).findById(11L);

    }



    @Test
    public void testGuardarUsuario(){
        usuario u = new usuario();
    u.setId_usuario(11L);
    u.setId_rol(3L);
    u.setNombre("Bastian");
    u.setApellido_paterno("Brisso");
    u.setApellido_materno("Rojas");
    u.setTelefono(789625632L);
    u.setDireccion("siempre viva 123");
    u.setFecha_nacimiento(null);
    u.setCorreo("xxxx@xxxx.xx");
    u.setContrasena("xxxxxx");
    u.setRun(1111111111);
    u.setDv("1");
    u.setEstado("a");
        
        when(usuariorepository.save(any())).thenReturn(u);

        usuario usuarioGuardados = usuarioservices.GuardarUsuario(u);
        assertEquals(11L, usuarioGuardados.getId_usuario());
        verify(usuariorepository, times(1)).save(u);

    }

    @Test
    public void testEditarUsuario(){

        usuario usuarioOriginal = new usuario();
        usuarioOriginal.setId_usuario(11L);
        usuarioOriginal.setNombre("Bastian");
        usuarioOriginal.setApellido_paterno("Brisso");

        usuario usuarioEditado = new usuario();
        usuarioEditado.setId_usuario(11L);
        usuarioEditado.setNombre("Bruce");
        usuarioEditado.setApellido_paterno("Wayne");

        when(usuariorepository.save(any(usuario.class))).thenReturn(usuarioEditado);
        when(usuariorepository.existsById(11L)).thenReturn(true);
        usuario resultado = usuarioservices.GuardarUsuario(usuarioEditado);

        assertNotNull(resultado);
        assertEquals(11L, resultado.getId_usuario());
        assertEquals("Bruce", resultado.getNombre());
        assertEquals("Wayne", resultado.getApellido_paterno());

        verify(usuariorepository, times(1)).save(usuarioEditado);
    }

    @Test
    public void testEliminarUsuario(){
        Long id = 11L;
        doNothing().when(usuariorepository).deleteById(id);

        usuarioservices.EliminarUsuario(11L);

        verify(usuariorepository, times(1)).deleteById(id);

    }

}