
const loginForm = document.getElementById('login-form'); // Select form by its ID
loginForm.addEventListener('submit', async function (e) {
    e.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('/api/teacher/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email, password })
        });

        const data = await response.json();

        if (response.ok) {
            document.getElementById('login-error').textContent = '';
            localStorage.setItem('token', data.accessToken);
            window.location.href = '/thome';
        } else {
            document.getElementById('login-error').textContent = data.message;
        }
    } catch (error) {
        // console.error('Error:', error);
    }
});


