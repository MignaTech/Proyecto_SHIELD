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
document.getElementById("btnListAtaque").addEventListener("click", function() {
    window.location.href = "../AtaqueSV";
});
document.getElementById("btnListLider").addEventListener("click", function() {
    window.location.href = "../LiderSV";
});
document.getElementById("btnListDirector").addEventListener("click", function() {
    window.location.href = "../DirectorSV";
});
document.getElementById("btnListJuntas").addEventListener("click", function() {
    window.location.href = "../JuntasSV";
});

function mosBTN(id) {
    var seccion = document.getElementsByClassName("sec");
    for (var i = 0; i < seccion.length; i++) {
        seccion[i].style.display = (seccion[i].id === id) ? "block" : "none";
    }
}
