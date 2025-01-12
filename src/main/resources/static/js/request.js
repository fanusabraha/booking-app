// Get the modal and close button elements
const contactModal = document.getElementById('contactModal');

// Function to open the contact modal
function openContactModal() {
    contactModal.style.display = 'block';
}

// Function to close the contact modal
function closeContactModal() {
    contactModal.style.display = 'none';
}

// Close the modal if the user clicks anywhere outside of it
window.onclick = function (event) {
    if (event.target === contactModal) {
        closeContactModal();
    }
};
