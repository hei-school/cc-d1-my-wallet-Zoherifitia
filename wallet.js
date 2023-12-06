/*
    Les fonctionnalites d'un portefeuille
    - voir ce qu'il y a dans mon portefeuille
    - ajouter de l'argent
    - prendre de l'argent
    - suivre mes depenses 
    - ranger mes petits affaires
*/
const prompt = require('prompt-sync')();

console.log("Que voulez-vous faire ?");
console.log("1. Ajouter de l'argent");
console.log("2. Enlever de l'argent");
console.log("3. Suivre les dépenses");
console.log("4. Ranger");
console.log("5. Informations");


let balance = 0;
let expenses = [];
let items = [];

function getInfos(){
    if(items.length == 0){
        console.log("votre solde est de " + balance );
    }else{
    console.log("Votre solde est de " + balance + " et vous avez votre " + items + " dans votre portefeuille");
    }
}

function addMoney(){
    let amount = parseInt(prompt("Veuillez entrer le montant d'argent que vous souhaitez ajouter : "));
    balance += amount ; 
    console.log("votre solde est de " +  balance); 
}

function getMoney(){
    if(balance!=0){
        let amount = parseInt(prompt("Veuillez entrer le montant d'argent que vous souhaitez prendre : "));
        if( balance > amount ){
            let description = prompt("Pour faire quoi : ");
            balance -= amount ;
            expenses.push({"description" : description , "amount" : amount })
            console.log("Vous avez pris " + amount + " pour " + description);
        }else{
            console.log("Votre solde est inferieur a cette somme d'argent");
        }
    }else 
    console.log("Votre solde est de 0");
}

function getExpenses(){
    if(expenses.length != 0 ){
        console.log(expenses.map((element) =>  element.amount + " pour " + element.description ))
    }else
    console.log("Vous n'avez pas de depense");
}

function store(){
    let item = prompt("Vous voulez ranger quoi ? -->  ");
    items.push(item);
    console.log("votre " + item + " est dans votre portefeuille");
}

let option = parseInt(prompt("Entrez votre choix : "));
while (option !== 6) {
    switch (option) {
        case 1:
          addMoney();
          break;
        case 2:
          getMoney();
          break;
        case 3:
          getExpenses();
          break;
        case 4:
          store();
          break;
        case 5:
          getInfos();
          break;
        case 6 :
          break;
        default:
          console.log("Option invalide.");
      }

      option = parseInt(prompt("Entrer un autre choix : "))
}



/*budget */ 


