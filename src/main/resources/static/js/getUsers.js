//все юзеры
async function getAllUsers() {
    const response = await fetch("/api/admin");
    if (response.ok) {
        let responseJSON = await response.json()
            .then(data => replaceTable(data));
    }

    function replaceTable(data) {
        const placement = document.getElementById("allUsersTableBody");
        placement.innerHTML = "";
        data.forEach(({id, username, surname, age, email, roles}) => {
            let userRoles = "";
            roles.forEach(r => {
                userRoles = (userRoles + r.name + " ").replace("ROLE_", "")
            });
            const usersElement = document.createElement("tr");
            usersElement.innerHTML = `<th scope="row">${id}</th>
<td>${username}</td>
<td>${surname}</td> 
<td>${age}</td> 
<td>${email}</td> 
<td>${userRoles}</td> 
<td>

    <button type="button" class="btn btn-info text-white" 
        data-bs-userId=${id} data-bs-userUsername=${username}
        data-bs-userSurname=${surname} data-bs-userAge=${age}
        data-bs-userEmail=${email}
        
        data-bs-toggle="modal" data-bs-target="#editModal">Edit</button></td>
<td>

    <button type="button" class="btn btn-danger" 
        data-bs-userId=${id} data-bs-userUsername=${username} 
        data-bs-userSurname=${surname} data-bs-userAge=${age}
        data-bs-userEmail=${email}
        data-bs-toggle="modal" data-bs-target="#deleteModal">Delete</button></td>`

            placement.append(usersElement);
        });
    }
}

//делит
const formDelete = document.getElementById("deleteUserForm");
formDelete.addEventListener("submit", e => {
    e.preventDefault();
    const formData = new FormData(formDelete);
    fetch("/api/admin/"+formData.get("id"),{
        method:"DELETE"
    }).then(()=>getAllUsers());
    $("#deleteModal").modal("hide");
    formDelete.reset();
})
const deleteModal = document.getElementById("deleteModal");
deleteModal.addEventListener("show.bs.modal",event=>{
    const delButton = event.relatedTarget;
    const delId = delButton.getAttribute("data-bs-userId");
    const delUsername = delButton.getAttribute ("data-bs-userUsername");
    const delSurname = delButton.getAttribute ("data-bs-userSurname");
    const delAge = delButton.getAttribute("data-bs-userAge");
    const delEmail = delButton.getAttribute("data-bs-userEmail");

    const inId = document.getElementById("delitId");
    const inUsername = document.getElementById("delFirstname");
    const inSurname = document.getElementById("delLastname");
    const inAge = document.getElementById("delAge");
    const inEmail = document.getElementById("delEmail");

    inId.value = delId;
    inUsername.value = delUsername;
    inSurname.value = delSurname;
    inAge.value = delAge;
    inEmail.value = delEmail;
})
