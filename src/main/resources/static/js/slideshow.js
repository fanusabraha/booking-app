document.addEventListener("DOMContentLoaded", () => {
    // Select all slideshow containers
    const slideshows = document.querySelectorAll(".slideshow-container");

    slideshows.forEach((slideshow, index) => {
        let currentSlideIndex = 0;
        const slides = slideshow.querySelectorAll(".slide");

        // Initialize: Show the first slide
        showSlide(currentSlideIndex, slides);

        // Add event listeners to the buttons within this slideshow
        const prevButton = slideshow.querySelector(".prev");
        const nextButton = slideshow.querySelector(".next");

        prevButton.addEventListener("click", () => {
            currentSlideIndex = (currentSlideIndex - 1 + slides.length) % slides.length;
            showSlide(currentSlideIndex, slides);
        });

        nextButton.addEventListener("click", () => {
            currentSlideIndex = (currentSlideIndex + 1) % slides.length;
            showSlide(currentSlideIndex, slides);
        });

        // Function to display the current slide and hide others
        function showSlide(index, slides) {
            slides.forEach((slide, i) => {
                slide.style.display = i === index ? "block" : "none";
            });
        }
    });
});
