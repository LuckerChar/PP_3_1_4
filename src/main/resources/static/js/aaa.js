//
// // Admin page header
// const adminNavbar = document.getElementById('adminNavbar')
// const activeAdminUrl = 'http://localhost:8080/api/auth'
// let activeAdminId
//
//
// fetch(activeAdminUrl)
//     .then(res => res.json())
//     .then(data => {
//         adminNavbar.innerHTML = `${data.email} with roles: ${data.roles}`
//         activeAdminId = `${data.id}`
//     })
//
// // User page header
// const userNavbar = document.getElementById('userNavbar')
// const activeUserUrl = 'http://localhost:8080/api/auth'
// fetch(activeUserUrl)
//     .then(res => res.json())
//     .then(data => {
//         userNavbar.innerHTML = `${data.email} with roles: ${data.roles}`
//     })
//
// showUserPage()
//
// // Listing all users function
// let usersTableOutput = ''
// const listAllUsers = (users) => {
//     users.forEach(user => {
//         usersTableOutput += `
//                         <tr>
//                             <td>${user.id}</td>
//                             <td>${user.username}</td>
//                             <td>${user.surname}</td>
//                             <td>${user.age}</td>
//                             <td>${user.email}</td>
//                             <td>${user.roles}</td>
//                             <td><button type="button" class="btn btn-primary" data-toggle="modal"
//                                         data-target="#editModal" id="editButton" data-uid=${user.id}>Edit</button></td>
//                             <td><button type="button" class="btn btn-danger" data-toggle="modal"
//                                         data-target="#deleteModal" id="deleteButton" data-uid=${user.id}>Delete</button></td>
//                         </tr>`
//     })
//     usersTable.innerHTML = usersTableOutput
// }
//
// // Listing all users on admin page
// const usersTable = document.getElementById('usersTablePlacement')
// const usersUrl = 'http://localhost:8080/api/users'
// fetch(usersUrl)
//     .then(res => res.json())
//     .then(data => listAllUsers(data))
//
// // Showing user page
// function showUserPage() {
//     const userInfo = document.getElementById('user-info')
//     let userInfoOutput
//     fetch(activeUserUrl)
//         .then(res => res.json())
//         .then(data => {
//             userInfoOutput = `
//             <tr>
//                 <td>${data.id}</td>
//                 <td>${data.username}</td>
//                 <td>${data.surname}</td>
//                 <td>${data.age}</td>
//                 <td>${data.email}</td>
//                 <td>${data.roles}</td>
//             </tr>`
//             userInfo.innerHTML = userInfoOutput
//         })
// }

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


