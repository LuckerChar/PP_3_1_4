
const username = document.getElementById('username')
const surname = document.getElementById('surname')
const age = document.getElementById('age')
const email = document.getElementById('email')
const password = document.getElementById('password')
const role = document.getElementById('role')
const addForm = document.querySelector('.addForm')

addForm.addEventListener('submit', e => {
    e.preventDefault();

    console.log('Form submitted');
    console.log(role.value)

    fetch("api", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user = {
            username: username.value,
            surname: surname.value,
            age: age.value,
            email: email.value,
            password: password.value,
            roles: role.value
        })
    }).then(()=> getUsers())
        .then(() => addForm.reset())

    return show('showUsers','addUser')
})