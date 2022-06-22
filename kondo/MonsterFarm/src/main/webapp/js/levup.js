//expが満タン(100)を超えるならば、進化画面へ
//ボタンのbtnIDを指定する

//ここに経験値の合計値
exp=120;


if(exp>100)//満タンを超えるなら
{
    var btn=document.getElementById("btn");
    btn.innerHTML="<span>おや……？</span>";

    document.getElementById("btn").addEventListener("click",function(event){
        window.location.href = "../shinka.html";
    })
}
else{
    document.getElementById("btn").addEventListener("click",function(event){
        window.location.href = "../index.html";
    })
}