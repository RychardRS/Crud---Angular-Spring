package com.esig;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.esigtest.EsigTestApplication;
import com.esigtest.model.Tarefa;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EsigTestApplication.class)
@AutoConfigureMockMvc
public class TarefaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCriarTarefa() throws Exception {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Tarefa de Teste");
        tarefa.setDescricao("Descrição da Tarefa");
        tarefa.setResponsavel("Rychardson");
        tarefa.setPrioridade("Alta");
        tarefa.setDeadline(LocalDate.now());
        tarefa.setSituacao("Em Andamento");

        String requestBody = objectMapper.writeValueAsString(tarefa);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/tarefas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testAtualizarTarefa() throws Exception {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Tarefa atualizada");
        tarefa.setDescricao("Descrição atualizada");
        tarefa.setResponsavel("Rychardson");
        tarefa.setPrioridade("Alta");
        tarefa.setDeadline(LocalDate.now());
        tarefa.setSituacao("Em Andamento");

        String requestBody = objectMapper.writeValueAsString(tarefa);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/tarefas/{id}", tarefa.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testConcluirTarefa() throws Exception {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Tarefa de Teste");
        tarefa.setDescricao("Descrição da Tarefa");
        tarefa.setResponsavel("Rychardson");
        tarefa.setPrioridade("Alta");
        tarefa.setDeadline(LocalDate.now());
        tarefa.setSituacao("Em Andamento");

        mockMvc.perform(MockMvcRequestBuilders.put("/api/tarefas/{id}/concluir", tarefa.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testRemoverTarefa() throws Exception {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Tarefa de Teste");
        tarefa.setDescricao("Descrição da Tarefa");
        tarefa.setResponsavel("Rychardson");
        tarefa.setPrioridade("Alta");
        tarefa.setDeadline(LocalDate.now());
        tarefa.setSituacao("Em Andamento");
        
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/tarefas/{id}", tarefa.getId()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
