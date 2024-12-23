const images = [
    '/images/image1.jpg',
    '/images/image2.jpg',
    '/images/image3.jpg' // Add more image paths as needed
];

let currentIndex = 0;

function changeBackground() {
    const slideshow = document.querySelector('.background-slideshow');
    slideshow.innerHTML = images
        .map((src, index) => `<img src="${src}" class="${index === currentIndex ? 'active' : ''}" alt="Background Image">`)
        .join('');

    currentIndex = (currentIndex + 1) % images.length;
}

setInterval(changeBackground, 5000); // Change every 5 seconds
document.addEventListener('DOMContentLoaded', changeBackground);
