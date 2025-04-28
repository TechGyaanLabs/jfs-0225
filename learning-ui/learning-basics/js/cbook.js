const baseUrl = 'https://cbook-ucg6.onrender.com/api/contact'

// API signature

// Get all contacts : https://cbook-ucg6.onrender.com/api/contact/all
// Get contact by id : https://cbook-ucg6.onrender.com/api/contact/:id
// Add contact POST : https://cbook-ucg6.onrender.com/api/contact
// Update contact PUT : https://cbook-ucg6.onrender.com/api/contact
// Delete contact DELETE : https://cbook-ucg6.onrender.com/api/contact/:id


const idContactBookTable = document.getElementById('contactBookTable');

function showContacts(contacts) {
    if(!contacts || contacts.length === 0) {
        idContactBookTable.innerHTML = '<p>No contacts found.</p>';
        return;
    }
    let table = `
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Mobile</th>
                    <th>DOB</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>`;
    contacts.forEach(contact => {
        table += `
            <tr>
                <td>${contact.fullName}</td>
                <td>${contact.email}</td>
                <td>${contact.mobile}</td>
                <td>${contact.dob}</td>
                <td>
                    <button class="btn btn-danger" onclick="deleteContact('${contact.id}')">Delete</button>
                    <button class="btn btn-primary" onclick="editContact('${contact.id}')">Edit</button>
                </td>
            </tr>`;
    });
    table += `
            </tbody>
        </table>`;
    idContactBookTable.innerHTML = table;
}


function fetchContacts() {
    fetch(`${baseUrl}/all`)
        .then(response => response.json())
        .then(data => {
            showContacts(data);
        })
        .catch(error => {
            console.error('Error fetching contacts:', error);
        });
}



fetchContacts();