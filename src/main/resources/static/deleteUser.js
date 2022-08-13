
const deleteModalForm = document.querySelector('.deleteModalForm')
deleteModalForm.addEventListener('submit', e => {
    e.preventDefault();

    fetch('api/' + idFromButton, {
        method: 'DELETE',
    }).then(()=> getUsers())
    $("#deleteModal").modal("hide");
    deleteModalForm.reset();
})