// //все юзеры
// async function getAllUsers() {
//     const response = await fetch("/api/admin");
//     if (response.ok) {
//         let responseJSON = await response.json()
//             .then(data => replaceTable(data));
//     }
//
//     function replaceTable(data) {
//         const placement = document.getElementById("allUsersTableBody");
//         placement.innerHTML = "";
//         data.forEach(({id, username, surname, age, email, roles}) => {
//             let userRoles = "";
//             roles.forEach(r => {
//                 userRoles = (userRoles + r.name + " ").replace("ROLE_", "")
//             });
//             const usersElement = document.createElement("tr");
//             usersElement.innerHTML = `<th scope="row">${id}</th>
// <td>${username}</td>
// <td>${surname}</td>
// <td>${age}</td>
// <td>${email}</td>
// <td>${userRoles}</td>
// <td>
//
//     <button type="button" class="btn btn-info text-white"
//         data-bs-userId=${id} data-bs-userUsername=${username}
//         data-bs-userSurname=${surname} data-bs-userAge=${age}
//         data-bs-userEmail=${email}
//
//         data-bs-toggle="modal" data-bs-target="#editModal">Edit</button></td>
// <td>
//
//     <button type="button" class="btn btn-danger"
//         data-bs-userId=${id} data-bs-userUsername=${username}
//         data-bs-userSurname=${surname} data-bs-userAge=${age}
//         data-bs-userEmail=${email}
//         data-bs-toggle="modal" data-bs-target="#deleteModal">Delete</button></td>`
//
//             placement.append(usersElement);
//         });
//     }
// }
//
// async function getOneUser() {
//
//     const response = await fetch("api/user");
//
//     if (response.ok) {
//         let json = await response.json()
//             .then(data => replaceTable(data));
//     } else {
//         alert("Ошибка HTTP: " + response.status);
//     }
//
//     function replaceTable(data) {
//
//         const placement = document.getElementById("usersTablePlacement")
//         placement.innerHTML = "";
//         data.forEach(({id, name, surname, age, email, roles}) => {
//             let userRoles = "";
//             roles.forEach((role) => {
//                 userRoles = userRoles + role.name.split("_")[1] + " ";
//             })
//             const element = document.createElement("tr");
//             element.innerHTML = `
//             <th scope="row">${id}</th>
//             <td>${name}</td>
//             <td>${surname}</td>
//             <td>${age}</td>
//             <td>${email}</td>
//             <td>${userRoles}</td>
//             <td>
//                 <button type="button" class="btn btn-info text-white" data-bs-userId=${id}
//                     data-bs-userName=${name} data-bs-userSurname=${surname} data-bs-userAge=${age}
//                     data-bs-userEmail=${email} data-bs-toggle="modal"
//                     data-bs-target="#ModalEdit">Edit</button>
//             </td>
//             <td>
//                 <button type="button" class="btn btn-danger" data-bs-userId=${id}
//                     data-bs-userName=${name} data-bs-userSurname=${surname} data-bs-userAge=${age}
//                     data-bs-userEmail=${email} data-bs-toggle="modal"
//                     data-bs-target="#ModalDelete">Delete</button>
//             </td>
//             `
//             placement.append(element);
//         })
//     }
//
//
// }
//
// //делит
// const formDelete = document.getElementById("deleteUserForm");
// formDelete.addEventListener("submit", e => {
//     e.preventDefault();
//     const formData = new FormData(formDelete);
//     fetch("/api/admin/" + formData.get("id"), {
//         method: "DELETE"
//     }).then(() => getAllUsers());
//     $("#deleteModal").modal("hide");
//     formDelete.reset();
// })
// //окно делит
// const deleteModal = document.getElementById("deleteModal");
// deleteModal.addEventListener("show.bs.modal", event => {
//     const delButton = event.relatedTarget;
//     const delId = delButton.getAttribute("data-bs-userId");
//     const delUsername = delButton.getAttribute("data-bs-userUsername");
//     const delSurname = delButton.getAttribute("data-bs-userSurname");
//     const delAge = delButton.getAttribute("data-bs-userAge");
//     const delEmail = delButton.getAttribute("data-bs-userEmail");
//
//     const inId = document.getElementById("delitId");
//     const inUsername = document.getElementById("delFirstname");
//     const inSurname = document.getElementById("delLastname");
//     const inAge = document.getElementById("delAge");
//     const inEmail = document.getElementById("delEmail");
//
//     inId.value = delId;
//     inUsername.value = delUsername;
//     inSurname.value = delSurname;
//     inAge.value = delAge;
//     inEmail.value = delEmail;
// })
// //едит
// const formEdit = document.getElementById("editModal");
// formEdit.addEventListener('submit', e => {
//     e.preventDefault();
//
//     const formData = new FormData(formEdit);
//     let object = {
//         roles: []
//     };
//
//     formData.getAll("roles").forEach(e => {
//         const roleId = e.split(" ")[0];
//         const roleName = e.split(" ")[1]
//         const role = {
//             id: roleId,
//             name: roleName
//         };
//         object.roles.push(role)
//
//     });
//     console.log(object)
//     formData.forEach((value, key) => {
//         if (key === "roles") {
//         } else {
//             object[key] = value;
//         }
//     });
//
//     console.log(formData.getAll("roles"))
//     i = 1;
//     if (1) {
//         fetch("api/admin", {
//             method: "PUT",
//             headers: {
//                 "Content-type": "application/json"
//             },
//             body: JSON.stringify(object)
//         })
//             .then(() => getAllUsers());
//         $("#ModalEdit").modal("hide");
//         formEdit.reset();
//     } else {
//         alert("фыв")
//     }
// })
// //окно едит
// const updateModal = document.getElementById('editModal')
// updateModal.addEventListener('show.bs.modal', event => {
//
//     const uButton = event.relatedTarget
//
//     const uUserId = uButton.getAttribute('data-bs-userId')
//     const uUserName = uButton.getAttribute('data-bs-userName')
//     const uUserSurname = uButton.getAttribute('data-bs-userSurname')
//     const uUserAge = uButton.getAttribute('data-bs-userAge')
//     const uUserEmail = uButton.getAttribute('data-bs-userEmail')
//
//     const uModalUserId = updateModal.querySelector('#userIdUpdate')
//     const uModalUserName = updateModal.querySelector('#nameUpdate')
//     const uModalUserSurname = updateModal.querySelector('#userSurnameUpdate')
//     const uModalUserAge = updateModal.querySelector('#userAgeUpdate')
//     const uModalUserEmail = updateModal.querySelector('#userEmailUpdate')
//
//     uModalUserId.value = uUserId
//     uModalUserName.value = uUserName
//     uModalUserSurname.value = uUserSurname
//     uModalUserAge.value = uUserAge
//     uModalUserEmail.value = uUserEmail
//
// })
//
// //добавить юзера
// const addUser = document.getElementById("createUser");
// addUser.addEventListener("submit", (e) => {
//     e.preventDefault();
//
//     const formData = new FormData("createUser");
//     const object = {
//         roles:[]
//     };
//
//     formData.forEach((value, key) => {
//         if (key === "rolesId"){
//
//             const roleId = value.split(" ")[0];
//             const roleName = value.split(" ")[1];
//             const role = {
//                 id : roleId,
//                 name : roleName
//             };
//             object.roles.push(role);
//         } else {
//             object[key] = value;
//         }
//     });
//
//     fetch("api/", {
//         method: "POST",
//         headers: {
//             "Content-type": "application/json"
//         },
//         body: JSON.stringify(object)
//     })
//         .then(() => getAllUsers())
//         .then(() => addUser.reset());
//
//     return show('Page1','Page2');
//
// })
