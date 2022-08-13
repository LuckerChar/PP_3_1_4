
// show info in modal

const editModal = document.getElementById('editModal')
const modalUserId = editModal.querySelector('#edId')
const modalUserName = editModal.querySelector('#edFirstname')
const modalUserSurname = editModal.querySelector('#edLastname')
const modalUserAge = editModal.querySelector('#edAge')
const modalUserEmail = editModal.querySelector('#edEmail')

editModal.addEventListener('show.bs.modal', event => {
    const button = event.relatedTarget
    const userId = button.getAttribute('data-bs-userId')
    const userName = button.getAttribute('data-bs-userName')
    const userSurname = button.getAttribute('data-bs-userSurname')
    const userAge = button.getAttribute('data-bs-userAge')
    const userEmail = button.getAttribute('data-bs-userEmail')

    console.log("there is the name of user")
    console.log(userName)

    modalUserId.value = userId
    modalUserName.value = userName
    modalUserSurname.value = userSurname
    modalUserAge.value = userAge
    modalUserEmail.value = userEmail

})
