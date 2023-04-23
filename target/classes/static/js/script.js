//bartek
const teacherListDiv = document.getElementById("teacherList")
let nextTeacherId = document.getElementById("hiddenNumber").value;
function addTeacher(){
    const teacherDiv = document.createElement("div");
    teacherDiv.setAttribute("id",`div${nextTeacherId}`);

    const newSelect = document.createElement("select");
    newSelect.setAttribute("size","3");
    newSelect.setAttribute("name",`teacher${nextTeacherId}`);
    newSelect.setAttribute("required","");

    const p = document.createElement("p");
    p.innerText = nextTeacherId + ". nauczyciel";
    p.setAttribute("name",`p${nextTeacherId}`);
    p.setAttribute("style","font-size: 20px; font-weight: 900;");

    newSelect.innerHTML = document.getElementsByName("teacher1")[0].innerHTML;
    teacherDiv.appendChild(p);
    teacherDiv.appendChild(newSelect);
    teacherListDiv.appendChild(teacherDiv);
    console.log(teacherDiv);
    nextTeacherId++;
    console.log(nextTeacherId);
}

function removeTeacher(){
    if(nextTeacherId>2) {
        document.getElementById(`div${nextTeacherId - 1}`).remove();
        nextTeacherId--;
    }
}