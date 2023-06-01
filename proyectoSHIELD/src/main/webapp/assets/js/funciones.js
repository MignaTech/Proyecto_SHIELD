document.getElementById("btnListCapacidad").addEventListener("click", function() {
    window.location.href = "../CapacidadSV";
});

function mosBTN(id) {
    var seccion = document.getElementsByClassName("sec");
    for (var i = 0; i < seccion.length; i++) {
        seccion[i].style.display = (seccion[i].id === id) ? "block" : "none";
    }
}
