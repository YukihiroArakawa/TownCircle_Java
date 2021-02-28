<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML>
<html lang="ja">
    <head>
        <!--スタート　登録　サークル一覧(3個程度表示できるように)-->
        <title>タウンサークル/検索</title>
        <style type="text/css">
                @import url("../towncircle.css");
        </style>
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <meta name="format-detection" content="telephone=no">
         <script language=”javascript”> resizeTo(2880,1800); </script>
         <link href="https://fonts.googleapis.com/css?family=Kosugi+Maru|M+PLUS+Rounded+1c&display=swap&subset=japanese" rel="stylesheet">
    </head>
    <header class="header">
        <a href="/TownCircle/town/index">
        <img src="../whitelogo.png" height="95">
        </a>
    </header>
    <body class="body" bgcolor="#243552">
        <br>
        <br>

	 <div class="kensaku">
    <form method="post" action="register" class="search">
    <table>
        <tr>
         <th>地域</th>
            <td colspan="2">
                <div class="reigion">
                <div class="cp_ipselect cp_sl04">
                <select name="place">
                <option value="1">京都府</option>
                    </select>
                    </div>
                </div>
            </td>
        </tr>
        <tr>
        <th>カテゴリー</th>
            <td>
                <div class="outdoor">
             <ul>
              <li>
                <input type="radio" value="0" id="option0" name="category" checked="checked">
                <label for="option0">テニス</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="1" id="option1" name="category">
                <label for="option1">ダンス</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="6" id="option6" name="category">
                <label for="option6">サッカー</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="7" id="option7" name="category">
                <label for="option7">フットサル</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="8" id="option8" name="category">
                <label for="option8">野球</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="9" id="option9" name="category">
                <label for="option9">バスケ</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="10" id="option10" name="category">
                <label for="option10">バレーボール</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="11" id="option11" name="category">
                <label for="option11">チア</label>
                <div class="check"></div>
         </li>
          <li>
                <input type="radio" value="12" id="option12" name="category">
                <label for="option12">スキー</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="13" id="option13" name="category">
                <label for="option13">バドミントン</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="14" id="option14" name="category">
                <label for="option14">スキューバ</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="15" id="option15" name="category">
                <label for="option15">ハンドボール</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="16" id="option16" name="category">
                <label for="option16">バレエ</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="17" id="option17" name="category">
                <label for="option17">合気道</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="18" id="option18" name="category">
                <label for="option18">スノボ</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="19" id="option19" name="category">
                <label for="option19">クリケット</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="20" id="option20" name="category">
                <label for="option20">陸上</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="21" id="option21" name="category">
                <label for="option21">ラケットボール</label>
                <div class="check"></div>
              </li>
          <li>
                <input type="radio" value="22" id="option22" name="category">
                <label for="option22">総合格闘技</label>
                <div class="check"></div>
              </li>
                </ul>
               </div>
                </td>
                <td>
         <div class="indoor">
            <ul>
              <li>
                <input type="radio" value="2" id="option2" name="category">
                <label for="option2">鉄オタ</label>
                <div class="check"></div>
              </li>
            <li>
                <input type="radio" value="3" id="option3" name="category">
                <label for="option3">イベサー</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="4" id="option4" name="category">
                <label for="option4">軽音</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="5" id="option5" name="category">
                <label for="option5">ボランティア</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="23" id="option23" name="category">
                <label for="option23">合唱</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="24" id="option24" name="category">
                <label for="option24">器楽</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="25" id="option25" name="category">
                <label for="option25">伝統芸能</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="26" id="option26" name="category">
                <label for="option26">芸能文化</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="27" id="option27" name="category">
                <label for="option27">メディア</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="28" id="option28" name="category">
                <label for="option28">写真</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="29" id="option29" name="category">
                <label for="option29">映像</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="30" id="option30" name="category">
                <label for="option30">社会科学研究</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="31" id="option31" name="category">
                <label for="option31">応援団</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="32" id="option32" name="category">
                <label for="option32">文化系その他</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="33" id="option33" name="category">
                <label for="option33">芸術</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="34" id="option34" name="category">
                <label for="option34">自然科学研究</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="35" id="option35" name="category">
                <label for="option35">人文科学研究</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="36" id="option36" name="category">
                <label for="option36">表現</label>
                <div class="check"></div>
            </li>
            <li>
                <input type="radio" value="37" id="option37" name="category">
                <label for="option37">DJ</label>
                <div class="check"></div>
            </li>
            </ul>
            </div>
            </td>
            </tr>
        <tr>
                <th>詳細検索</th>
            <td colspan="2">
                   <div class="varcount">
                    <a>男が多い</a>
                    <input type="range" value="4" min="0" max="10" step="1" class="menwomen" name="menWomen"
                    oninput="document.getElementById('output1').value=this.value">
                    <a>女が多い</a>
                    <br>
                    <a>活動が少ない</a>
                    <input type="range" value="3" min="0" max="7" step="1" class="frequency" name="frequency"
                    oninput="document.getElementById('output2').value=this.value">
                    <a>活動が多い</a>
                    <br>
                    <a>イベント月0回</a>
                    <input type="range" value="3" min="0" max="7" step="1" class="event"
                    name="event"
                    oninput="document.getElementById('output3').value=this.value">
                    <a>イベント月4回以上</a>
                    <br>
                    <a>カップルなし</a>
                    <input type="range" value="5" min="0" max="10" step="1" class="love"
                    name="love"
                    oninput="document.getElementById('output4').value=this.value">
                    <a>カップルだらけ</a>
                    <br>
                    <a>年会費0円</a>
                    <input type="range" value="2" min="0" max="4" step="1" class="fee"
                    name="fee"
                    oninput="document.getElementById('output6').value=this.value">
                    <a>年会費10000円以上</a>
                    <br>
                    <a>喫煙率0%</a>
                    <input type="range" value="5" min="0" max="10" step="1" class="smoker"
                    name="smoker"
                    oninput="document.getElementById('output7').value=this.value">
                    <a>喫煙率100%</a>
                    <br>
                    </div>
                 </td>

            </tr>
            <tr>
               <th>優先項目</th>
                <td colspan="2">
                <div class="cp_ipselect cp_sl04">
                <select name="priority">
                <option value="Nothing">指定なし</option>
                <option value="menWomen">男女比率</option>
                <option value="frequency">活動頻度</option>
                <option value="event">イベント頻度</option>
                <option value="love">カップル率</option>
                <option value="fee">年会費</option>
                <option value="smoker">喫煙者率</option>
                    </select>
                    </div>
                    </td>

            </tr>


    </table>
	<input type="hidden" name="id" value="<c:out value="${ dto.id }" />"/>
    <input type="hidden" name="token" value="<c:out value="${ token }" />"/>

    <br>
    <input type="submit" class="btn2" value="探す!" />
    </form>

    </div>
    </body>
</html>
