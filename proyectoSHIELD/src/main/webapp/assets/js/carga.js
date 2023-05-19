function showLetters() {
    const textElement = document.createElement("h1");
    document.body.appendChild(textElement);
    const text = "S.H.I.E.L.D.";
    let delay = 0;
    for (let i = 0; i < text.length; i++) {
        const letter = document.createElement("span");
        letter.textContent = text[i];
        letter.classList.add("letter");
        letter.style.animationDelay = delay + "s";
        textElement.appendChild(letter);
        delay += .1;
    }
    setTimeout(function() {
        window.location.href = "./views/home.jsp";
    }, 2000);
}
setTimeout(showLetters, 2000);