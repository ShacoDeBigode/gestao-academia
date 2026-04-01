package com.gestao_academia.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name ="professores")
@Data
@EqualsAndHashCode(callSuper = true)
public class Professor extends Usuario {
    private String especialidade;
    private String registroProfissional;
}