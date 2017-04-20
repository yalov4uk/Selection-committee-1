function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var LEN = document.getElementById("LEN").value;
    if (!checkName(username, LEN) || !checkPassword(password, LEN)) {
        return false;
    }
    return true;
}

function signup() {
    var username = document.getElementById("username").value;
    var name = document.getElementById("name").value;
    var password1 = document.getElementById("password").value;
    var password2 = document.getElementById("passwordverify").value;
    var LEN = document.getElementById("LEN").value;
    var PASSWORD_MATCH = document.getElementById("PASSWORD_MATCH").value;

    if (!checkName(username, LEN) || !checkName(name, LEN) || !checkPassword(password1, LEN) || !checkPassword(password2, LEN)) {
        return false;
    }
    if (password1 != password2) {
        alert(PASSWORD_MATCH);
        return false;
    }
    return true;
}

function checkName(name, LEN) {
    if (name.length < 5) {
        alert(LEN);
        return false;
    }
    return true;
}

function checkPassword(password, LEN) {
    if (password.length < 5) {
        alert(LEN);
        return false;
    }
    return true;
}

function registerToFaculty() {
    var value = Number(document.getElementById("value").value);
    var VALUE_REQ = document.getElementById("VALUE_REQ").value

    if (isNaN(value) || value < 0 || value > 100) {
        alert(VALUE_REQ);
        return false;
    }
    return true;
}