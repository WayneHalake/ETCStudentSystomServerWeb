$( docement ).ready( function()
{
	alert( "ok" );
	
	$( ".typeItem" ).change( function()
	{
		var typeName = $( this ).attr( "value" );
		
		
		$.post( url, { typeName: typeName }, function()
		{
			location.href = "url";
		}, "text" );
		
		url = "myAction";

		$.ajax
		({
			url: url,
			type: "post",
			data: { name: name },
				dataType : "json",
				async : false,
				success : callback
			});
		
		alert( "typeName:"+ typeName );
	});

});