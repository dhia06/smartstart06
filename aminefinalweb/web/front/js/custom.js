/***************************************************************************************************************
||||||||||||||||||||||||||||        CUSTOM SCRIPT FOR Wiscon          |||||||||||||||||||||||||||||||||||||
****************************************************************************************************************
||||||||||||||||||||||||||||              TABLE OF CONTENT                  ||||||||||||||||||||||||||||||||||||
****************************************************************************************************************
****************************************************************************************************************

02. Sticky header
03. Prealoader
06. BrandCarousel
07. Testimonial carousel
08. ScrollToTop 
12. Fancybox activator
13. ContactFormValidation
14. Scoll to target

****************************************************************************************************************
||||||||||||||||||||||||||||            End TABLE OF CONTENT                ||||||||||||||||||||||||||||||||||||
****************************************************************************************************************/


"use strict";


//Submenu Dropdown Toggle
if($('.main-header .navigation li.dropdown ul').length){
    $('.main-header .navigation li.dropdown').append('<div class="dropdown-btn"><span class="fa fa-caret-down"></span></div>');
    
    //Dropdown Button
    $('.main-header .navigation li.dropdown .dropdown-btn').on('click', function() {
        $(this).prev('ul').slideToggle(500);
    });
    
    //Disable dropdown parent link
    $('.navigation li.dropdown > a').on('click', function(e) {
        e.preventDefault();
    });
}

//===Header Sticky===
function stickyHeader() {
    if ($('.stricky').length) {
        var strickyScrollPos = 100;
        if ($(window).scrollTop() > strickyScrollPos) {
            $('.stricky').addClass('stricky-fixed');
            $('.scroll-to-top').fadeIn(500);
        } else if ($(this).scrollTop() <= strickyScrollPos) {
            $('.stricky').removeClass('stricky-fixed');
            $('.scroll-to-top').fadeOut(500);
        }
    };
}

    //Main Slider Carousel
    if ($('.main-slider-carousel').length) {
        $('.main-slider-carousel').owlCarousel({
            animateOut: 'fadeOut',
            animateIn: 'fadeIn',
            loop:true,
            margin:0,
            nav:true,
            autoHeight: true,
            smartSpeed: 500,
            autoplay: 6000,
            navText: [ '<span class="flaticon-left-arrow"></span>', '<span class="flaticon-right-arrow"></span>' ],
            responsive:{
                0:{
                    items:1
                },
                600:{
                    items:1
                },
                800:{
                    items:1
                },
                1024:{
                    items:1
                },
                1200:{
                    items:1
                }
            }
        });         
    }

//===scoll to Top===

if ($('.scroll-to-target').length) {
    $(".scroll-to-target").on('click', function() {
        var target = $(this).attr('data-target');
        // animate
        $('html, body').animate({
            scrollTop: $(target).offset().top
        }, 1000);

    });
}


//===Search box ===
function searchbox() {
    //Search Box Toggle
    if($('.seach-toggle').length){
        //Dropdown Button
        $('.seach-toggle').on('click', function() {
            $(this).toggleClass('active');
            $(this).next('.search-box').toggleClass('now-visible');
        });
    }
}

//13. Countdown Timer
if ($('.countdown').length) {
    $('.countdown').countdown('2019/5/1', function (event) {
        var $this = $(this).html(event.strftime('' + '<div class="counter-column"><span class="count">%D</span><br>Days</div> ' + '<div class="counter-column"><span class="count">%H</span><span class="colon"></span><br>Hours</div>  ' + '<div class="counter-column"><span class="count">%M</span><span class="colon"></span><br>Mutines</div>  ' + '<div class="counter-column"><span class="count">%S</span><span class="colon"></span><br>Seconds</div>'));
    });
}

// ===Schedule Tab===
function scheduleTab () {
    if ($('#schedule-tab .schedule-title').length) {
        var tabWrap = $('#schedule-tab .schedule-content');
        var tabClicker = $('#schedule-tab .schedule-title .item');
        
        tabWrap.children('div').hide();
        tabWrap.children('div').eq(0).show();
        tabClicker.on('click', function() {
            var tabName = $(this).data('tab-name');
            tabClicker.removeClass('active');
            $(this).addClass('active');
            var id = '#'+ tabName;
            tabWrap.children('div').not(id).hide();
            tabWrap.children('div'+id).fadeIn('5000');
            return false;
        });        
    }
}

