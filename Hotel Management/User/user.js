$('.carousel').carousel({
    interval: 2000 // Slide every 5 seconds
});



// Booking
document.querySelector(".btn-dark").addEventListener("click", function () {
    const property = document.getElementById("propertySelect").value;
    const checkIn = document.getElementById("checkInDate").value;
    const checkOut = document.getElementById("checkOutDate").value;

    if (property === "Select Any Hotel" || !checkIn || !checkOut) {
        alert("Please fill all the fields before booking.");
    } else if (new Date(checkIn) >= new Date(checkOut)) {
        alert("Check-Out date must be after the Check-In date.");
    } else {
        alert(`Booking successful for ${property} from ${checkIn} to ${checkOut}`);
    }
});
