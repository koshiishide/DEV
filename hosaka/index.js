
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

    

    //ボタンクリック後の画面遷移をやりあーす
    /*function buttonClick(page) {
        switch (page) {
            case 'list':
                location.href = "question/list.html";//飛ぶリンクはここでぇーす
                break;
            case 'logs':
                location.href = "record/record.html";
                alert('記録へ遷移するよ')
                console.log('記録へ');
                break;
            case 'logout':
                alert('ログアウトするよ')
                console.log('ログアウト');
                break;
            default:
                console.log('エラー');
        }
    };
    */

    /*時間ごとにあいさつ文を用意*/

    
