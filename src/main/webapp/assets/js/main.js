/**
 * 
 */
function addItemtoCart(id){
	$.ajax({
		type: 'POST',
		url: 'giohangController',
		data: {
			g: 'addItem',
			id: id,
			quantity: '1',
		},
		success:function(response) {
				console.log(response);
             document.getElementById("soluong").innerHTML = response;
           }
	})
}