// ===Schedule Tab===
function sponsorTab () {
    if ($('#sponsor-tab .tab-btn').length) {
        var tabWrap = $('#sponsor-tab .tab-content');
        var tabClicker = $('#sponsor-tab .tab-btn .btn');
        
        tabWrap.children('div').hide();
        tabWrap.children('div').eq(0).show();
        tabClicker.on('click', function() {
            var tabName = $(this).data('tab-name');
            tabClicker.removeClass('active');
            $(this).addClass('active');
            var id = '#'+ tabName;
            tabWrap.children('div').not(id).hide();
            tabWrap.children('div'+id).fadeIn('500');
            return false;
        });        
    }
}

// ===Project===
function projectMasonaryLayout() {
    if ($('.masonary-layout').length) {
        $('.masonary-layout').isotope({
            layoutMode: 'masonry'
        });
    }

    if ($('.post-filter').length) {
        $('.post-filter li').children('span').on('click', function() {
            var Self = $(this);
            var selector = Self.parent().attr('data-filter');
            $('.post-filter li').children('span').parent().removeClass('active');
            Self.parent().addClass('active');


            $('.filter-layout').isotope({
                filter: selector,
                animationOptions: {
                    duration: 500,
                    easing: 'linear',
                    queue: false
                }
            });
            return false;
        });
    }

    if ($('.post-filter.has-dynamic-filter-counter').length) {
        // var allItem = $('.single-filter-item').length;

        var activeFilterItem = $('.post-filter.has-dynamic-filter-counter').find('li');

        activeFilterItem.each(function() {
            var filterElement = $(this).data('filter');
            console.log(filterElement);
            var count = $('.project-content').find(filterElement).length;

            $(this).children('span').append('<span class="count"><b>' + count + '</b></span>');
        });
    };
}

//===Brand Carousel===
function brandCarousel () {
    if ($('.brand').length) {
        $('.brand').owlCarousel({
            dots: false,
            loop:true,
            margin:30,
            nav:true,
            navText: [
                '<i class="fa fa-angle-left"></i>',
                '<i class="fa fa-angle-right"></i>'
            ],
            autoplayHoverPause: false,
            autoplay: 6000,
            smartSpeed: 1000,
            responsive:{
                0:{
                    items:1
                },
                600:{
                    items:2
                },
                800:{
                    items:3
                },
                1024:{
                    items:4
                },
                1100:{
                    items:4
                },
                1200:{
                    items:5
                }
            }
        });         
    }
}

//===Testimonial Slider===
function testimonialSlider() {
    if ($('.testimonial-carousel').length) {
        $('.testimonial-carousel').owlCarousel({
            loop:true,
            margin:0,
            nav:true,
            dots: false,
            autoplayHoverPause:false,
            autoplay: 6000,
            smartSpeed: 700,
            navText: [ '<span class="fas fa-chevron-left"></span>', '<span class="fas fa-chevron-right"></span>' ],
            responsive:{
                0:{
                    items:1
                },
                600:{
                    items:1
                },
                800:{
                    items:1
                },
                1024:{
                    items:1
                },
                1100:{
                    items:1
                },
                1200:{
                    items:1
                }
            }
        })
    }
}

//===Testimonial Slider===
function testimonialSlider1() {
    if ($('.testimonial-carousel1').length) {
        $('.testimonial-carousel1').owlCarousel({
            loop:true,
            margin:50,
            nav:true,
            dots: false,
            autoplayHoverPause:false,
            autoplay: 6000,
            smartSpeed: 700,
            navText: [ '<span class="fas fa-chevron-left"></span>', '<span class="fas fa-chevron-right"></span>' ],
            responsive:{
                0:{
                    items:1
                },
                600:{
                    items:1
                },
                800:{
                    items:1
                },
                1024:{
                    items:2
                },
                1100:{
                    items:2
                },
                1200:{
                    items:3
                }
            }
        })
    }
}

