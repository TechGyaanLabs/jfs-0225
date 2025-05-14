// API Base URL
const API_BASE_URL = 'http://localhost:8081/api/v1/contacts';

// DOM Elements
const contactsTableBody = document.getElementById('contactsTableBody');
const contactForm = document.getElementById('contactForm');
const searchInput = document.getElementById('searchInput');
const searchBtn = document.getElementById('searchBtn');
const downloadJsonBtn = document.getElementById('downloadJson');
const saveContactBtn = document.getElementById('saveContact');
const confirmDeleteBtn = document.getElementById('confirmDelete');

// Bootstrap Modal instances
const contactModal = new bootstrap.Modal(document.getElementById('contactModal'));
const deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));

// State
let currentContactId = null;

// Initialize the application
document.addEventListener('DOMContentLoaded', () => {
    loadContacts();
    setupEventListeners();
});

// Setup event listeners
function setupEventListeners() {
    // Search
    searchBtn.addEventListener('click', () => {
        const searchTerm = searchInput.value.trim();
        if (searchTerm) {
            searchContacts(searchTerm);
        }
    });

    searchInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') {
            searchBtn.click();
        }
    });

    // Form submission
    saveContactBtn.addEventListener('click', saveContact);

    // Download JSON
    downloadJsonBtn.addEventListener('click', downloadContacts);

    // Delete confirmation
    confirmDeleteBtn.addEventListener('click', deleteContact);
}

// Load all contacts
async function loadContacts() {
    try {
        showSpinner();
        const response = await fetch(API_BASE_URL + '/all');
        const contacts = await response.json();
        renderContacts(contacts);
    } catch (error) {
        showToast('Error loading contacts', 'error');
    } finally {
        hideSpinner();
    }
}

// Search contacts
async function searchContacts(searchTerm) {
    try {
        showSpinner();
        const response = await fetch(`${API_BASE_URL}/search?str=${encodeURIComponent(searchTerm)}`);
        const contacts = await response.json();
        renderContacts(contacts);
    } catch (error) {
        showToast('Error searching contacts', 'error');
    } finally {
        hideSpinner();
    }
}

// Save contact (create/update)
async function saveContact() {
    if (!contactForm.checkValidity()) {
        contactForm.classList.add('was-validated');
        return;
    }

    const contactData = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        mobile: document.getElementById('mobile').value,
        dob: document.getElementById('dob').value
    };

    try {
        showSpinner();
        const url = currentContactId 
            ? `${API_BASE_URL}`
            : API_BASE_URL;
        
        const method = currentContactId ? 'PUT' : 'POST';
        if (currentContactId) {
            contactData.id = currentContactId;
        }

        const response = await fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contactData)
        });

        if (response.ok) {
            contactModal.hide();
            loadContacts();
            showToast(`Contact ${currentContactId ? 'updated' : 'added'} successfully`, 'success');
            resetForm();
        } else {
            throw new Error('Failed to save contact');
        }
    } catch (error) {
        showToast('Error saving contact', 'error');
    } finally {
        hideSpinner();
    }
}

// Delete contact
async function deleteContact() {
    if (!currentContactId) return;

    try {
        showSpinner();
        const response = await fetch(`${API_BASE_URL}/${currentContactId}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            deleteModal.hide();
            loadContacts();
            showToast('Contact deleted successfully', 'success');
        } else {
            throw new Error('Failed to delete contact');
        }
    } catch (error) {
        showToast('Error deleting contact', 'error');
    } finally {
        hideSpinner();
    }
}

// Download contacts as JSON
function downloadContacts() {
    window.location.href = `${API_BASE_URL}/download?fileType=JSON`;
}

// Edit contact
function editContact(contact) {
    currentContactId = contact.id;
    document.getElementById('name').value = contact.name;
    document.getElementById('email').value = contact.email;
    document.getElementById('mobile').value = contact.mobile;
    document.getElementById('dob').value = contact.dob;
    document.getElementById('modalTitle').textContent = 'Edit Contact';
    contactModal.show();
}

// Prepare for delete
function prepareDelete(contactId) {
    currentContactId = contactId;
    deleteModal.show();
}

// Reset form
function resetForm() {
    contactForm.reset();
    contactForm.classList.remove('was-validated');
    currentContactId = null;
    document.getElementById('modalTitle').textContent = 'Add Contact';
}

// Render contacts in table
function renderContacts(contacts) {
    contactsTableBody.innerHTML = contacts.map(contact => `
        <tr>
            <td>${contact.name}</td>
            <td>${contact.email}</td>
            <td>${contact.mobile}</td>
            <td>${formatDate(contact.dob)}</td>
            <td class="action-buttons">
                <button class="btn btn-sm btn-primary" onclick="editContact(${JSON.stringify(contact)})">
                    <i class="fas fa-edit"></i>
                </button>
                <button class="btn btn-sm btn-danger" onclick="prepareDelete('${contact.id}')">
                    <i class="fas fa-trash"></i>
                </button>
            </td>
        </tr>
    `).join('');
}

// Format date
function formatDate(dateString) {
    return new Date(dateString).toLocaleDateString();
}

// Show spinner
function showSpinner() {
    const spinner = document.createElement('div');
    spinner.className = 'spinner-overlay';
    spinner.innerHTML = '<div class="spinner-border text-primary" role="status"></div>';
    document.body.appendChild(spinner);
}

// Hide spinner
function hideSpinner() {
    const spinner = document.querySelector('.spinner-overlay');
    if (spinner) {
        spinner.remove();
    }
}

// Show toast notification
function showToast(message, type = 'info') {
    const toastContainer = document.querySelector('.toast-container') || createToastContainer();
    const toast = document.createElement('div');
    toast.className = `toast show bg-${type === 'error' ? 'danger' : type} text-white`;
    toast.innerHTML = `
        <div class="toast-body">
            ${message}
        </div>
    `;
    toastContainer.appendChild(toast);
    setTimeout(() => toast.remove(), 3000);
}

// Create toast container
function createToastContainer() {
    const container = document.createElement('div');
    container.className = 'toast-container';
    document.body.appendChild(container);
    return container;
} 