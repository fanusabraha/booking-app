const images = [
    '/images/ABC.jpg',
    '/images/BB.jpg',
    '/images/CC.jpg' // Add more image paths as needed
];

let currentIndex = 0;

function changeBackground() {
    document.body.style.backgroundImage = `url(${images[currentIndex]})`;
    currentIndex = (currentIndex + 1) % images.length;
}

// Change background every 5 seconds
setInterval(changeBackground, 5000);
document.addEventListener('DOMContentLoaded', changeBackground);
