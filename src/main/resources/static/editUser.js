
const editId = document.getElementById('edId')
const editUsername = document.getElementById('edFirstname')
const editSurname = document.getElementById('edLastname')
const editAge = document.getElementById('edAge')
const editEmail = document.getElementById('edEmail')
const editPassword = document.getElementById('edPassword')
const editRole = document.getElementById('editRole')
const editModalForm = document.querySelector('.editModalForm')

editModalForm.addEventListener('submit', e => {
    e.preventDefault();

    fetch("api", {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user = {
            id: editId.value,
            username: editUsername.value,
            surname: editSurname.value,
            age: editAge.value,
            email: editEmail.value,
            password: editPassword.value,
            roles: editRole.value
        })
    }).then(()=> getUsers())
    $("#editModal").modal("hide");
    editModalForm.reset();

})