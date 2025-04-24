
function addContact(event) {
    event.preventDefault();
    // Get form values
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const mobile = document.getElementById('mobile').value;
    const dob = document.getElementById('dob').value;
    document.getElementById('email').removeAttribute('readonly');

    // Create contact object
    const contact = {
        name: name,
        email: email,
        mobile: mobile,
        dob: dob
    };

    localStorage.getItem('contacts') === null ? contacts = [] : contacts = JSON.parse(localStorage.getItem('contacts'));

    // Add to contacts array
    contacts.push(contact);
    // Save to local storage
    localStorage.setItem('contacts', JSON.stringify(contacts));

    // Reset form
    document.getElementById('contactForm').reset();
    showContacts();
}

function showContacts(){

    // name, email, mobile, dob show it as bootstrap table with delete and edit buttons

    const contactList = document.getElementById('contactList');
    contacts = localStorage.getItem('contacts') === null ? [] : JSON.parse(localStorage.getItem('contacts'));
    if(contacts.length === 0){
        contactList.innerHTML = "<p>No contacts available</p>";
        return;
    }else{
        contactList.innerHTML = ""
        let table = `<table class="table table-striped">
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
        contacts.forEach((contact, index) => {
            table += `<tr>
                <td>${contact.name}</td>
                <td>${contact.email}</td>
                <td>${contact.mobile}</td>
                <td>${contact.dob}</td>
                <td>
                    <button class="btn btn-danger" onclick="deleteContact('${contact.email}')">Delete</button>
                    <button class="btn btn-primary" onclick="editContact('${contact.email}')">Edit</button>
                </td>
            </tr>`;
        });
        table += `</tbody>
        </table>`;  
        contactList.innerHTML = table;
    }
}

function editContact(email){
    contacts = JSON.parse(localStorage.getItem('contacts'));
    const contact = contacts.find(contact => contact.email === email);
    if(contact){
        document.getElementById('name').value = contact.name;
        document.getElementById('email').value = contact.email;
        document.getElementById('email').setAttribute('readonly', true);
        document.getElementById('mobile').value = contact.mobile;
        document.getElementById('dob').value = contact.dob
    }
    document.getElementById('updateBtn').style.display = 'block';
    document.getElementById('addBtn').style.display = 'none';
}

function updateContact(event){
    event.preventDefault();
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const mobile = document.getElementById('mobile').value;
    const dob = document.getElementById('dob').value;
    contacts = JSON.parse(localStorage.getItem('contacts'));
    const contactIndex = contacts.findIndex(contact => contact.email === email);
    if(contactIndex !== -1){
        contacts[contactIndex].name = name;
        contacts[contactIndex].mobile = mobile;
        contacts[contactIndex].dob = dob;
        localStorage.setItem('contacts', JSON.stringify(contacts));
        document.getElementById('contactForm').reset();
        document.getElementById('updateBtn').style.display = 'none';
        document.getElementById('addBtn').style.display = 'block';
        showContacts();
    }
    else{
        alert('Contact not found');
    }
}

function deleteContact(email){
    response =  confirm(`Are you sure you want to delete contact with email ${email}?`);
    if(response){
        contacts = JSON.parse(localStorage.getItem('contacts'));
        contacts = contacts.filter(contact => contact.email !== email);
        localStorage.setItem('contacts', JSON.stringify(contacts));
        showContacts();
    }
}

showContacts();

function resetForm(event){
    event.preventDefault();
    document.getElementById('contactForm').reset();
    document.getElementById('updateBtn').style.display = 'none';
    document.getElementById('addBtn').style.display = 'block';
    document.getElementById('email').removeAttribute('readonly');
}


// Add event listener to form
document.getElementById('addBtn').addEventListener('click', addContact);
document.getElementById('updateBtn').addEventListener('click', updateContact);
document.getElementById('resetBtn').addEventListener('click',resetForm);