/*탑버튼*/
(function ($) {
    $(document).ready(function () {
        $('.m_tops').click(function () {
            $('body,html').animate({
                scrollTop: 0
            }, 500);
        })
    });
})(jQuery);

/*모달*/
// Get the modal
var modal = document.getElementById('id01');
// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

/*navi*/

$(".sub-navi").hide();
$(".nav ul li").hover(function () {
    $(".sub-navi").slideDown("fast");
});
$(".sub-navi").mouseleave(function () {
    $(".sub-navi").slideUp("fast");
});
$(".estimate_enquiry li").hover(function () {
    $(".sub-navi").slideUp("fast");
});
$(".logo").hover(function () {
    $(".sub-navi").slideUp("fast");
});

/*탑버튼*/
//Get the button

var mybutton = document.getElementById("myBtn");
// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function () {
    scrollFunction()
};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        mybutton.style.display = "block";
    }
    else {
        mybutton.style.display = "none";
    }
}
// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}
