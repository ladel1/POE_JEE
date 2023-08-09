const ENDPOINT = "http://localhost:8080/UsersApiRest/api";

function createBtn(id){
    const btnNode = document.createElement("button");
    btnNode.setAttribute("class","btn btn-primary");
    btnNode.innerText = "Détail"


    return btnNode;
}

function createTrNode(user){
    const trNode = document.createElement("tr");    
    const tdIdNode = document.createElement("td");
    tdIdNode.innerText= user.id;
    const tdFirstnameNode = document.createElement("td");
    tdFirstnameNode.innerText = user.firstname;
    const tdLastnameNode = document.createElement("td");
    tdLastnameNode.innerText = user.lastname;
    const tdActionsNode = document.createElement("td");
    tdActionsNode.append(createBtn(user.id));
    trNode.append(tdIdNode,tdFirstnameNode,tdLastnameNode,tdActionsNode);
    return trNode;
}

function onNavigate(event){
    const homeNode = document.querySelector("#composant-accueil");
    const usersNode = document.querySelector("#composant-liste-utilisateur");
    const path = event.target.getAttribute("lien-rest")
    if(path=="/"){
        document.title = "Accueil";
        homeNode.style="display:block";
        usersNode.style="display:none";
        history.pushState(null,null,"/accueil");
    }else{
        document.title = "Liste utilisateurs";
        homeNode.style="display:none";
        usersNode.style="display:block";
        history.pushState(null,null,"/liste-utilisateurs");
        // Ajax
        fetch(ENDPOINT+"/users")
        .then((response)=>response.json())
        .then((users)=>{
            const tbodyNode = document.querySelector("tbody");
            tbodyNode.innerHTML="";
            for (const user of users) {
                const trNode = createTrNode(user);
                tbodyNode.append(trNode);
            }
        })
    }
}

function nav(){
    const navBarNode =document.querySelector(".navbar-nav");
    const menu = [ 
        ["Accueil","/"], 
        ["Liste d'utilisateurs","/users"]
                ];

    for (const item of menu) {
        const aNode = document.createElement("a");
        aNode.setAttribute("class","nav-link");
        aNode.innerText =  item[0];
        aNode.setAttribute("lien-rest",item[1]);
        aNode.addEventListener("click",onNavigate)
        navBarNode.append(aNode);
    }
}

nav();


