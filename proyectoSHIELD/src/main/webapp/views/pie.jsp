<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <footer class="pie">
        Sixtega Escribano Miguel Ángel
        <strong>Copyright &copy; 2023 <a href="#">Migna</a> Todos los derechos reservados</strong>
    </footer>
    </div>
<script>
    let iconomenu = document.querySelector(".iconomenu");
    let nav = document.querySelector(".navbar");
    iconomenu.addEventListener("click", () => {
        nav.classList.toggle("navclose");
    })
</script>
    <script src="<%=con%>/assets/js/verPerfil.js"></script>
    <script src="<%=con%>/assets/js/funciones.js"></script>
    </body>
</html>
