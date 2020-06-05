var role_mags =[];
window.onload = function() {
    //役の倍率を格納
    i = 1;
    while(document.getElementById("role_" + i + "_magnification") != null){
        role_obj = document.getElementById("role_" + i + "_magnification");
        console.log(role_obj.innerHTML);
        role_mags.push(parseInt(role_obj.innerHTML));
        i++;
    }
};

function update_role(obj){
    val = parseInt(obj.value);
    if(!isNaN(val)){
        console.log(val);
        role_id = 1;
        role_mags.forEach(function(item, index, array){
            role_obj = document.getElementById("role_" + (index + 1) + "_magnification");
            role_obj.innerHTML = "" + (val * role_mags[index]);
        });
    }
}
