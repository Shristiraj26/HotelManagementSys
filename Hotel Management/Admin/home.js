document.getElementById("addRoomButton").addEventListener("click", function () {
    const roomNumber = document.getElementById("roomNumber").value;
    const roomType = document.getElementById("roomType").value;
    const bedType = document.getElementById("bedType").value;
    const price = document.getElementById("price").value;
    const roomStatus = document.getElementById("roomStatus").value; // New field

    if (roomNumber && roomType && bedType && price && roomStatus) {
        const tableBody = document.getElementById("roomTableBody");
        const newRow = document.createElement("tr");

        newRow.innerHTML = `
            <td>${roomNumber}</td>
            <td>${roomType}</td>
            <td>${bedType}</td>
            <td>${price}</td>
            <td>${roomStatus}</td>
        `;

        // Add double-click event for row update
        newRow.addEventListener("dblclick", function () {
            updateRow(newRow);
        });

        tableBody.appendChild(newRow);

        // Clear input fields
        document.getElementById("addRoomForm").reset();
    } else {
        alert("Please fill in all fields!");
    }
});

// Function to update a row
function updateRow(row) {
    const cells = row.getElementsByTagName("td");
    const roomNumber = cells[0].innerText;
    const roomType = cells[1].innerText;
    const bedType = cells[2].innerText;
    const price = cells[3].innerText;
    const roomStatus = cells[4].innerText;

    document.getElementById("roomNumber").value = roomNumber;
    document.getElementById("roomType").value = roomType;
    document.getElementById("bedType").value = bedType;
    document.getElementById("price").value = price;
    document.getElementById("roomStatus").value = roomStatus;

    row.remove();
}


// Check in
document.addEventListener("DOMContentLoaded", function () {
    const checkinDate = document.getElementById("checkinDate");
    const today = new Date().toISOString().split("T")[0];
    checkinDate.value = today;
});


// Check-out
document.getElementById("searchButton").addEventListener("click", function () {
    // Example data for demonstration
    const roomData = {
        101: {
            name: "Sudhir Kushwaha",
            mobile: "8540092862",
            email: "sudhir@gmail.com",
            pricePerDay: 250,
            checkInDate: "2022-05-08",
        },
    };

    const roomNumber = document.getElementById("roomNumber").value;
    const data = roomData[roomNumber];

    if (data) {
        document.getElementById("customerName").value = data.name;
        document.getElementById("customerMobile").value = data.mobile;
        document.getElementById("pricePerDay").value = data.pricePerDay;
        document.getElementById("checkInDate").value = data.checkInDate;

        // Calculate number of days and total amount
        const today = new Date();
        const checkInDate = new Date(data.checkInDate);
        const days = Math.ceil((today - checkInDate) / (1000 * 60 * 60 * 24));
        document.getElementById("numberOfDays").value = days;
        document.getElementById("totalAmount").value = days * data.pricePerDay;
        document.getElementById("checkOutDate").value = today.toISOString().split("T")[0];
    } else {
        alert("Room data not found!");
    }
});



// Open Logout Modal
document.getElementById("logoutButton").addEventListener("click", function () {
    const logoutModal = new bootstrap.Modal(document.getElementById("logoutModal"));
    logoutModal.show();
});

// Handle Logout Confirmation
document.getElementById("confirmLogoutButton").addEventListener("click", function () {
    // Redirect to login page or perform logout logic here
    alert("You have logged out successfully!"); // Placeholder
    window.location.href = "login.html"; // Example redirect
});
