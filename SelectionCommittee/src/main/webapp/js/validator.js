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

    if (!checkName(username) || !checkName(name) || !checkPassword(password1) || !checkPassword(password2)) {
        return false;
    }
    if (password1 != password2) {
        alert("Passwords don't match");
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
    var value = parseInt(document.getElementById("value").value);
    if (value < 0 || value > 100){
        alert("Value must be in range (0, 100)");
        return false;
    }
    return true;
}