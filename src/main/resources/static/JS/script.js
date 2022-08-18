"use strict";

// SELECTORS

//buttons
let createBtn = document.querySelector("#createBtn");
let deleteBtn = document.querySelector("#deleteBtn");
let updateBtn = document.querySelector("#updateBtn");

//divs
let resultDiv = document.querySelector("#result-Div");

//inputs
let englishTitleInput = document.querySelector("#englishTitle-input");
let japaneseTitleInput = document.querySelector("#japaneseTitle-input");
let seasonsInput = document.querySelector("#seasons-input");
let episodesInput = document.querySelector("#episodes-input");
let ratingInput = document.querySelector("#rating-input");
let completeStatusInput = document.querySelector("#complete-input");
let deleteIdInput = document.querySelector("#deleteId-input");
let idInput = document.querySelector("#Id-input");

//FUNCTIONS
let getAll = () => {
    axios.get("http://localhost:8080/Anime/getAll")
    .then(res => {
        console.log(res.data)
            resultDiv.innerHTML="";
            let results = res.data;

            for (let result of results) {
                    printResults(result);
            }
    }).catch(err => {console.log(err)});
}

let create = () => {

    let obj = {
        
        "englishTitle": englishTitleInput.value,
        "japaneseTitle": japaneseTitleInput.value,
        "seasons": seasonsInput.value,
        "episodes": episodesInput.value,
        "rating": ratingInput.value,
        "complete": completeStatusInput.value
        
    }
    axios.post("http://localhost:8080/Anime/create", obj)
    .then(res => {
        getAll();

    }).catch(err => {console.log(err)}); 
}

let update = () => {

    let obj = {
        
        "englishTitle": englishTitleInput.value,
        "japaneseTitle": japaneseTitleInput.value,
        "seasons": seasonsInput.value,
        "episodes": episodesInput.value,
        "rating": ratingInput.value,
        "complete": completeStatusInput.value
        
    }

    axios.put(`http://localhost:8080/Anime/update/${idInput.value}`, obj)
    .then(res => {
        getAll();
    })
    .catch((err) => { console.log(err); })
}

let printResults = (result) => {

    let entryParentDiv = document.createElement("div");
    entryParentDiv.setAttribute("class", "entryParent-Div");

    let entryDiv = document.createElement("div");
    entryDiv.setAttribute("class", "entry-Div");
    entryDiv.textContent = `${result.id} | ${result.englishTitle} | ${result.japaneseTitle} | ${result.seasons} | ${result.episodes} | ${result.rating} | ${result.complete}`;

    let delBtn = document.createElement("button");
    delBtn.textContent = "Delete";
    delBtn.type="button";
    delBtn.setAttribute("Class", "btn btn-danger btn-sm");
    delBtn.setAttribute("Style", "display:inline-grid;");
    delBtn.setAttribute("onClick", `deleteById(${result.id})`);


    entryParentDiv.appendChild(entryDiv);
    entryParentDiv.appendChild(delBtn);
    resultDiv.appendChild(entryParentDiv);

}

let deleteById = (id) => {

    axios.delete(`http://localhost:8080/Anime/delete/${id}`)
    .then(() => {
        getAll();
    })
    .catch((err)=> {console.log(err)});
}

let deleteAnime = () => {
    if (!validateDelete()){
        return;
    }

    axios.delete(`http://localhost:8080/Anime/delete/${idInput.value}`)
    .then(() => {
        getAll();
    })
    .catch((err)=> {console.log(err)});
}


let validateDelete = () => {
    if (idInput.value === "") {
        alert("ID is required for this operation");
        return false;
    } else {
        return true;
    }
}



// LISTENERS
createBtn.addEventListener("click", create);
deleteBtn.addEventListener("click", deleteAnime);
updateBtn.addEventListener("click", update);