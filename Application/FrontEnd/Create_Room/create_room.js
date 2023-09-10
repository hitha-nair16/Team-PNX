function validateForm() {
    const amenitiesCheckboxes = document.querySelectorAll('input[name="amenities"]:checked');
    if (amenitiesCheckboxes.length < 2) {
        alert("Please select at least 2 amenities.");
        event.preventDefault(); // Prevent form submission if validation fails
    }
}