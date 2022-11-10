var data = {};

function getRegId(fname, addr){
	var regId = "1";
	$.ajax({
			url:fname,
			async:false,
			success:function(str){
				var arr = str.split("\n");
				$.each(arr, function(){
					var row = this.split(",");
					var city = row[0];
					var code = row[1];
					//console.log(city,code);
					if(city != undefined && code != undefined){
						data[city] = code;
					}
				});
				console.log(data)
			}
		});
		$.each(data, function(key,value){
					if(addr.match(key)){
						regId = value;
						console.log("리턴 regId:"+regId)
					}
				});
		console.log(regId);
	return regId;
}

