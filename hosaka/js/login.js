
//実際はデータから参照する

/*
button.addEventListener("click",);
function signin(){
    var element = document.createElement("div");
    var text = document.createElement= ("IDかパスワードに間違いがあります");
    document.body.appendChild(element).appendChild(text);
}
*/

document.getElementById("rogu").addEventListener("click",function(event){
    var textbox = document.getElementById("ID").value;
    var passwordbox = document.getElementById("password").value;
    event.preventDefault();

    if(textbox==="1" && passwordbox==="2")//実際はデータから参照する
    {
        window.location.replace("index.html");
    }
    else{
        //var element = document.createElement("p");
        //var element = document.getElementById("error");
        //var text = document.createTextNode("IDかパスワードに間違いがあります");
        //document.body.appendChild(element).appendChild(text);
        alert("IDかパスワードに間違いがあります");
    }
})

  
  //背景のパーティクル
    particlesJS("particles-js",{
      "particles":{
        "number":{
          "value":20,//この数値を変更すると幾何学模様の数が増減できる
          "density":{
            "enable":true,
            "value_area":800
          }
        },
        "color":{
          "value":"#000000"//色
        },
        "shape":{
          "type":"polygon",//形状はpolygonを指定
          "stroke":{
            "width":0,
          },
      "polygon":{
        "nb_sides":3,
        //多角形の角の数
        
      },
      "image":{
        "width":100,
        "height":100
      }
      },
        "opacity":{
        "value":0.664994832269074,
        "random":false,
        "anim":{
          "enable":true,
          "speed":2.2722661797524872,
          "opacity_min":0.08115236356258881,
          "sync":false
        }
        },
        "size":{
          "value":3,
          "random":true,
          "anim":{
            "enable":false,
            "speed":40,
            "size_min":0.1,
            "sync":false
          }
        },
        "line_linked":{
          "enable":true,
          "distance":150,
          "color":"#000000",
          "opacity":0.6,
          "width":1
        },
        "move":{
          "enable":true,
          "speed":4,//この数値を小さくするとゆっくりな動きになる
          "direction":"none",//方向指定なし
          "random":false,//動きはランダムにしない
          "straight":false,//動きをとどめない
          "out_mode":"out",//画面の外に出るように描写
          "bounce":false,//跳ね返りなし
          "attract":{
            "enable":false,
            "rotateX":600,
            "rotateY":961.4383117143238
          }
        }
      },
      "interactivity":{
        "detect_on":"canvas",
        "events":{
          "onhover":{
            "enable":false,
            "mode":"repulse"
          },
      "onclick":{
        "enable":false
      },
      "resize":true
        }
      },
      "retina_detect":true
    });
  