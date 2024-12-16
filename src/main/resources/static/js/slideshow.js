let slideIndex = 0;

// Show the first slide
showSlide(slideIndex);

function changeSlide(n) {
    showSlide(slideIndex += n);
}

function showSlide(n) {
    let slides = document.getElementsByClassName("slide");

    if (n >= slides.length) {
        slideIndex = 0; // Loop back to the first slide
    } else if (n < 0) {
        slideIndex = slides.length - 1; // Loop to the last slide
    }

    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }

    slides[slideIndex].style.display = "block";
}
