const aulas=[
    aul1={
        tipo: "Pratica",
        info:"do somthing",
        link:"aulas/aula1",
    }
]
function doTable(){
    let table=document.getElementById("inf");
    for(let i=0;i< aulas.length;i++){
        let tr=document.createElement('tr');
        let link=document.createElement("td");
        let type=document.createElement("td");
        let inf=document.createElement("td");
        link.setAttribute("href",aulas[i].link)
        link.textContent=`Aula ${i+1}`;
        link.setAttribute("class","link")
        tr.appendChild(link);
        type.textContent=aulas[i].tipo;
        tr.appendChild(type);
        inf.textContent=aulas[i].info;
        tr.appendChild(inf);
        table.appendChild(tr)
    }
}