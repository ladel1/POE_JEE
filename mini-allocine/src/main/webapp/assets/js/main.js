/**
 * 
 */
const myModalEl = document.getElementById('exampleModal')
myModalEl.addEventListener('show.bs.modal', event => {
  
  // recupérer les informations depuis la ligne <tr></tr>
  // et Ajouter les infos dans le modal
  const titreNode = document.getElementById('titre')
  titreNode.innerText = event.relatedTarget.getAttribute("data-nom");
  const synopsisNode = document.getElementById('synopsis')
  synopsisNode.innerText = event.relatedTarget.getAttribute("data-synopsis");
  const realNode = document.getElementById('real')
  realNode.innerText = event.relatedTarget.getAttribute("data-realisateur");
  const sortieNode = document.getElementById('sortie');
  sortieNode.innerText = event.relatedTarget.getAttribute("data-date");
})
