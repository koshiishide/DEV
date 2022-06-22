<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JavaMon</title>
    <meta name="description" content="コードを食って成長するモンスターを飼おう">
    <!-- css -->
    <link href="https://fonts.googleapis.com/css?family=Philosopher" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <ilnk href= "bg.css" rel="stylesheet">

    <!--フォントの読み込み-->
    <link href="https://fonts.googleapis.com/css2?family=DotGothic16&display=swap" rel="stylesheet">
    <style>
        div {
            /*セレクタに font-family を指定*/
            font-family: 'DotGothic16', sans-serif;
            font-size: 40px;
        }
    </style>
<script
src="https://code.jquery.com/jquery-3.6.0.js"
integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
crossorigin="anonymous"></script>

<script src="index.js"></script>
</head>

<body>
    <body bgcolor="#aaaaaa"></body>
      </div>
    <main>
        <div id="sample">
            <p>
              id:ahaha
            </p>
        <div id="particles-js"></div>
        <div id="wrapper">
        <div canvas id="canvas"></canvas></div>
        <div class="container">
            <div class="experience-section">
                <p id="current-level" class="experience-level"></p>
                <div class="exp-bar">
                    <div id="exp-inner"></div>
                </div>
            </div>
            <h1>JAVA MONSTER</h1>

            <script>
                Greeting();
            </script>

            <div class="img-section">
                <img src="img/javamon.png" alt="モンスター表示領域">
            </div>

            <div class="svg__container">
                <div class="buttons-section">
                    <a href="question/list.html" class="btn btn-svg">
                        <svg>
                            <rect x="1" y="1" rx="0" fill="none" width=200 height="50"></rect>
                        </svg>
                        <span>ごはんをあげる</span>
                    </a>
                    <a href="record/record.html" class="btn btn-svg">
                        <svg>
                            <rect x="2" y="2" rx="0" fill="none" width=200 height="50"></rect>
                        </svg>
                        <span>記録</span>
                    </a>
                    <a href="login.html" class="btn btn-svg">
                        <svg>
                            <rect x="2" y="2" rx="0" fill="none" width=200 height="50"></rect>
                        </svg>
                        <span>ログアウト</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
 </main>
</div>
<script src="https://cdn.jsdelivr.net/particles.js/2.0.0/particles.min.js"></script>
<script src="http://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/move02/5-4/js/5-4.js"></script>
    <script src="script.js"></script>
    <script src="../js/exp.js"></script>
</body>
</html>