package com.nspTECH.gestion_usuarios.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USUARIOS")
@Data
@AllArgsConstructor
@NoArgsConstructor




public class usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_USUARIO")
    private long ID_USUARIO;

    @Column(name= "NOMBRE",nullable= false , length = 30)
    private String NOMBRE;

    @Column(name= "apellido_paterno",nullable= false , length = 30)
    private String apellido_paterno;

    @Column(name= "apellido_materno",nullable= true , length = 30)
    private String apellido_materno;

    @Column(name = "TELEFONO",nullable= true , length = 9)
    private Long TELEFONO;

    @Column(name = "DIRECCION",nullable= true , length = 50)
    private String DIRECCION;

    @Column(name= "fecha_nacimiento",nullable= true)
    private Date fecha_nacimiento;

    @Column(name = "CORREO",nullable= false , length = 100)
    private String CORREO;

    @Column(name = "CONTRASENA",nullable= false , length = 20)
    private String CONTRASENA;

    @Column(name = "run",nullable= false , length = 20)
    private int run;

    @Column(name = "dv",nullable= false , length = 1)
    private String dv;


}
