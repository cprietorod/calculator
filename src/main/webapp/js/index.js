var calc = "", lastop = "";
$("[data-func]").on("click", function() {
  var func = $(this).attr('data-func'),
      val = $(this).attr('data-val');
  if(func == 'number') {
    calc += val;
    $('#display').text(calc);
  }
  else if(func == 'operation') {
    if(val == 'clear') {
      if(lastval == 'equals') {
        calc = '';
      }
      calc = calc.toString().slice(0,-1);
      $('#display').text(calc);
    }
    else if(val == 'equals') {
    	var result = $.ajax({url: "./rest?operation="+encodeURIComponent(calc), async: false}).responseText;
    	result = JSON.parse(result);
    	console.log(result);
    	if(result.success){
    		$('#display').text(result.result);
    	}else{
    		$('#display').text("");
    	}
    } else {
      calc += val;
      $('#display').text(calc);
    }
  }
  lastval = val;
});