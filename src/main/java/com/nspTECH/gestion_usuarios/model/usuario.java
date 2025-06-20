package com.nspTECH.gestion_usuarios.model;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Todos los productos registrados en la empresa")



public class usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_USUARIO")
    private long ID_USUARIO;

    @Column(name= "id_rol", nullable=false)
    @Schema(description="long 10")
    private long id_rol;

    @Column(name= "NOMBRE",nullable= false , length = 30)
    @Schema(description="")
    private String NOMBRE;

    @Column(name= "apellido_paterno",nullable= false , length = 30)
    @Schema(description="")
    private String apellido_paterno;

    @Column(name= "apellido_materno",nullable= true , length = 30)
    @Schema(description="")
    private String apellido_materno;

    @Column(name = "TELEFONO",nullable= true , length = 9)
    @Schema(description="")
    private Long TELEFONO;

    @Column(name = "DIRECCION",nullable= true , length = 50)
    @Schema(description="")
    private String DIRECCION;

    @Column(name= "fecha_nacimiento",nullable= true)
    @Schema(description="")
    private Date fecha_nacimiento;

    @Column(name = "CORREO",nullable= false , length = 100)
    @Schema(description="")
    private String CORREO;

    @Column(name = "CONTRASENA",nullable= false , length = 20)
    @Schema(description="")
    private String CONTRASENA;

    @Column(name = "run",nullable= false , length = 20)
    @Schema(description="")
    private int run;

    @Column(name = "dv",nullable= false , length = 1)
    @Schema(description="")
    private String dv;

    @Column(name = "Estado",nullable= false , length = 1)
    @Schema(description="")
    private String Estado;


}
