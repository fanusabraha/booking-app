// JavaScript for slideshow and modal view

// Slideshow navigation logic
function prevSlide(slideshowContainer) {
    const slides = slideshowContainer.querySelectorAll('.slide');
    let currentSlideIndex = Array.from(slides).findIndex(slide => slide.style.display === 'block');

    slides[currentSlideIndex].style.display = 'none';
    const prevSlideIndex = (currentSlideIndex - 1 + slides.length) % slides.length;
    slides[prevSlideIndex].style.display = 'block';
}

function nextSlide(slideshowContainer) {
    const slides = slideshowContainer.querySelectorAll('.slide');
    let currentSlideIndex = Array.from(slides).findIndex(slide => slide.style.display === 'block');

    slides[currentSlideIndex].style.display = 'none';
    const nextSlideIndex = (currentSlideIndex + 1) % slides.length;
    slides[nextSlideIndex].style.display = 'block';
}

// Modal view logic
function openModal(imageSrc) {
    // Create modal elements dynamically
    const modal = document.createElement('div');
    modal.id = 'image-modal';
    modal.style.position = 'fixed';
    modal.style.top = '0';
    modal.style.left = '0';
    modal.style.width = '100%';
    modal.style.height = '100%';
    modal.style.backgroundColor = 'rgba(0, 0, 0, 0.8)';
    modal.style.display = 'flex';
    modal.style.justifyContent = 'center';
    modal.style.alignItems = 'center';
    modal.style.zIndex = '1000';

    const img = document.createElement('img');
    img.src = imageSrc;
    img.style.maxWidth = '90%';
    img.style.maxHeight = '90%';
    img.style.border = '2px solid white';

    const closeBtn = document.createElement('span');
    closeBtn.innerHTML = '&times;';
    closeBtn.style.position = 'absolute';
    closeBtn.style.top = '20px';
    closeBtn.style.right = '20px';
    closeBtn.style.fontSize = '30px';
    closeBtn.style.color = 'white';
    closeBtn.style.cursor = 'pointer';

    closeBtn.onclick = function () {
        document.body.removeChild(modal);
    };

    modal.appendChild(img);
    modal.appendChild(closeBtn);
    document.body.appendChild(modal);
}

// Ensure the first slide is visible by default
document.addEventListener('DOMContentLoaded', function () {
    const slideshows = document.querySelectorAll('.slideshow-container');
    slideshows.forEach(slideshow => {
        const slides = slideshow.querySelectorAll('.slide');
        if (slides.length > 0) {
            slides[0].style.display = 'block'; // Show the first slide
        }
    });
});
