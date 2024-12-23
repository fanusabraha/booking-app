const images = [
    '/images/image1.jpg',
    '/images/image2.jpg',
    '/images/image3.jpg' // Add more image paths as needed
];

let currentIndex = 0;

function changeBackground() {
    document.body.style.backgroundImage = `url(${images[currentIndex]})`;
    currentIndex = (currentIndex + 1) % images.length;
}

// Change background every 5 seconds
setInterval(changeBackground, 5000);
document.addEventListener('DOMContentLoaded', changeBackground);
