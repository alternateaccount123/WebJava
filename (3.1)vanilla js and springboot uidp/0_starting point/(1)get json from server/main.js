const fetchButton = document.getElementById('fetchButton');
const responseDiv = document.getElementById('response');

        fetchButton.addEventListener('click', () => {
            fetch('/message')
                .then(response => response.json())
                .then(data => {
                    responseDiv.innerText = data.brand;
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        });
