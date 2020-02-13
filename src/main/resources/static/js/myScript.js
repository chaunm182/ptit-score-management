function activeParentMenu(id,subId) {
    $('#'+id).prop("class","active");
    $('#'+subId).prop("class","collapse in")
}

function activeMenu(id) {
    $('#'+id).prop("class","active");
}