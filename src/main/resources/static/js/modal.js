// Modal Logic
document.addEventListener('DOMContentLoaded', () => {
    const modal = document.getElementById('bookingModal');
    const form = document.getElementById('bookingForm');

    // Open modal
    window.openModal = function (eventId) {
        const modal = document.getElementById('bookingModal');
        const form = document.getElementById('bookingForm');
        modal.style.display = 'block';
        form.setAttribute('action', `http://localhost:9090/api/bookings/book/${eventId}`);
    };

    // Close modal
    window.closeModal = function () {
        modal.style.display = 'none';
    };

    // Close modal when clicking outside of it
    window.onclick = function (event) {
        if (event.target === modal) {
            closeModal();
        }
    };
});
