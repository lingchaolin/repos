
var rowlength; //每行多少个单元
var spxxTable;
var rowIndex;
function init() {
	rowlength = document.getElementById("spxxTable").rows[0].cells.length;
	spxxTable = document.getElementById("spxxTable");

	// var paytype = $(".paytype");
	// for (var i=0;i<paytype.size();i++){
	// 	if (paytype.get(i).attr(${})) {
	//
	// 	}
	// }
}

//逻辑控制
function choiceAnonymous() {
	var len = spxxTable.rows.length;
	var returnValue;
	var i;
	for (i = 1; i < len - 1; i++) {
		if (spxxTable.rows[i].cells[0].innerHTML == "\u221a") {
			returnValue = choice(i);
			setValue();
			hiddenDiv();
			return;
		}
	}
	alert("\u8bf7\u5148\u9009\u62e9\u5546\u54c1");
	function setValue() {
		var detailTable = document.getElementById("detailTable");
		var length = detailTable.rows.length;
		var cpbm = document.getElementsByName("cpbm");
		var cpmc = document.getElementsByName("cpmc");
		var sldw = document.getElementsByName("sldw");
		// var mxzj = document.getElementsByName("mxzj");
		cpbm[rowIndex].value = returnValue[0];
		cpmc[rowIndex].value = returnValue[1];
		sldw[rowIndex].value = returnValue[2];
		// mxzj[rowIndex].value = returnValue[3];
	}
}
function selectItem(tr) {
	clearTable();
	tr.cells[0].innerHTML = "\u221a";
	var tds = tr.cells;
	for (var j = 0; j < tds.length; j += 1) {
		tds[j].style.backgroundColor = "#C1CDD8";
	}
}
function choice(index) {
	var row = document.getElementById("spxxTable").rows[index];
	var result = new Array(rowlength);
	var i;
	for (i = 1; i < rowlength; i++) {
		result[i - 1] = row.cells[i].innerHTML;
	}
	return result;
}
function choiceSpxx(rowIndex_) {
	showDiv();
	rowIndex = rowIndex_;
}
  //添加一行
function addItem() {
	var detailTable = document.getElementById("detailTable");
	var oRow = detailTable.insertRow(-1);//在表格最后添加一行
	oRow.align = "center";
	oRow.className = "toolbar";
	oCell = oRow.insertCell(0);//添加单元格
	oCell.innerHTML = "<input type='text' name='venderId' id='venderId' class='venderId' size='15'>";
	oCell = oRow.insertCell(1);
	oCell.innerHTML = "<input type='text'  name='status' id='status' size='10' > <span class='LL'></span>";
    
    // oCell.class= ;
	oCell = oRow.insertCell(2);
	oCell.innerHTML = "<input type='text' name='userId' id='userId' size='15' >";
	oCell = oRow.insertCell(3);
	oCell.innerHTML = "<input type='text' name='installTime' id='installTime' size='10'>";
	oCell = oRow.insertCell(4);
	oCell.innerHTML = "<input type='text' name='bicycleId' id='bicycleId' size='10'>";
	oCell = oRow.insertCell(5);
	oCell.innerHTML = "<input type='text' name='remark' class='remark' id='mxzj' size='10' >";
	// oCell = oRow.insertCell(6);
	// oCell.innerHTML = "<input type='text' name='mxzj' size='10' value='0' >";

	oCell = oRow.insertCell(6);
	oCell.innerHTML = "<image src=\"../images/delete.gif\" class=\"LL\" onclick=\"del(this)\"/>";
}
	//删除行,注意这里的行号全部要重新计算 刷新的
function delItem(index) {
	var detailTable = document.getElementById("detailTable");
	detailTable.deleteRow(index);
	var rowNum = detailTable.rows.length;
	var rowlength = detailTable.rows[0].cells.length;
	for (i = index; i < rowNum; i++) {
		detailTable.rows[i].cells[0].innerHTML = i;
		detailTable.rows[i].cells[rowlength - 1].innerHTML = "<image src=\"../images/delete.gif\" class=\"LL\" onclick=\"delItem(" + i + ")\"/>";
	}
}
function hiddenDiv() {
	document.getElementById("productDiv").style.visibility = "hidden";
	clearTable();
}
function showDiv(){
	document.getElementById("productDiv").style.visibility = "visible";
	
}
 

function clearTable() {
	var trs = spxxTable.rows;
	for (var i = 1; i < trs.length - 1; i += 1) {
		trs[i].cells[0].innerHTML = "";
		var tds = trs[i].cells;
		for (var j = 0; j < tds.length; j += 1) {
			tds[j].style.backgroundColor = "#fff7e5";
		}
	}
	
}

//我添加的js
function del(n) {
    if (n.parentNode.parentNode.rowIndex == 1){
        alert("每条销售单应至少有一条明细！");
        return;
    }
    $(n).parent().parent().remove();
}

function ptchange(n) {
    if ($(n).val()==3){
        $("#prepayfee").removeAttr("readonly");
    }else {
        $("#prepayfee").attr("readonly","readonly");
    }
}

function itemprice(t) {
    var tp = $(t).parent().parent().find("#mxzj");
    var p =  $(t).parent().parent().find("#xsdj");
    var n =  $(t).parent().parent().find("#cpsl");
    tp.val(p.val()*n.val());
    totalprice();
}

function totalprice() {
    var total = $("#producttotal");
    // var total = document.getElementById("cpzj");
    var mxzj = $(".mxzj");
    var price = 0;
    for (var i=0;i<mxzj.size();i++){
        price += parseFloat(mxzj.get(i).value);
    }
    total.val(price);
}

function check(n) {
    var va = $(n).val();
    if (/\D+/.test(va)){
        alert("必须为数字！");
        return;
    }

    if (/^\s*$/.test(va)){
        alert("不能为空！");
        return;
    }
}