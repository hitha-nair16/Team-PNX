// Sample data for rooms (you can replace this with your actual data)
const roomsData = {
    room1: {
        name: "Room 1",
        seatingCapacity: 20,
        amenities: ["Projector", "Wi-Fi Connection"]
    },
    room2: {
        name: "Room 2",
        seatingCapacity: 15,
        amenities: ["Wi-Fi Connection", "Whiteboard"]
    }
    // Add more rooms as needed
};

const roomSelect = document.getElementById("roomSelect");
const roomNameInput = document.getElementById("roomName");
const seatingCapacityInput = document.getElementById("seatingCapacity");
const amenitiesCheckboxes = document.querySelectorAll('input[name="amenities"]');
const saveButton = document.querySelector('input[type="submit"]');

// Disable inputs and save button initially
roomSelect.addEventListener("change", () => {
    const selectedRoom = roomsData[roomSelect.value];
    if (selectedRoom) {
       
        roomNameInput.value = selectedRoom.name;
        // document.getElementById("labelName").style.top = "0%";
   
        seatingCapacityInput.value = selectedRoom.seatingCapacity;

        // Check amenities checkboxes based on the selected room's amenities
        amenitiesCheckboxes.forEach(checkbox => {
            checkbox.checked = selectedRoom.amenities.includes(checkbox.value);
        });

        // Enable inputs and save button
        seatingCapacityInput.disabled = false;
        amenitiesCheckboxes.forEach(checkbox => {
            checkbox.disabled = false;
        });
        saveButton.disabled = false;
    } else {
        // Reset inputs and disable them if no room is selected
        roomNameInput.value = "";
        seatingCapacityInput.value = "";
        amenitiesCheckboxes.forEach(checkbox => {
            checkbox.checked = false;
            checkbox.disabled = true;
        });
        saveButton.disabled = true;
    }
});

function validateForm() {
    const amenitiesCheckboxesChecked = document.querySelectorAll('input[name="amenities"]:checked');
    if (amenitiesCheckboxesChecked.length < 2) {
        alert("Please select at least 2 amenities.");
        event.preventDefault(); // Prevent form submission if validation fails
    }
}