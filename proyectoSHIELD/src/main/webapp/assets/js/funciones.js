document.getElementById("btnListCapacidad").addEventListener("click", function() {
    window.location.href = "../CapacidadSV";
});
document.getElementById("btnListAgente").addEventListener("click", function() {
    window.location.href = "../AgentesSV";
});
document.getElementById("btnListEquipo").addEventListener("click", function() {
    window.location.href = "../EquipoSV";
});
document.getElementById("btnListGrupo").addEventListener("click", function() {
    window.location.href = "../SuperH_SV";
});
document.getElementById("btnListPais").addEventListener("click", function() {
    window.location.href = "../PaisesSV";
});
document.getElementById("btnListTpRaza").addEventListener("click", function() {
    window.location.href = "../Tip_AlienSV";
});

function mosBTN(id) {
    var seccion = document.getElementsByClassName("sec");
    for (var i = 0; i < seccion.length; i++) {
        seccion[i].style.display = (seccion[i].id === id) ? "block" : "none";
    }
}
