AOS.init({
    // Settings that can be overridden on per-element basis, by `data-aos-*` attributes:
    offset: 120, // offset (in px) from the original trigger point
    delay: 0, // values from 0 to 3000, with step 50ms
    duration: 900, // values from 0 to 3000, with step 50ms
    easing: 'ease', // default easing for AOS animations
    once: false, // whether animation should happen only once - while scrolling down
    mirror: false, // whether elements should animate out while scrolling past them
    anchorPlacement: 'top-bottom', // defines which position of the element regarding to window should trigger the animation
});
$(document).ready(function () {
    var internals = {
        handlers: {},
        elements: {},
        currentSlide: 0
    };
    var externals = {};
    internals.createButton = function () {
        return '<div class="random-film"></div>';
    };
    internals.createSlide = function (event) {
        var slideHtml =
            '<div class="slide">' +
            '<div class="custom-card">' +
            '<h4 class="custom-header">' + event.title + '</h4>' +
            '<p class="custom-text">Venue: ' + event.venue.display_location + '</p>' +
            '<p class="custom-text">Location: ' + event.venue.name + '</p>' +
            '<p class="custom-text">Concert Date: ' + event.datetime_local + '</p>' +
            '<p class="custom-text">Event URL: <a href="' + event.url + '" target="_blank">Ticket Here</a></p>' +
            '</div>' +
            '</div>';
        return slideHtml;
    };
    internals.showSlide = function (index) {
        var slides = $(".slide");
        if (index >= 0 && index < slides.length) {
            internals.currentSlide = index;
            slides.hide();
            slides.eq(internals.currentSlide).show();
        }
    };
    internals.nextSlide = function () {
        internals.showSlide(internals.currentSlide + 1);
    };
    internals.prevSlide = function () {
        internals.showSlide(internals.currentSlide - 1);
    };
    internals.renderButton = function () {
        if (internals.elements.button) {
            return;
        }
        internals.elements.button = $(internals.createButton());
        internals.elements.button.click(internals.handlers['button']);
        internals.elements.app.append(internals.elements.button);
    };
    externals.bind = function (event, handler) {
        internals.handlers[event] = handler;
    };
    externals.render = function (concertInfo) {
        internals.elements.app = $('#app');
        internals.renderButton();
        if (concertInfo) {
            concertInfo.events.forEach(function (event) {
                internals.elements.app.append(internals.createSlide(event));
            });
            internals.showSlide(0);
        }
    };
    // API call
    var base_url = "https://api.seatgeek.com/2/";
    var endpoint = "events";
    var client_id = "MzU3MzU4MTF8MTY5MjE5NDcwOS45MzczMTQ3";
    var params = {
        "performers.slug": "metallica",
        "q": "Metallica",
        "client_id": client_id
    };
    $.ajax({
        url: base_url + endpoint,
        data: params,
        dataType: "json",
        success: externals.render
    });
    $(".prev-button").click(internals.prevSlide);
    $(".next-button").click(internals.nextSlide);
});










