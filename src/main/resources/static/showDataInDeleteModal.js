
const deleteModal = document.getElementById('deleteModal')

let button
let idFromButton

deleteModal.addEventListener('show.bs.modal', event => {
    button = event.relatedTarget
    idFromButton = button.getAttribute('data-bs-userId')
    const deleteUserName = button.getAttribute('data-bs-userName')
    const deleteUserSurname = button.getAttribute('data-bs-userSurname')
    const deleteUserAge = button.getAttribute('data-bs-userAge')
    const deleteUserEmail = button.getAttribute('data-bs-userEmail')

    console.log("there is the name of user")
    console.log(deleteUserName)

    const deleteModalUserId = deleteModal.querySelector('#delitId')
    const deleteModalUserName = deleteModal.querySelector('#delFirstname')
    const deleteModalUserSurname = deleteModal.querySelector('#delLastname')
    const deleteModalUserAge = deleteModal.querySelector('#delAge')
    const deleteModalUserEmail = deleteModal.querySelector('#delEmail')

    deleteModalUserId.value = idFromButton
    deleteModalUserName.value = deleteUserName
    deleteModalUserSurname.value = deleteUserSurname
    deleteModalUserAge.value = deleteUserAge
    deleteModalUserEmail.value = deleteUserEmail
})