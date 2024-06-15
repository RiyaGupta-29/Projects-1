let boxes=document.querySelectorAll(".box");
let reset=document.querySelector(".reset");
let winner=document.querySelector(".result");
let container=document.querySelector(".game-container");
let new_btn=document.querySelector("#start");
let game=document.querySelector(".game");
let player1=document.querySelector("#player1");
let turnO=true;

let winningCombinations=[[0,1,2],[3,4,5],[6,7,8],[0,3,6],[1,4,7],[2,5,8],[0,4,8],[2,4,6]];
boxes.forEach((box) => {
    box.disabled=true;
});
// automatically select other option for player 2 when player 1 as selected
player1.addEventListener("change",function(){
    let player2=document.querySelector("#player2");
    if(player1.value==="X"){
        player2.value="O";
        }else{
            player2.value="X";
            }
            player1.disabled=true;
            boxes.forEach((box) => {
                box.disabled=false;
            });
            });

boxes.forEach((box)=>{
        
    box.addEventListener("click",function(){
        console.log("box was clicked");
        if(turnO){
            // box innertext should be  player1 value
            box.innerText=player1.value;
            turnO=false;
            }else{
                box.innerText=player2.value;
                turnO=true;
                }
        box.disabled=true;
        checkForWin();
    });
});

const showwinner=(win)=>{
    winner.innerText=`Congratulations!,winner is ${win}`;
    winner.style.marginTop = "20%";
    container.classList.remove("hide");
    reset.classList.add("hide");
    game.classList.add("hide");

}

const checkForWin=()=>{
    for(let pattern of winningCombinations ){
        let box1=boxes[pattern[0]].innerHTML;
        let box2=boxes[pattern[1]].innerHTML;
        let box3=boxes[pattern[2]].innerHTML;
        if( box1!="" &&  box2!="" && box3!=""){
            if(box1===box2 && box2===box3){
            // box color blue of box1,box2,box3
            boxes[pattern[0]].style.backgroundColor="blue";
            boxes[pattern[1]].style.backgroundColor="blue";
            boxes[pattern[2]].style.backgroundColor="blue";
            //after 30 sec go to another function
            setTimeout(function(){
                showwinner(box1);
                },2000);
               reset.disabled=false;
               }
               }
               }
               };
      
//for reset button
reset.addEventListener("click",function(){
    boxes.forEach((box)=>{
        box.disabled=false;
        box.innerHTML="";
        turnO=true;
        player1.disabled=false;
        });
        });

new_btn.addEventListener("click",function(){
    boxes.forEach((box)=>{
        container.classList.add("hide");
        reset.classList.remove("hide");
        game.classList.remove("hide");
        box.disabled=false;
        box.innerHTML="";
        turnO=true;
        player1.disabled=false;

});
});
