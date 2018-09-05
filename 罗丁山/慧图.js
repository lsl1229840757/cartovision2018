function check1(){
	var usn = document.getElementById('username').value;
	var psd = document.getElementById('password').value;
	var p = document.getElementById('error').value;
	if (usn.length == 0 || psd.length == 0){
		document.getElementById("error").innerHTML = "请输入用户名及密码！";
	}
	else{
		check2()
	}
}

function check2(){
	var usn = document.getElementById('username').value;
	var psd = document.getElementById('password').value;
	var p = document.getElementById('error').value;
	if (usn.length <= 20 && usn.length >= 6 && psd.length >= 6 && usn.length <= 20){
		check3()
	}
	else{
		document.getElementById("error").innerHTML = "请输入正确格式的用户名及密码！";
	}
}

function check3(){
	var usn = document.getElementById('username').value;
	var psd = document.getElementById('password').value;
	var p = document.getElementById('error').value;
	var pattern = /^[a-zA-Z0-9]{1,}$/

	if (pattern.test(usn) && pattern.test(psd)){
		check4();
	}
	else{
		document.getElementById("error").innerHTML = "请输入正确格式的用户名及密码！";
	}

}

function check4(){
	var usn = document.getElementById('username').value;
	var psd = document.getElementById('password').value;
	var p = document.getElementById('error').value;
	document.getElementById("error").innerHTML = " "
	if (usn == "cartovision" && psd == "cartovision2018"){
		alert("登陆成功")
		window.location= "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=baidu&wd=%E7%82%B9%E5%87%BB%E5%B0%B1%E9%80%81&oq=js%2520%25E8%25B7%25B3%25E8%25BD%25AC%25E5%2588%25B0%25E6%258C%2587%25E5%25AE%259A%25E9%25A1%25B5%25E9%259D%25A2&rsv_pq=b3665480000156eb&rsv_t=72b02liUFHWSkUGDz2C6pyF5z4ixyNNx5b49hmPfhGpZ2Om9v7Xtt0Bk03I&rqlang=cn&rsv_enter=1&inputT=2122&rsv_sug3=52&rsv_sug1=29&rsv_sug7=100&rsv_sug2=0&rsv_sug4=2123";
	}
	else{
		alert("请输入正确的用户名及密码！")
	}
}