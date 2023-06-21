<%@ page contentType="text/html;" pageEncoding="ISO-8859-1" %>
    <footer class="pie">
        Sixtega Escribano Miguel Ángel
        <strong>Copyright &copy; 2023 <a style="color: black"
                                         href="https://github.com/MignaTech/"
                                         target="_blank" rel="noopener noreferrer">
            @MignaTech</a>
            Todos los derechos reservados</strong>
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
