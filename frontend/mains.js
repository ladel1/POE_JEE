fetch("http://localhost:8080/BackendAPI/api/articles")
.then((response)=>response.text())
.then((data)=>{
    console.log(data);
});