package com.esigtest.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esigtest.exceptions.TarefaNotFoundException;
import com.esigtest.model.Tarefa;
import com.esigtest.repository.TarefaRepository;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    @Autowired
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        // Realize as validações necessárias
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefa) {
        // Verifique se a tarefa com o ID especificado existe no banco de dados
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);
        if (tarefaExistente.isPresent()) {
            Tarefa tarefaAtual = tarefaExistente.get();
            // Atualize os campos relevantes da tarefa com os valores fornecidos
            tarefaAtual.setTitulo(tarefa.getTitulo());
            tarefaAtual.setDescricao(tarefa.getDescricao());
            tarefaAtual.setResponsavel(tarefa.getResponsavel());
            tarefaAtual.setPrioridade(tarefa.getPrioridade());
            tarefaAtual.setDeadline(tarefa.getDeadline());
            tarefaAtual.setSituacao(tarefa.getSituacao());
            // Salve a tarefa atualizada no banco de dados
            return tarefaRepository.save(tarefaAtual);
        } else {
            throw new TarefaNotFoundException("Tarefa com o ID " + id + " nao encontrada");
        }
    }

    public void removerTarefa(Long id) {
        // Verifique se a tarefa com o ID especificado existe no banco de dados
        if (tarefaRepository.existsById(id)) {
            // Remova a tarefa do banco de dados
            tarefaRepository.deleteById(id);
        } else {
            throw new TarefaNotFoundException("Tarefa com o ID " + id + " nao encontrada");
        }
    }

    public List<Tarefa> listarTodasTarefas() {
        return tarefaRepository.findAll();
    }


    public Tarefa concluirTarefa(Long id) {
        // Verifique se a tarefa com o ID especificado existe no banco de dados
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);
        if (tarefaExistente.isPresent()) {
            Tarefa tarefa = tarefaExistente.get();
            // Marque a tarefa como concluída (defina a situaçao como "Concluída")
            tarefa.setSituacao("CONCLUIDA");
            // Salve a tarefa atualizada no banco de dados
            return tarefaRepository.save(tarefa);
        } else {
            throw new TarefaNotFoundException("Tarefa com o ID " + id + " nao encontrada");
        }
    }

}
