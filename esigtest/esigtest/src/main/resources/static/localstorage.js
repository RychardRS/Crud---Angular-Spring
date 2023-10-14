$(document).ready(function () {
    $(".alert").fadeTo(1, 1).removeClass('hidden');
    window.setTimeout(function () {
        $(".alert").fadeTo(500, 0).slideUp(500, function () {
            $(".alert").addClass('hidden');
        });
    }, 2000);

    const dado = localStorage.getItem("dadoUsuario");
    document.getElementById("dado").value = dado;
});


function salvarDadoeEnviar() {
    const dado = document.getElementById("dado").value;
    localStorage.setItem("dadoUsuario", dado);
    document.getElementById("formularioCadastrarOUVisualizarInscricao").submit();
}