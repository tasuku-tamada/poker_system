//ボタンと送信パラメータを変更する
function select_change(obj){
    //対応したhiddenを取得
    index = parseInt(obj.id.split("_")[1]);
    send = document.getElementById("send_" + index);
    change_bool = "";
    change_html = "";
    if(send.value == "false"){
        change_bool = "true";
        change_html = "交換";
        change_num = "1";
    }
    else{
        change_bool = "false";
        change_html = "そのまま";
        change_num = "0";
    }
    send.value = change_bool
    obj.class = "change_" + change_num;
    obj.innerHTML = change_html;
}
