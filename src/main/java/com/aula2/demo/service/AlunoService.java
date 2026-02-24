package com.aula2.demo.service;

import com.aula2.demo.model.Aluno;
import com.aula2.demo.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Camada de serviço (Service) para a entidade Aluno.
 *
 * A camada de serviço contém a lógica de negócio da aplicação.
 * Ela fica entre o Controller (que recebe as requisições) e o Repository (que acessa o banco).
 *
 * Essa separação em camadas (Controller → Service → Repository) é uma boa prática
 * que facilita manutenção, testes e reuso de código.
 *
 * @Service            - Marca esta classe como um componente de serviço do Spring.
 * @RequiredArgsConstructor - Lombok: gera um construtor com todos os atributos "final",
 *                           permitindo que o Spring faça a injeção de dependência automaticamente.
 */
@Service
@RequiredArgsConstructor
public class AlunoService {

    // O Spring injeta automaticamente a implementação do repository aqui.
    // Usamos "final" para garantir que a dependência seja obrigatória e imutável.
    private final AlunoRepository alunoRepository;

    /**
     * Retorna todos os alunos cadastrados.
     */
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    /**
     * Busca um aluno pelo ID.
     * Lança uma exceção caso não encontre (evita retornar null).
     */
    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
    }

    /*
     * Salva um novo aluno ou atualiza um existente.
     * O método save() do JPA verifica: se o objeto tem ID, ele atualiza; se não tem, ele insere.
     */
    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    /**
     * Remove um aluno pelo ID.
     */
    public void excluir(Long id) {
        // Verificamos se o aluno existe antes de deletar
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado com o ID: " + id);
        }
        alunoRepository.deleteById(id);
    }
}
