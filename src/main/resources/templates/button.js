$("li a").click(function() {
$('li a').not(this).removeClass('active');
$(this).toggleClass('active');
});

function activeThis(element){
    var current = document.getElementsByClassName("active")[0];
    current.className = null;
    element.className="active";
}