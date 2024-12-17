document.addEventListener("DOMContentLoaded", () => {
    const slideshows = document.querySelectorAll(".slideshow-container");

    slideshows.forEach((slideshow) => {
        let currentIndex = 0;
        const slides = slideshow.querySelectorAll(".slide");

        // Show the first slide initially
        showSlide(currentIndex, slides);

        // Add event listeners to buttons
        const prevButton = slideshow.querySelector(".prev");
        const nextButton = slideshow.querySelector(".next");

        prevButton.addEventListener("click", () => {
            currentIndex = (currentIndex - 1 + slides.length) % slides.length;
            showSlide(currentIndex, slides);
        });

        nextButton.addEventListener("click", () => {
            currentIndex = (currentIndex + 1) % slides.length;
            showSlide(currentIndex, slides);
        });
    });

    /**
     * Shows the slide at the specified index and hides the others.
     * @param {number} index The index of the slide to show.
     * @param {NodeList} slides The list of slide elements.
     */
    function showSlide(index, slides) {
        slides.forEach((slide, i) => {
            slide.style.display = i === index ? "block" : "none";
        });
    }
});