//===Testimonial Slider===
function testimonialSlider2() {
    if ($('.testimonial-carousel2').length) {
        $('.testimonial-carousel2').owlCarousel({
            loop:true,
            margin:50,
            nav:false,
            dots: false,
            autoplayHoverPause:false,
            autoplay: 6000,
            smartSpeed: 700,
            navText: [],
            responsive:{
                0:{
                    items:1
                },
                600:{
                    items:1
                },
                800:{
                    items:1
                },
                1024:{
                    items:1
                },
                1100:{
                    items:1
                },
                1200:{
                    items:1
                }
            }
        })
    }
}

//=== Our Team ===
if ($('.our-team .bxslider').length) {
    $('.our-team .bxslider').bxSlider({
        nextSelector: '.our-team #slider-next',
        prevSelector: '.our-team #slider-prev',
        nextText: '<i class="fa fa-angle-right"></i>',
        prevText: '<i class="fa fa-angle-left"></i>',
        mode: 'fade',
        auto: 'true',
        speed: '700',
        pagerCustom: '.our-team .slider-pager .thumb-box'
    });
};

//=== Fact counter ===
function CounterNumberChanger () {
    var timer = $('.timer');
    if(timer.length) {
        timer.appear(function () {
            timer.countTo();
        })
    }
}

//=== Tool tip ===
function tooltip () {
    if ($('.tool_tip').length) {
            $('.tool_tip').tooltip();
        };
    $
}

//=== Accordion ===
function accordion() {
    if($('.accordion-box').length){
        $('.accordion-box .accord-btn').on('click', function() {
            if($(this).hasClass('active')!==true){
                $('.accordion-box .accord-btn').removeClass('active');
            }

            if ($(this).next('.accord-content').is(':visible')){
                $(this).removeClass('active');
                $(this).next('.accord-content').slideUp(500);
            }

            else{
                $(this).addClass('active');
                $('.accordion-box .accord-content').slideUp(500);
                $(this).next('.accord-content').slideDown(500); 
            }
        });
    }
}

//=== Select menu === 
function selectDropdown () {
    if($(".selectmenu").length) {
        $( ".selectmenu" ).selectmenu();
    };
}

//=== Prealoder===
function prealoader() {
    if($('.preloader').length){
        $('.preloader').delay(200).fadeOut(500);
    }
}

// ===Date picker ===
function datepicker () {
    if ($('#datepicker').length) {
        $('#datepicker').datepicker();
    };
}

//=== Time picker===
function timepicker () {
    $('input[name="time"]').ptTimeSelect();
}

//=== Thm scroll anim===
function thmScrollAnim() {
    if ($('.wow').length) {
        var wow = new WOW({
            mobile: false
        });
        wow.init();
    };
}

//Contact Form Validation
if($('#contact-form').length){
    $('#contact-form').validate({
        rules: {
            username: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            phone: {
                required: true
            },
            subject: {
                required: true
            },
            message: {
                required: true
            }
        }
    });
}

    //LightBox / Fancybox
    if($('.lightbox-image').length) {
        $('.lightbox-image').fancybox({
            openEffect  : 'fade',
            closeEffect : 'fade',
            helpers : {
                media : {}
            }
        });
    }

    //Sponsor Carousel
    if ($('.sponsor-carousel').length) {
        $('.sponsor-carousel').owlCarousel({
            loop:true,
            margin:30,
            nav:false,
            smartSpeed: 700,
            autoplay: 4000,
            navText: [ '<span class="fa fa-angle-left"></span>', '<span class="fa fa-angle-right"></span>' ],
            responsive:{
                0:{
                    items:1
                },
                600:{
                    items:2
                },
                800:{
                    items:2
                },
                1024:{
                    items:3
                },
                1200:{
                    items:4
                }
            }
        });         
    }   



// Dom Ready Function
jQuery(document).on('ready', function () {
    (function ($) {
        // add your functions
        brandCarousel ();
        testimonialSlider ();
        testimonialSlider1 ();
        testimonialSlider2 ();
        CounterNumberChanger ();
        accordion ();
        selectDropdown ();
        searchbox ();
        tooltip ();
        thmScrollAnim();
 
    })(jQuery);
});

// Scroll Function
jQuery(window).on('scroll', function(){
    (function ($) {
    stickyHeader();
    
    })(jQuery);
});

// Instance Of Fuction while Window Load event
jQuery(window).on('load', function() {
    (function($) {
        scheduleTab ();
        sponsorTab ();
        projectMasonaryLayout()
        prealoader ();        
    })(jQuery);
});



