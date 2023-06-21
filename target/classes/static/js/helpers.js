function validateForm() {
    var a = document.forms["noteForm"]["noteName"].value;
    var b = document.forms["noteForm"]["noteText"].value;
    if (a == null || a == "" || b == null || b == ""){
        alert("Note name and note text can not be emtpy");
        return false;
    } 
    return true;
}

function convertDate(d){
    var p = d.split("/");
    return +(p[0]+p[1]+p[2]);
}

function sortByDate() {
    var tbody = document.querySelector("#notes tbody");
    var rows = [].slice.call(tbody.querySelectorAll("tr"));

    rows.sort(function(a,b){
        return convertDate(b.cells[2].innerHTML) - convertDate(a.cells[2].innerHTML);
    });

    rows.array.forEach(element => {
        tbody.appendChild(element);
    });
}