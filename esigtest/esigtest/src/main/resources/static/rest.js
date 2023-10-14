function carregarDados() {
    fetch('/tarefas') // Substitua pela URL do seu endpoint REST
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById('tarefas-table-body');
            
            data.forEach(tarefa => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${tarefa.id}</td>
                    <td>${tarefa.nome}</td>
                    <td>${tarefa.email}</td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Erro ao carregar dados:', error));
}

window.addEventListener('load', carregarDados);
