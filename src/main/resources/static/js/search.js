// Real-time search logic
document.querySelectorAll("#country, #location, #city, #numberOfVisitors, #budget, #date").forEach(input => {
    input.addEventListener("input", searchEvents);
});

function searchEvents() {
    const country = document.getElementById("country").value;
    const location = document.getElementById("location").value;
    const city = document.getElementById("city").value;
    const numberOfVisitors = document.getElementById("numberOfVisitors").value;
    const budget = document.getElementById("budget").value;
    const date = document.getElementById("date").value;

    const params = new URLSearchParams({
        country,
        location,
        city,
        numberOfVisitors,
        budget,
        date
    });

    fetch(`/event/search?${params.toString()}`)
        .then(response => response.json())
        .then(data => updateResults(data))
        .catch(error => console.error('Error fetching events:', error));
}

function updateResults(events) {
    const resultsContainer = document.getElementById("results");
    resultsContainer.innerHTML = ""; // Clear previous results

    if (events.length === 0) {
        resultsContainer.innerHTML = "<p>No matching events found</p>";
        return;
    }

    const ul = document.createElement("ul");
    events.forEach(event => {
        const li = document.createElement("li");
        li.innerHTML = `
            <strong>Country:</strong> ${event.country} <br>
            <strong>Location:</strong> ${event.location} <br>
            <strong>City:</strong> ${event.city} <br>
            <strong>Capacity:</strong> ${event.capacity} <br>
            <strong>Budget:</strong> ${event.budget} <br>
            <strong>Date:</strong> ${event.date}
        `;
        ul.appendChild(li);
    });
    resultsContainer.appendChild(ul);
}

// Form validation
function validateForm(event) {
    const numberOfVisitors = document.getElementById("numberOfVisitors").value;
    const country = document.getElementById("country").value.trim();
    const location = document.getElementById("location").value.trim();
    const city = document.getElementById("city").value.trim();
    const date = document.getElementById("date").value;

    // Validate inputs
    if (!/^\d+$/.test(numberOfVisitors)) {
        alert("Number of Visitors must be a valid number.");
        event.preventDefault();
        return false;
    }

    if (!country || !location || !city || !date) {
        alert("All fields are required. Please fill out all fields.");
        event.preventDefault();
        return false;
    }

    return true;
}
