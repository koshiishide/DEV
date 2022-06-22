// detail.html から問われた問題

// データベースから正解を読み込んで

// 合うと正解、合わないと不正解



// case1:入力値＝正解　　case2:入力値≠正解

function comparison(){

    let answer1 = document.forms['ansForm'].elements['ans'].value;

var answer = null;

if ("データベースから取ってきた値" = answer1) {

    corw = 0;

} else {

    corw = 1;

}



switch(corw){

    case corw = 0:

        console.log('あなたの回答' + answer1 + '不正解');

        break;

    case corw = 1:

        console.log('正解');

        break;

}

}



// PUT(更新)



var postdata = {"@odata.type" : "CDataAPI.[game].[public].[users]",  "id": "sample_hosaka2", "password": "sample_hosaka2  "};

$.ajax({

  dataType: "json",

  type: "PUT",

  url: "https://18.176.81.208/api.rsc/game_public_users(\'sample_hosaka\')",

  headers: { 'x-cdata-authtoken': '2s9K2p9o6P9j3s7A5k8m',

  'Access-Control-Allow-Origin': '*'

},

  processData: false,

  contentType: 'application/json',

  data: JSON.stringify(postdata),

  success: function(data) {

    alert(JSON.stringify(data));

  }

});  



// POST

// 데이터베이스 신규등록



var postdata = {"@odata.type" : "CDataAPI.[game].[public].[users]",  "id": "sample_hosaka", "password": "sample_hosaka"};

$.ajax({

  dataType: "json",

  type: "POST",

  url: "https://18.176.81.208/api.rsc/game_public_users/",

  headers: { 'x-cdata-authtoken': '2s9K2p9o6P9j3s7A5k8m'},

  processData: false,

  contentType: 'application/json',

  data: JSON.stringify(postdata),

  success: function(data) {

    alert(JSON.stringify(data));

  }

}); 



// GET 취득



$.ajax({

  type: "GET",

  url: "https://18.176.81.208/api.rsc/game_public_users/",

  dataType: "json",

  headers: { 'x-cdata-authtoken': '2s9K2p9o6P9j3s7A5k8m',

  'Access-Control-Allow-Origin': '*'

}})

.done(function(data){

  //alert('成功!');

  console.log(JSON.stringify(data));



  console.log(data.value[0].password);

})

.fail(function(XMLHttpRequest, textStatus, errorThrown){

  console.log("idの中身は");

  console.log(id);

  alert(errorThrown);

});
