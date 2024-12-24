function validateForm() {
    const country = document.getElementById("country").value.trim();
    const city = document.getElementById("city").value.trim();
    const numberOfVisitors = document.getElementById("numberOfVisitors").value;
    const budget = document.getElementById("budget").value;
    const name = document.getElementById("name").value.trim();
    const date = document.getElementById("date").value;

    // Regular expression to allow only alphabets and spaces
    const charOnlyRegex = /^[a-zA-Z\s]+$/;

    // Check for missing fields and provide specific alerts
    if (!country) {
        alert("Please fill out the Country field.");
        return false;
    }

    if (!charOnlyRegex.test(country)) {
        alert("Country field must contain only letters and spaces.");
        return false;
    }

    if (!city) {
        alert("Please fill out the City field.");
        return false;
    }

    if (!charOnlyRegex.test(city)) {
        alert("City field must contain only letters and spaces.");
        return false;
    }

    if (!numberOfVisitors) {
        alert("Please fill out the Number of Visitors field.");
        return false;
    }

    if (!/^\d+$/.test(numberOfVisitors) || Number(numberOfVisitors) <= 0) {
        alert("Number of Visitors must be a valid positive number.");
        return false;
    }

    if (!budget) {
        alert("Please fill out the Budget field.");
        return false;
    }

    if (!/^\d+$/.test(budget) || Number(budget) <= 0) {
        alert("Budget must be a valid positive number.");
        return false;
    }

    if (name && !charOnlyRegex.test(name)) {
        alert("Location Name field must contain only letters and spaces if provided.");
        return false;
    }

    if (!date) {
        alert("Please select an Event Date.");
        return false;
    }

    // All validations passed
    return true;
}
