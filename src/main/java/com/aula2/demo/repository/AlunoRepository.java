package com.aula2.demo.repository;

import com.aula2.demo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface responsável pelo acesso aos dados da entidade Aluno.
 *
 * Ao estender JpaRepository, herdamos automaticamente métodos como:
 *   - findAll()      → busca todos os registros
 *   - findById(id)   → busca por ID
 *   - save(entidade) → salva ou atualiza um registro
 *   - deleteById(id) → remove por ID
 *   - count()        → conta o total de registros
 *
 * O Spring Data JPA implementa essa interface em tempo de execução,
 * ou seja, NÃO precisamos escrever SQL nem criar uma classe de implementação.
 *
 * @Repository - Marca esta interface como um componente de acesso a dados do Spring.
 */
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    /**
     * Método de busca personalizado: encontra um aluno pelo e-mail.
     *
     * O Spring Data JPA interpreta o nome do método automaticamente:
     *   "findByEmail" → SELECT * FROM alunos WHERE email = ?
     *
     * Retorna Optional para evitar NullPointerException caso não encontre resultado.
     */
    Optional<Aluno> findByEmail(String email);

    /**
     * Busca um aluno pela matrícula.
     * "findByMatricula" → SELECT * FROM alunos WHERE matricula = ?
     */
    Optional<Aluno> findByMatricula(String matricula);
}
