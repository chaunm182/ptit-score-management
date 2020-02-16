function activeParentMenu(id) {
    var menuActive = $('#'+id).prop("class","active");
    var ul = menuActive.find('ul');
    ul.prop("class","collapse in")
}

function activeMenu(id) {
    $('#'+id).prop("class","active");
}