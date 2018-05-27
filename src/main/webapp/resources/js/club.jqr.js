$(function() {
	
	$('.clubEditBtn').on('click', function(){
		
		var clubId = $(this).val();
		
		 $.ajax({
		   		url : "/pes/team/getClubById?clubId="+clubId,
		   		type : 'GET',
		   		dataType: 'json',
		   		contentType : 'application/json; charset=utf-8',
		   		success: function(data){  
		   			console.log('success');
		   			$('#clubId').val(data.id);
		   			$('#clubId').show();
		   			$('#clubName').val(data.name);
		   			$('#clubEmblem').val(data.emblem);
		   			$('#clubEditForm').css("visibility",'visible');
		   			$('#leagueEditForm').css("visibility",'hidden');
		   			$('#nationEditForm').css("visibility",'hidden');
		   			$('#continentEditForm').css("visibility",'hidden');
		   			$('#clubLeague').val(data.league.id);
		   			
		   		},
		   		error:function(er, st, msg) { 
		   			console.log("ERROR: ", msg);
		   			console.log("ER: ", er);
		   			
		   	    }
		   	});
		
	});
	
	$('#addClubBtn').on('click', function(){
		
		console.log('success');
			$('#clubId').val(null);
			$('#clubId').hide();
			$('#clubName').val(null);
			$('#clubEmblem').val(null);
			$('#clubEditForm').css("visibility",'visible');
			$('#leagueEditForm').css("visibility",'hidden');
			$('#nationEditForm').css("visibility",'hidden');
			$('#continentEditForm').css("visibility",'hidden');
	});
$('#addNationBtn').on('click', function(){
		
		console.log('success');
			$('#nationId').val(null);
			$('#nationId').hide();
			$('#nationName').val(null);
			$('#nationEmblem').val(null);
			$('#nationEditForm').css("visibility",'visible');
			$('#leagueEditForm').css("visibility",'hidden');
			$('#clubEditForm').css("visibility",'hidden');
			$('#continentEditForm').css("visibility",'hidden');
	});

$('#addLeagueBtn').on('click', function(){
	
	console.log('success');
		$('#leagueId').val(null);
		$('#leagueId').hide();
		$('#leagueName').val(null);
		$('#leagueEmblem').val(null);
		$('#leagueEditForm').css("visibility",'visible');
		$('#clubEditForm').css("visibility",'hidden');
		$('#nationEditForm').css("visibility",'hidden');
		$('#continentEditForm').css("visibility",'hidden');
});
$('#addContinentBtn').on('click', function(){
	
	console.log('success');
		$('#continentId').val(null);
		$('#continentId').hide();
		$('#continentName').val(null);
		$('#continentEmblem').val(null);
		$('#continentEditForm').css("visibility",'visible');
		$('#leagueEditForm').css("visibility",'hidden');
		$('#nationEditForm').css("visibility",'hidden');
		$('#clubEditForm').css("visibility",'hidden');
});
	
	$('.nationEditBtn').on('click', function(){
		
		var nationId = $(this).val();
		
		 $.ajax({
		   		url : "/pes/team/getNationById?nationId="+nationId,
		   		type : 'GET',
		   		dataType: 'json',
		   		contentType : 'application/json; charset=utf-8',
		   		success: function(data){  
		   			console.log('success');
		   			$('#nationId').val(data.id);
		   			$('#nationId').show();
		   			$('#nationName').val(data.name);
		   			$('#nationEmblem').val(data.emblem);
		   			$('#nationEditForm').css("visibility",'visible');
		   			$('#leagueEditForm').css("visibility",'hidden');
		   			$('#continentEditForm').css("visibility",'hidden');
		   			$('#clubEditForm').css("visibility",'hidden');
		   			$('#nationContinent').val(data.continent.id);
		   			
		   		},
		   		error:function(er, st, msg) { 
		   			console.log("ERROR: ", msg);
		   			console.log("ER: ", er);
		   			
		   	    }
		   	});
		
	});
$('.leagueEditBtn').on('click', function(){
		
		var leagueId = $(this).val();
		
		 $.ajax({
		   		url : "/pes/league/getLeagueById?leagueId="+leagueId,
		   		type : 'GET',
		   		dataType: 'json',
		   		contentType : 'application/json; charset=utf-8',
		   		success: function(data){  
		   			console.log('success');
		   			$('#leagueId').val(data.id);
		   			$('#leagueId').show();
		   			$('#leagueName').val(data.name);
		   			$('#leagueEmblem').val(data.emblem);
		   			$('#leagueEditForm').css("visibility",'visible');
		   			$('#continentEditForm').css("visibility",'hidden');
		   			$('#nationEditForm').css("visibility",'hidden');
		   			$('#clubEditForm').css("visibility",'hidden');
		   			$('#leagueNation').val(data.nation.id);
		   			
		   		},
		   		error:function(er, st, msg) { 
		   			console.log("ERROR: ", msg);
		   			console.log("ER: ", er);
		   			
		   	    }
		   	});
		
	});
$('.continentEditBtn').on('click', function(){
	
	var continentId = $(this).val();
	
	 $.ajax({
	   		url : "/pes/continent/getContinentById?continentId="+continentId,
	   		type : 'GET',
	   		dataType: 'json',
	   		contentType : 'application/json; charset=utf-8',
	   		success: function(data){  
	   			console.log('success');
	   			$('#continentId').val(data.id);
	   			$('#continentId').show();
	   			$('#continentName').val(data.name);
	   			$('#continentEmblem').val(data.emblem);
	   			$('#continentEditForm').css("visibility",'visible');
	   			$('#leagueEditForm').css("visibility",'hidden');
	   			$('#nationEditForm').css("visibility",'hidden');
	   			$('#clubEditForm').css("visibility",'hidden');
	   			
	   		},
	   		error:function(er, st, msg) { 
	   			console.log("ERROR: ", msg);
	   			console.log("ER: ", er);
	   			
	   	    }
	   	});
	
});
});