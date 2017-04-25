function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let LEN = document.getElementById("LEN").value;
    if (!checkName(username, LEN) || !checkPassword(password, LEN)) {
        return false;
    }
    return true;
}

function signup() {
    let username = document.getElementById("username").value;
    let name = document.getElementById("name").value;
    let password1 = document.getElementById("password").value;
    let password2 = document.getElementById("passwordverify").value;
    let LEN = document.getElementById("LEN").value;
    let PASSWORD_MATCH = document.getElementById("PASSWORD_MATCH").value;

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
    let values = document.getElementsByClassName("value");
    let VALUE_REQ = document.getElementById("VALUE_REQ").value;
    for (let value of values){
        let val = Number(value.value);
        if (value.value.length == 0 || isNaN(val) || val < 0 || val > 100) {
            alert(VALUE_REQ);
            return false;
        }
    }
    return true;
}