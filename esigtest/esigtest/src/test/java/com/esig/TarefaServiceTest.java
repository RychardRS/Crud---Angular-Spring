package com.esig;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esigtest.EsigTestApplication;
import com.esigtest.model.Tarefa;
import com.esigtest.repository.TarefaRepository;
import com.esigtest.service.TarefaService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EsigTestApplication.class)
@ActiveProfiles("test")
public class TarefaServiceTest {

    @InjectMocks
    private TarefaService tarefaService;

    @Mock
    private TarefaRepository tarefaRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriarTarefa() {
        Tarefa tarefa = new Tarefa(); // Crie uma instância de Tarefa

        // Configura o comportamento do mock do repositório
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);

        Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);

        assertNotNull(novaTarefa);
        assertEquals(tarefa, novaTarefa);
    }

    @Test
    public void testAtualizarTarefa() {
        Long id = 1L;
        Tarefa tarefaExistente = new Tarefa();
        tarefaExistente.setId(id);
        Tarefa tarefaAtualizada = new Tarefa();
        tarefaAtualizada.setId(id);
        tarefaAtualizada.setTitulo("Tarefa Atualizada");

        when(tarefaRepository.findById(id)).thenReturn(Optional.of(tarefaExistente));
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefaAtualizada);

        Tarefa resultado = tarefaService.atualizarTarefa(id, tarefaAtualizada);

        assertNotNull(resultado);
        assertEquals(tarefaAtualizada.getId(), resultado.getId());
        assertEquals(tarefaAtualizada.getTitulo(), resultado.getTitulo());
    }

    @Test
    public void testRemoverTarefa() {
        Long id = 1L;

        when(tarefaRepository.existsById(id)).thenReturn(true);

        assertDoesNotThrow(() -> tarefaService.removerTarefa(id));
    }

    @Test
    public void testListarTodasTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        when(tarefaRepository.findAll()).thenReturn(tarefas);

        List<Tarefa> resultado = tarefaService.listarTodasTarefas();

        assertNotNull(resultado);
        assertEquals(tarefas.size(), resultado.size());
    }

    @Test
    public void testConcluirTarefa() {
        Long id = 1L;
        Tarefa tarefaExistente = new Tarefa();
        tarefaExistente.setId(id);
        tarefaExistente.setSituacao("EM ANDAMENTO");

        when(tarefaRepository.findById(id)).thenReturn(Optional.of(tarefaExistente));
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefaExistente);

        Tarefa resultado = tarefaService.concluirTarefa(id);

        assertNotNull(resultado);
        assertEquals("CONCLUIDA", resultado.getSituacao());
    }
}

