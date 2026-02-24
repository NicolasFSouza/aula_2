package com.aula2.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa a entidade "Aluno" no banco de dados.
 *
 * @Entity    - Indica ao JPA que esta classe é uma entidade (será mapeada para uma tabela).
 * @Table     - Define o nome da tabela no banco de dados.
 * @Data      - Lombok: gera automaticamente getters, setters, toString, equals e hashCode.
 * @NoArgsConstructor  - Lombok: gera um construtor sem argumentos (exigido pelo JPA).
 * @AllArgsConstructor - Lombok: gera um construtor com todos os atributos.
 */
@Entity
@Table(name = "alunos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    /**
     * Chave primária da tabela.
     * @Id              - Marca este campo como a chave primária.
     * @GeneratedValue  - O valor será gerado automaticamente pelo banco de dados (auto-incremento).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome completo do aluno.
     * @Column - Permite configurar detalhes da coluna (nullable = false significa que é obrigatório).
     */
    @Column(nullable = false, length = 100)
    private String nome;

    /**
     * E-mail do aluno (deve ser único na tabela).
     */
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    /**
     * Curso em que o aluno está matriculado.
     */
    @Column(nullable = false, length = 80)
    private String curso;

    /**
     * Matrícula do aluno (identificador acadêmico único).
     */
    @Column(nullable = false, unique = true, length = 20)
    private String matricula;

    /*
    * Nota do aluno
    @Column(nullable= false, unique = false)
    private double nota;
     */

}
