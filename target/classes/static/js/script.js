let nextTeacherId = 2;
const teacherListDiv = document.getElementById("teacherList");
function addTeacher(){
    const newSelect = document.createElement("select");
    newSelect.setAttribute("size","3");
    newSelect.setAttribute("name",`teacher${nextTeacherId}`);

    const removeButton = document.createElement("button");
    removeButton.innerText = "Usuń";
    removeButton.setAttribute("class","removeTeacher");
    removeButton.setAttribute("onclick",`removeTeacher(${nextTeacherId})`);
    removeButton.setAttribute("type","button");
    removeButton.setAttribute("id",`removeButton${nextTeacherId}`);

    const p = document.createElement("p");
    p.innerText = nextTeacherId;
    p.setAttribute("name",`p${nextTeacherId}`);

    newSelect.innerHTML = document.getElementsByName("teacher1")[0].innerHTML;
    teacherListDiv.appendChild(newSelect);
    teacherListDiv.appendChild(p);
    teacherListDiv.appendChild(removeButton);
    nextTeacherId++;
    console.log(nextTeacherId);
}

function removeTeacher(x){
    document.getElementsByName(`teacher${x}`)[0].remove();
    document.getElementById(`removeButton${x}`).remove();
    document.getElementsByName(`p${x}`)[0].remove();
    nextTeacherId--;
    let selects = teacherListDiv.getElementsByTagName("select");
    let ps = teacherListDiv.getElementsByTagName("p");
    let buttons = teacherListDiv.getElementsByTagName("button");
    for(let i = 0; i < selects.length; i++){
        selects[i].setAttribute("name",`teacher${i+1}`);
        ps[i].setAttribute("name",`p${i}`);
    }
    for(let i = 0; i < buttons.length; i++){
        buttons[i].setAttribute("id",`removeButton${i+2}`);
        buttons[i].setAttribute("onclick",`removeTeacher(${i+2})`);
    }
}