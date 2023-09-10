document.addEventListener("DOMContentLoaded", function () {
  const meetingForm = document.getElementById("meeting-form");
  meetingForm.addEventListener("submit", function (e) {
    e.preventDefault();

    // Implement validation and booking logic based on the business rules here
    const title = document.getElementById("title").value;
    const meetingDate = document.getElementById("meeting-date").value;
    const startTime = document.getElementById("start-time").value;
    const duration = parseInt(document.getElementById("duration").value);
    const meetingType = document.getElementById("meeting-type").value;
    const members = document.getElementById("members").value;
    const meetingRoom = document.getElementById("meeting-room").value;

    // Check if the meeting date and time are later than the current date and time
    const currentDateTime = new Date();
    const selectedDateTime = new Date(`${meetingDate}T${startTime}`);
    if (selectedDateTime <= currentDateTime) {
      alert(
        "Meeting date and time should be later than the current date and time."
      );
      return;
    }

    // Implement further validation and booking logic based on the business rules
    // You'll need to check meeting room availability, seating capacity, manager's credits, amenities, and generate a unique ID
    // Display success or error messages to the user accordingly

    // For demonstration purposes, you can display a success message in a styled popup
    const successPopup = document.createElement("div");
    successPopup.className = "success-popup";
    successPopup.textContent = "Meeting successfully organized and booked.";

    document.body.appendChild(successPopup);

    // Clear the form after booking
    meetingForm.reset();
  });

  const cancelButton = document.getElementById("cancel-button");
  cancelButton.addEventListener("click", function () {
    // Implement cancel action, e.g., navigate to a different page or reset the form
    const confirmCancel = confirm(
      "Are you sure you want to cancel? Any unsaved changes will be lost."
    );
    if (confirmCancel) {
      meetingForm.reset(); // Clear the form
    }
  });
});
