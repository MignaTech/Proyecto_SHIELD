document.getElementById("btnListCapacidad").addEventListener("click", function() {
    window.location.href = "../CapacidadSV";
});
document.getElementById("btnListAgente").addEventListener("click", function() {
    window.location.href = "../AgentesSV";
});
document.getElementById("btnListEquipo").addEventListener("click", function() {
    window.location.href = "../EquipoSV";
});

function mosBTN(id) {
    var seccion = document.getElementsByClassName("sec");
    for (var i = 0; i < seccion.length; i++) {
        seccion[i].style.display = (seccion[i].id === id) ? "block" : "none";
    }
}
