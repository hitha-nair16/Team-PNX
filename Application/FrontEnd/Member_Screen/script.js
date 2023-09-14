// Dummy meeting schedule data
const schedules = [
  {
    title: "Team Meeting",
    date: "2023-09-15",
    time: "10:00 AM - 11:30 AM",
    location: "Conference Room 1",
  },
  {
    title: "Project Presentation",
    date: "2023-09-17",
    time: "2:00 PM - 3:30 PM",
    location: "Presentation Room 1",
  },
  // Add more schedule items as needed
];

// Function to render meeting schedules
function renderSchedules() {
  const scheduleList = document.getElementById("schedule-list");

  schedules.forEach((schedule) => {
    const scheduleItem = document.createElement("div");
    scheduleItem.classList.add("schedule-item");
    scheduleItem.innerHTML = `
          <h3>${schedule.title}</h3>
          <p class="date">Date: ${schedule.date}</p>
          <p class="time">Time: ${schedule.time}</p>
          <p>Location: ${schedule.location}</p>
      `;
    scheduleList.appendChild(scheduleItem);
  });
}

// Render meeting schedules when the page loads
window.addEventListener("load", renderSchedules);
