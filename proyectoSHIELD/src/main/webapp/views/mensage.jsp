<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String raiz = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Mensaje</title>
    <style>
        .popup {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: white;
            width: 400px;
            padding: 20px;
            text-align: center;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        .popup img {
            width: 100px;
            height: auto;
            margin-top: -40px;
            border-radius: 50%;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        .popup h2 {
            font-size: 34px;
            margin: 30px 0 10px 0;
        }
        .popup p {
            margin-bottom: 20px;
        }
        .popup button {
            width: 100%;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 18px;
            border-radius: 4px;
            cursor: pointer;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
    </style>
</head>
<body>
    <%
        String msj_title= (String) request.getAttribute("msj_title");
        String msj_img = (String) request.getAttribute("msj_img");
        String msj_text = (String) request.getAttribute("msj_text");
        String msj_return = (String) request.getAttribute("msj_return");
        if (msj_title == null || msj_title.isEmpty())
            msj_title = "S.H.I.E.L.D.";
    %>
    <div class="popup">
        <img src="<%=raiz%>/assets/img/<%= msj_img %>">
        <h2><%= msj_title %></h2>
        <pre style="font-size: 16px;"><%= msj_text %></pre>
        <button type="button" onclick="window.location.href='<%=raiz%>/<%=msj_return%>'">OK</button>
    </div>
</body>
</html>
