/**
 * 
 */

var xhrObject;

function createXHR() {
	alert("2");
	if (window.ActiveXObject) {
		xhrObject = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.XMLHttpRequest) {
		xhrObject = new XMLHttpRequest();
	}
}

function startMethod() {
	alert("1");
	createXHR();
	xhrObject.onreadystatechange = resultProcess;
	xhrObject.open("GET", "xhrTest1.xml", "true");
	xhrObject.send(null);
}

function resultProcess() {
	alert("3");
	if (xhrObject.readyState == 4) {
		if (xhrObject.status == 200) {
			document.getElementById("displayArea").innerHTML = xhrObject.responseText;
		}
	}
}