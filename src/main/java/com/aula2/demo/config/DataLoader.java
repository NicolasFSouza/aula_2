package com.aula2.demo.config;

import com.aula2.demo.model.Aluno;
import com.aula2.demo.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Classe que popula o banco de dados com dados iniciais para demonstração.
 *
 * CommandLineRunner é uma interface do Spring Boot que executa o método run()
 * automaticamente assim que a aplicação inicia. Ideal para carregar dados de exemplo.
 *
 * @Component - Marca como um componente gerenciado pelo Spring.
 */
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final AlunoRepository alunoRepository;

    @Override
    public void run(String... args) {
        // Só insere dados se o banco estiver vazio (evita duplicação ao reiniciar)
        if (alunoRepository.count() == 0) {
            alunoRepository.save(new Aluno(null, "Eduardo Longen Correa", "eduardo.longen@email.com", "Engenharia de Software", "20222720"));
            alunoRepository.save(new Aluno(null, "Maria Bordignon", "maria.bordignon@email.com", "Ciência da Computação", "2025002"));
            alunoRepository.save(new Aluno(null, "Daemon Targaryen", "daemon@email.com", "Sistemas de Informação", "2025003"));

            System.out.println(">>> Dados iniciais carregados com sucesso!");
        }
    }
}
