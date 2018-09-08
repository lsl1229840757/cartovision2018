<%@page import="com.zh.DAOImp.CityDAOImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/echarts.js"></script>
<script src="js/vintage.js"></script>
<script src="js/jquery-3.3.1.js"></script>
</head>

<style type="text/css">
#main {
	width: 1300px;
	height: 1000px;
}
#otherChart {
	width: 1300px;
	height: 500px;
}

#button{
	width:80px;
	height :25px;
	background-color:#2388dc;
	color:white;
	box-radius:5px;
	box-shadow:1px 0px 2px #888888;
}
</style>

<body>
	<input type="button" value="切换" id="button">
	<div id="main"></div>
	<div id="otherChart"></div>
	<script type="text/javascript">
	function refresh(mode){
		var myChart = echarts.init(document.getElementById("main"), 'vintage');
		var otherChart = echarts.init(document.getElementById("otherChart"), 'vintage');
		
		
		var option_myChart = {
			title : {
				text : '省会城市GDP排行',
				subtext : '数据来自国家数据',
				fontSize : 28
			},
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'shadow'
				}
			},
			legend : {
				data : [ '2012', '2013', '2014', '2015', '2016' ],
				selectedMode : mode,
				animation : 'false'
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : {
				type : 'value'
			},
			yAxis : {
				type : 'category',
				data : []
			},
			series : [ {
				name : '2012',
				type : 'bar',
				stack : '总量',
				label : {
					normal : {
						show : true,
						position : 'insideRight'
					}
				},
				data : []
			}, {
				name : '2013',
				type : 'bar',
				stack : '总量',
				label : {
					normal : {
						show : true,
						position : 'insideRight'
					}
				},
				data : []
			}, {
				name : '2014',
				type : 'bar',
				stack : '总量',
				label : {
					normal : {
						show : true,
						position : 'insideRight'
					}
				},
				data : []
			}, {
				name : '2015',
				type : 'bar',
				stack : '总量',
				label : {
					normal : {
						show : true,
						position : 'insideRight'
					}
				},
				data : []
			}, {
				name : '2016',
				type : 'bar',
				stack : '总量',
				label : {
					normal : {
						show : true,
						position : 'insideRight'
					}
				},
				data : []
			} ]
		};
		
		
		var option_otherChart = {
				title : {
					text : '具体数据',
					fontSize : 28
				},
				tooltip : {
					trigger : 'axis',
					axisPointer : {
						type : 'shadow'
					}
				},
				legend : {
					data : [ 'one','two','three' ],
					animation : 'false'
				},
				grid : {
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},
				xAxis : {
					type : 'category',
					data:[2012,2013,2014,2015,2016]
				},
				yAxis : {
					type : 'value',
					data : ['第一产业','第二产业','第三产业']
				},
				series : [ {
					name : 'one',
					type : 'line',
					stack: '总量',
					label : {
						normal : {
							show : true,
							position : 'insideRight'
						}
					},
					data : []
				},{
					name : 'two',
					type : 'line',
					stack: '总量',
					label : {
						normal : {
							show : true,
							position : 'insideRight'
						}
					},
					data : []
				},{
					name : 'three',
					type : 'line',
					stack: '总量',
					label : {
						normal : {
							show : true,
							position : 'insideRight'
						}
					},
					data : []
				}],
				
			};
			
		
		
		
		
		
		
		
		
		
		
		
		
		var datatotal12 = [];
		var datatotal13 = [];
		var datatotal14 = [];
		var datatotal15 = [];
		var datatotal16 = [];
		var city12 = [];
		var city13 = [];
		var city14 = [];
		var city15 = [];
		var city16 = [];
		var everyYearPrIn = [];
		var everyYearSeIn = [];
		var everyYearTrIn = [];

		$.ajax({
			type : "post",
			async : true,
			url : "servlet_bar",
			data : {},
			dataType : "json",
			success : function(result) {
				if (result) {
					for (var i = 0; i < result.length; i++) {
						switch (result[i].myYear) {
						case 2012:
							datatotal12.push(result[i].total)
							city12.push(result[i].cityName)
							break;
						case 2013:
							datatotal13.push(result[i].total)
							city13.push(result[i].cityName)

							break;
						case 2014:
							datatotal14.push(result[i].total)
							city14.push(result[i].cityName)
							break;
						case 2015:
							datatotal15.push(result[i].total)
							city15.push(result[i].cityName)
							break;
						case 2016:
							datatotal16.push(result[i].total)
							city16.push(result[i].cityName)
							break;
						default:
							break;
						}
					}
					myChart.setOption({
						series : [ {
							name : '2012',
							data : datatotal12
						} ],
						yAxis : [ {
							data : city12
						} ]
					});
					myChart.setOption({
						series : [ {
							name : '2013',
							data : datatotal13
						} ],
						yAxis : [ {
							data : city13
						} ]
					});
					myChart.setOption({
						series : [ {
							name : '2014',
							data : datatotal14
						} ],
						yAxis : [ {
							data : city14
						} ]
					});
					myChart.setOption({
						series : [ {
							name : '2015',
							data : datatotal15
						} ],
						yAxis : [ {
							data : city15
						} ]
					});
					myChart.setOption({
						series : [ {
							name : '2016',
							data : datatotal16
						} ],
						yAxis : [ {
							data : city16
						} ]
					});

				}

			},
			error : function(errorMsg) {
				alert("图表请求失败");
				myChart.hideLoading();
			}

		})

		var cityName = '北京';

		if (option_myChart && typeof option_myChart === "object") {
			myChart.setOption(option_myChart, true);
			// 使用刚指定的配置项和数据显示图表。
			// 处理点击事件并且跳转到相应的百度搜索页面
			myChart.on('click', function(params) {
				cityName = params.name;
				$.ajax({
					type : "post",
					async : false,
					url : "servlet_click",
					data : {
						"cityName" : cityName
					},
					
					dataType : "json",
					success : function(result) {
							everyYearPrIn = []
							everyYearSeIn = []
							everyYearTrIn = []
							for (var i = 0; i < 5; i++) {
								
								everyYearPrIn.push(result[i].prIn);
								everyYearSeIn.push(result[i].seIn);
								everyYearTrIn.push(result[i].teIn);
								
							}
							console.log(everyYearPrIn);
							console.log(everyYearSeIn);
							console.log(everyYearTrIn);
							
							otherChart.setOption({
								title:{
									text:cityName + '具体数据'
								}
							})
							otherChart.setOption({
								series : [ {
									name : 'one',
									data : everyYearPrIn
								} ]
							})
							otherChart.setOption({
								series : [ {
									name : 'two',
									data : everyYearSeIn
								} ]
							})
							otherChart.setOption({
								series : [ {
									name : 'three',
									data : everyYearTrIn
								} ]
							});
							
						
						
					},
					error : function(errorMsg) {
						alert("图表请求失败");
						myChart.hideLoading();
					}

				});
			});
		}
	
		myChart.setOption(option_myChart);
		otherChart.setOption(option_otherChart);
	}
		var mode = "multiple";
		$(function(){
			refresh(mode);
		})
		
		$('#button').click(function(){
			if(mode == "multiple"){
				mode = "single";
			}else{
				mode = "multiple"
			}
			refresh(mode);
		})
	</script>
</body>
</html>