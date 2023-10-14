package com.esigtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esigtest.model.Tarefa;
import com.esigtest.service.TarefaService;

// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin(origins = "*")
// @Api(value = "Tarefa Controller", tags = "Tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService2) {
    }

    // Endpoint para criar uma tarefa
    // @ApiOperation(value = "Cria uma nova tarefa")
    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    // Endpoint para atualizar uma tarefa
    // @ApiOperation(value = "Atualiza uma tarefa")
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, tarefa);
        return ResponseEntity.ok(tarefaAtualizada);
    }

    // Endpoint para remover uma tarefa
    // @ApiOperation(value = "Remove uma tarefa")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerTarefa(@PathVariable Long id) {
        tarefaService.removerTarefa(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para listar todas as tarefas
    // @ApiOperation(value = "Lista todas as tarefa")
    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        List<Tarefa> tarefas = tarefaService.listarTodasTarefas();
        return ResponseEntity.ok(tarefas);
    }

    // @ApiOperation(value = "Conclui uma tarefa")
    @PutMapping("/{id}/concluir")
    public ResponseEntity<Tarefa> concluirTarefa(@PathVariable Long id) {
        // Implemente a lógica para marcar uma tarefa como concluída com o ID especificado
        // Você pode usar o serviço de tarefa para fazer isso
        Tarefa tarefaConcluida = tarefaService.concluirTarefa(id);
        return ResponseEntity.ok(tarefaConcluida);
    }
}

