/**
 * URL de l'api
 */
const ENDPOINT = "http://localhost:8080/UsersApiRest/api";

/**
 * cacher tous les composants
 */
function hideAll(){
   document.querySelector("#composant-accueil").style="display:none";
   document.querySelector("#composant-liste-utilisateur").style="display:none";
   document.querySelector("#composant-detail-utilisateur").style="display:none";
   document.querySelector("#composant-ajout-utilisateur").style="display:none";
}
/**
 * afficher le composant detail utlisateur
 * @param {*} event 
 */
function detailUser(event){
    let id = event.target.getAttribute("data");
    const userDetailNode = document.querySelector("#composant-detail-utilisateur");
    // requete HTTP type get (Ajax)
    fetch(ENDPOINT+`/users/${id}`)
    .then((response)=>response.json())
    .then((user)=>{
        hideAll();
        document.querySelector("#id").value= user.id;
        document.querySelector("#firstname").value= user.firstname;
        document.querySelector("#lastname").value= user.lastname;
        document.querySelector("#address").value= user.address;
        document.querySelector("#age").value= user.age;
        // afficher le composant détail utilisateur
        userDetailNode.style= "display:block";
    })

}

/**
 * cette fonction permet de créer un bouton
 * @param { id de l'utilisateur} id 
 * @returns 
 */
function createBtn(id){
    // créer la balise <button>
    const btnNode = document.createElement("button");
    // ajouter au <button> la class "btn btn-primary"
    btnNode.setAttribute("class","btn btn-primary");
    btnNode.innerText = "Détail"
    btnNode.setAttribute("data",id);
    btnNode.addEventListener("click",detailUser);
    return btnNode;
}
/**
 * cette fonction permet créer la balise <tr> et de la remplir avec les <td>
 * @param { Object de class Bean bo.User  } user 
 * @returns 
 */
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
/**
 * Cette fonction sera appeler à chaque fois que l'utilisateur clique sur les 
 * liens de navigation
 * @param {*} event 
 */
function onNavigate(event){
    // selectionner les composants
    const homeNode = document.querySelector("#composant-accueil");
    const usersNode = document.querySelector("#composant-liste-utilisateur");
    const addUserNode = document.querySelector("#composant-ajout-utilisateur");
    const path = event.target.getAttribute("lien-rest")
    // cacher tous les composants
    hideAll();
    if(path=="/"){
        // changer le titre de la page
        document.title = "Accueil";
        // changer la visibilité de composant
        homeNode.style="display:block";
        // modifier l'url sans rafraichir la page
        history.pushState(null,null,"/accueil");
    }
    if(path=="/users"){
        document.title = "Liste utilisateurs";
        usersNode.style="display:block";
        history.pushState(null,null,"/liste-utilisateurs");
        // requete HTTP type get (Ajax)        
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
    if(path=="/users/add"){
        document.title = "Ajouter un utilisateur";
        addUserNode.style="display:block";
        history.pushState(null,null,"/ajouter-utilisateur");
    }
}
/**
 * Création de  liens de navigations
 */
function nav(){
    const navBarNode =document.querySelector(".navbar-nav");
    const menu = [ 
        ["Accueil","/"], 
        ["Liste d'utilisateurs","/users"],
        ["Ajoute un utilisateur","/users/add"]
                ];

    for (const item of menu) {
        // créer un balise <a>
        const aNode = document.createElement("a");
        // ajouter l'attribut class à la balise <a>
        aNode.setAttribute("class","nav-link");
        // ajouter un text à la balise <a>
        aNode.innerText =  item[0];
        aNode.setAttribute("lien-rest",item[1]);
        // ajouter un écouteur de type clique à la balise <a>
        aNode.addEventListener("click",onNavigate)
        navBarNode.append(aNode);
    }
}
/**
 * 
 * Add User (POST Ajax)
 * 
 */

document.querySelector("#add-user-btn").addEventListener("click",
        // 
        function(event){
            
            const user = {};
            user.firstname = document.querySelector("#firstnamePersist").value;
            user.lastname = document.querySelector("#lastnamePersist").value;
            user.id = document.querySelector("#idPersist").value;
            user.address = document.querySelector("#addressPersist").value;
            user.age = document.querySelector("#agePersist").value;
            console.log(user);
            // validation !!!

            // requete http (POST AJAX)
            fetch(ENDPOINT+"/users",{
                method:'POST',
                headers:{
                    'Accept':'application/json',
                    'Content-Type':'application/json'
                },
                body: JSON.stringify(user)
            })
            .then((response)=>response.json())
            .then( (data)=>{
                console.log("******* Reponse de API ***********");
                console.log(data);
            })

        }
    );



/**
 * start app
 */
nav();
