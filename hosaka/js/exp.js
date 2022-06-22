const maxVol = 100 // 経験値の上限
let currentVol =0; // 現在の経験値

function addExpVol() {
    if (maxVol < currentVol) {
        currentVol % maxVol
    }
    const expElement = document.getElementById("exp-inner");
    expElement.style = "width: " + (currentVol % maxVol)  + "%";
}
let level=1+Math.floor(currentVol / maxVol); //レベル表示(初期レベル１)

window.onload = function () {
    // ここに読み込み完了時に実行してほしい内容を書く。
    //onloadイベントとは、ページや画像読み込みが完了した時点でイベントを実行するもの
    console.log('load')
    const currentLevelElement = document.getElementById("current-level");
    const currentLevel = document.createTextNode("レベル" +level); // 現在のレベルが表示される
    currentLevelElement.appendChild(currentLevel);
    addExpVol();
};

