function toggleDropdown(menuId) {
    var abre = document.getElementById(menuId);
    abre.style.display = abre.style.display === "block" ? "none" : "block";
}

document.addEventListener("click", function (event) {
    var despliega = document.getElementsByClassName("desp-menu");
    for (var i = 0; i < despliega.length; i++) {
        var menu = despliega[i];
        if (event.target.closest(".menu") !== menu.parentElement) {
            menu.style.display = "none";
        }
    }
});