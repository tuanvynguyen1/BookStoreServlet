/**
 * 
 */
function checkall(){
			var check = document.getElementById('checkAll');
			var value = false;
			if(check.checked) value = true;
			
				var inputs = document.querySelectorAll('.item-checkbox');
				for(var i=0; i < inputs.length; i++){
					inputs[i].checked = value;
				}
}
