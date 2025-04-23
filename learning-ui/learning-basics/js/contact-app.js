const contacts = [];
function addContact(event) {
    console.log("Adding Contact");
    event.preventDefault();
    // Get form values
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const mobile = document.getElementById('mobile').value;
    const dob = document.getElementById('dob').value;

    // Create contact object
    const contact = {
        name: name,
        email: email,
        mobile: mobile,
        dob: dob
    };

    // Add to contacts array
    contacts.push(contact);
    console.log(contact);

    // Reset form
    document.getElementById('contactForm').reset();
    showContacts();
}

function showContacts(){

    // name, email, mobile, dob show it as bootstrap table with delete and edit buttons

    const contactList = document.getElementById('contactList');
    // create table with headings
    contactList.innerHTML = `
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
            <tbody id="contactListBody">
            </tbody>
        </table>
    `;
    contacts.forEach((contact, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${contact.name}</td>
            <td>${contact.email}</td>
            <td>${contact.mobile}</td>
            <td>${contact.dob}</td>
            <td>
                <button class="btn btn-danger" onclick="deleteContact(${index})">Delete</button>
                <button class="btn btn-primary" onclick="editContact(${index})">Edit</button>
            </td>
        `;
        contactList.appendChild(row);
    });
    // Show the contact list
    console.log(contactList)

}

showContacts();