const fetchButton = document.getElementById('fetchButton');
const responseDiv = document.getElementById('response');

        fetchButton.addEventListener('click', () => {
            fetch('/api/message')
                .then(response => response.text())
                .then(message => {
                    responseDiv.innerText = message;
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        });
