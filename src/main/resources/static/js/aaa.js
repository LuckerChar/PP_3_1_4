async function auth() {
    let authObj;

    fetch("api/users/auth").then(res => {
        res.json().then(
            user => {
                authObj = {
                    id: user.id,
                    name: user.name,
                    surname: user.surname,
                    age: user.age,
                    email: user.email,
                    userRoles: ""
                }
                user.roles.forEach((role) => {
                    authObj.userRoles += role.name.substring(5) + " ";
                })
                console.log(authObj);
                infoBar(authObj);
                navBar(authObj.userRoles, authObj.email)

            }
        )
    })
}



function infoBar(obj) {
    const placement = document.getElementById("usersTablePlacement")

    placement.innerHTML = `
    <td>${obj.id}</td>
    <td>${obj.name}</td>
    <td>${obj.surname}</td>
    <td>${obj.age}</td>
    <td>${obj.email}</td>
    <td>${obj.userRoles}</td>
    `
}

function navBar(roles, email) {
    console.log(roles, email)
    const placement = document.getElementById("navBar");
    const element = document.createElement("div");
    element.innerHTML = `
            <b class="navbar-brand"> ${email} </b>
            <a class="navbar-brand" href="#"> with roles:</a>
            <a class="navbar-brand" href="#" > ${roles}</a>
                        `
    console.log(roles, email)
    placement.append(element)

}
