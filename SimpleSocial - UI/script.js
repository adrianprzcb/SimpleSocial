// Assuming you have a login form with username and password fields
const loginForm = document.getElementById('loginForm');

loginForm.addEventListener('submit', (event) => {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    fetch('/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username,
            password
        })
    })
    .then(response => response.json())

    .then(data => {
        // Handle successful login (e.g., redirect to feed page)
        console.log(data);
    })
    .catch(error => {
        // Handle login errors (e.g., display error message)
        console.error('Error:', error);
    });
});