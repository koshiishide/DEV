const maxVol = 100 // 経験値の上限
let currentVol =0; // 現在の経験値
var putdata ;
$(function() {
    // ボタンクリック時にサーバーからデータを取得
    $('#btn').click(function() {
      $.ajax(
        {
          dataType: "json",
          type: "PUT",
          url: "https://18.176.81.208/api.rsc/game_public_users(\'sample_hosaka2\')",
          headers: { 'x-cdata-authtoken': '2s9K2p9o6P9j3s7A5k8m',
          'Access-Control-Allow-Origin': '*'
          },
          agentOptions:{
            rejectUnauthorized  : "false",
          },
      processData: false,
      contentType: 'application/json',
      data: JSON.stringify(putdata),
          // 今日がキャンペーン期間内（この例では2016年11月の間）であるかを判定
          beforeSend: function() {
              putdata =  {"@odata.type" : "CDataAPI.[game].[public].[users]",  "id": "sample_hosaka100", "password": "sample_hosaka100"};
              return true;
          }
        }
      )
      // 取得したデータを<div id="result">要素に反映
      .done(function(data) {
          alert(JSON.stringify(data));
          alert(putdata);
      
      });
    });
  });

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

