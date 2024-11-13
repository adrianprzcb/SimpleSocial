registerForm.addEventListener('submit', (event) => {
    event.preventDefault();

    const username = document.getElementById('usernameReg').value;
    const password = document.getElementById('passwordReg').value;

    if (username.trim() === '' || password.trim() === '') {
        alert('Please fill in all fields.');
        return;
    }

    fetch('http://localhost:8080/api/register', { // Updated URL
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    })
    .then(response => {
        if (response.ok) {
            alert('Registration successful!');
            window.location.href = '/login'; // Replace with your desired URL
        } else {
            return response.json();
        }
    })
    .then(data => {
        if (data && data.error) {
            alert('Registration failed: ' + data.error);
        } else {
            console.error('Registration failed: Unknown error');
        }
    })
    .catch(error => {
        console.error('Registration error:', error);
        alert('An error occurred during registration. Please try again later.');
    });
});