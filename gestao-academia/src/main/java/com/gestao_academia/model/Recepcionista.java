package com.gestao_academia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "recepcionistas")
@Data
@EqualsAndHashCode(callSuper = true)
public class Recepcionista extends Usuario {
}