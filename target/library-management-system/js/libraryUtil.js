var name = sessionStorage.getItem('username')
if (name === null){
    location.replace("index.html");
}
var message = 'Welcome '+name;
document.getElementById("welcomeHeading").innerHTML=message;
function logout() {
    sessionStorage.clear();
    location.replace('index.html')
}