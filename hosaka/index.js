
function Greeting() {
    let nt = new Date();
    let hr = nt.getHours();

    if (hr <= 1) { document.write('夜中になりました。<br>Javaのお時間です。</br>'); }
    else if (hr <= 3) { document.write('そろそろ寝た方がいいんじゃ…？'); }
    else if (hr <= 5) { document.write('おはよう…寝ましたか？？'); }
    else if (hr <= 7) { document.write('おはようございます。,br>今日も勉強だ！</br>'); }
    else if (hr <= 9) { document.write('午前中ですねJavaのお時間です'); }
    else if (hr <= 11) { document.write('お昼ご飯の前にJavaしましょう'); }
    else if (hr <= 13) { document.write('お昼のお供にコーディング'); }
    else if (hr <= 15) { document.write('おやつがおいしいJava書こう！'); }
else if (hr <= 17) { document.write('そろそろ夕方ですね。<br>Javaのお時間です。</br>'); }
    else if (hr <= 19) { document.write('こんばんは、Java書きましょう！'); }
    else if (hr <= 21) { document.write('夜も更けてきました。<br>勉強しましょう。</br>'); }
    else if (hr <= 23) { document.write('寝る前にJava書きましょう。'); }
}

function addExpVol() {
    const maxVol = 600 // ここに次のレベルまでの経験値を記入せいー
    let currentVol = 100 // ここに現在の経験値を加算せいー
    if (maxVol < currentVol) {
        currentVol = maxVol
    }
    const expElement = document.getElementById("exp-inner");
    expElement.style = "width: " + (currentVol / maxVol) * 100 + "%";
}

window.onload = function () {
    // ここに読み込み完了時に実行してほしい内容を書く。
    //onloadイベントとは、ページや画像読み込みが完了した時点でイベントを実行するもの
    console.log('load')
    const currentLevelElement = document.getElementById("current-level");
    const currentLevel = document.createTextNode("レベル" + String(20)); // 現在のレベル入力
    currentLevelElement.appendChild(currentLevel);
    addExpVol();
};

    

//背景を動かすためのCSS
var livePatern = {
  canvas: null,
  context: null,
  cols: 0,
  rows: 0,
  colors: [252, 251, 249, 248, 241, 240],
  triangleColors: [],
  destColors: [],
  
  init: function(){
    this.canvas = document.getElementById('canvas');
    this.context = this.canvas.getContext('2d');
    this.cols = Math.floor(document.body.clientWidth / 24);
    this.rows = Math.floor(document.body.clientHeight / 24) + 1;
    
    this.canvas.width = document.body.clientWidth;
    this.canvas.height = document.body.clientHeight;
    
    this.drawBackground();
    this.animate();
  },
  
  drawTriangle: function(x, y, color, inverted){
    inverted = inverted == undefined ? false : inverted;

    this.context.beginPath();
    this.context.moveTo(x, y);
    this.context.lineTo(inverted ? x - 22 : x + 22, y + 11);
    this.context.lineTo(x, y + 22);
    this.context.fillStyle = "rgb("+color+","+color+","+color+")";
    this.context.fill();
    this.context.closePath();
  },
  
  getColor: function(){    
    return this.colors[(Math.floor(Math.random() * 6))];
  },
  
  drawBackground: function(){
    var eq = null;
    var x = this.cols;
    var destY = 0;
    var color, y;
    
    while(x--){
      eq = x % 2;
      y = this.rows;

      while(y--){
        destY = Math.round((y-0.5) * 24);

        this.drawTriangle(x * 24 + 2, eq == 1 ? destY : y * 24, this.getColor());
        this.drawTriangle(x * 24, eq == 1 ? destY  : y * 24, this.getColor(), true);
      }
    }
  },
  
  animate: function(){
    var me = this;

    var x = Math.floor(Math.random() * this.cols);
    var y = Math.floor(Math.random() * this.rows);
    var eq = x % 2;

    if (eq == 1) {
      me.drawTriangle(x * 24, Math.round((y-0.5) * 24) , this.getColor(), true);
    } else {
      me.drawTriangle(x * 24 + 2, y * 24, this.getColor());
    }

    setTimeout(function(){    
      me.animate.call(me);
    }, 10);
  },
};



!function(){livePatern.init();}()

var livePatern = {
    canvas: null,
    context: null,
    cols: 0,
    rows: 0,
    colors: [252, 251, 249, 248, 241, 240],
    triangleColors: [],
    destColors: [],
    
    init: function(){
      this.canvas = document.getElementById('canvas');
      this.context = this.canvas.getContext('2d');
      this.cols = Math.floor(document.body.clientWidth / 24);
      this.rows = Math.floor(document.body.clientHeight / 24) + 1;
      
      this.canvas.width = document.body.clientWidth;
      this.canvas.height = document.body.clientHeight;
      
      this.drawBackground();
      this.animate();
    },
    
    drawTriangle: function(x, y, color, inverted){
      inverted = inverted == undefined ? false : inverted;
  
      this.context.beginPath();
      this.context.moveTo(x, y);
      this.context.lineTo(inverted ? x - 22 : x + 22, y + 11);
      this.context.lineTo(x, y + 22);
      this.context.fillStyle = "rgb("+color+","+color+","+color+")";
      this.context.fill();
      this.context.closePath();
    },
    
    getColor: function(){    
      return this.colors[(Math.floor(Math.random() * 6))];
    },
    
    drawBackground: function(){
      var eq = null;
      var x = this.cols;
      var destY = 0;
      var color, y;
      
      while(x--){
        eq = x % 2;
        y = this.rows;
  
        while(y--){
          destY = Math.round((y-0.5) * 24);
  
          this.drawTriangle(x * 24 + 2, eq == 1 ? destY : y * 24, this.getColor());
          this.drawTriangle(x * 24, eq == 1 ? destY  : y * 24, this.getColor(), true);
        }
      }
    },
    
    animate: function(){
      var me = this;
  
      var x = Math.floor(Math.random() * this.cols);
      var y = Math.floor(Math.random() * this.rows);
      var eq = x % 2;
  
      if (eq == 1) {
        me.drawTriangle(x * 24, Math.round((y-0.5) * 24) , this.getColor(), true);
      } else {
        me.drawTriangle(x * 24 + 2, y * 24, this.getColor());
      }
  
      setTimeout(function(){    
        me.animate.call(me);
      }, 10);
    },
  };
  
  !function(){livePatern.init();}()