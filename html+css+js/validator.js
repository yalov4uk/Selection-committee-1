function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    if (!checkName(username) || !checkPassword(password)) {
        return false;
    }
    return true;
}

function signup() {
    var username = document.getElementById("username").value;
    var name = document.getElementById("name").value;
    var password1 = document.getElementById("password").value;
    var password2 = document.getElementById("passwordverify").value;

    if (!checkName(username) || !checkName(name) || !checkPassword(password1) || !checkPassword(password2)) {
        return false;
    }
    if (password1 != password2) {
        alert("passwords don't match");
        return false;
    }
    return true;
}

function checkName(name) {
    if (name.length < 5) {
        alert("name < 5");
        return false;
    }
    return true;
}

function checkPassword(password) {
    var regPas = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{5,}$/;
    if (!regPas.test(password)) {
        alert(" password < 5 or without a, A or 1");
        return false;
    }
    return true;
}