$(function() {
	
	var player1Id=$('#player1').val();
	if(player1Id>0){
		getPlayerImage(player1Id,'1');
	}
	var player2Id=$('#player2').val();
	if(player2Id>0){
		getPlayerImage(player2Id,'2');
	}
	var league1name=$('#league1').val();
	var league2name=$('#league2').val();
	
	getLeagueEmblem(league1name,'1');
	getLeagueEmblem(league2name,'2');
	
	
	
	
	$('#league1').on('change', function(){
		
		var name = $(this).val();
		
		 $("#team1 option").remove();
		 $.ajax({
	   		url : "/pes/team/getTeamsByLeagueOrContinentName?leagueOrContinentName="+name,
	   		type : 'GET',
	   		dataType: 'json',
	   		contentType : 'application/json; charset=utf-8',
	   		success: function(data){  
	   			console.log('succes');
	   			console.log(data);
	   			if(data!=null&&data.length>0){
	   				
	   			for(i=0;i<data.length;i++){
	   				
	   				$("#team1").append( // Append an object to the inside of the select box
	   			            $("<option></option>") // Yes you can do this.
	   			                .text(data[i].name)
	   			                .val(data[i].id));
	   			}
	   			
	   			}   			
	   			if(data.length>0&&data[0].emblem!=null){
	   				$("#team1pic").attr("src","resources/images/teams/"+data[0].emblem);
	   			}
	   			else{
	   				$("#team1pic").attr("src","resources/images/NoImage.JPG");
	   			}
	   		},
	   		error:function(er, st, msg) { 
	   			console.log("ERROR: ", msg);
	   			console.log("ER: ", er);
	   			
	   	    }
	   	});
		 
		 
		 $.ajax({
		   		url : "/pes/match/getLeagueOrContinentEmblem?leagueOrContinentName="+name,
		   		type : 'GET',
		   		dataType: 'text',
		   		contentType : 'application/json; charset=utf-8',
		   		success: function(data){  
		   			console.log('succes');
		   			console.log(data);
		   			if(data){
		   				$("#league1pic").attr("src","resources/images/leagues_continents/"+data);
		   			}
		   			else{
		   				$("#league1pic").attr("src","resources/images/NoImage.jpg");
		   			}
		   		},
		   		error:function(er, st, msg) { 
		   			console.log("ERROR: ", msg);
		   			console.log("ER: ", er);
		   			
		   	    }
		   	});
		 
});
	$('#league2').on('change', function(){
		
		var name = $(this).val();
		console.log(name);
		$("#team2 option").remove();
		 $.ajax({
	   		url : "/pes/team/getTeamsByLeagueOrContinentName?leagueOrContinentName="+name,
	   		type : 'GET',
	   		dataType: 'json',
	   		contentType : 'application/json; charset=utf-8',
	   		success: function(data){  
	   			console.log('succes');
	   			console.log(data);
	   			if(data!=null&&data.length>0){
	   			
	   			for(i=0;i<data.length;i++){
	   				$("#team2").append( // Append an object to the inside of the select box
	   			            $("<option></option>") // Yes you can do this.
	   			                .text(data[i].name)
	   			                .val(data[i].id));
	   			}
	   			
	   			}
                if(data.length>0&&data[0].emblem!=null){
                	$("#team2pic").attr("src","resources/images/teams/"+data[0].emblem);
                }
                else{
                	$("#team2pic").attr("src","resources/images/NoImage.JPG");
                }
	   		},
	   		error:function(er, st, msg) { 
	   			console.log("ERROR: ", msg);
	   			console.log("ER: ", er);
	   			
	   	    }
	   	});
		 
		 
		 $.ajax({
		   		url : "/pes/match/getLeagueOrContinentEmblem?leagueOrContinentName="+name,
		   		type : 'GET',
		   		dataType: 'text',
		   		contentType : 'application/json; charset=utf-8',
		   		success: function(data){  
		   			console.log('succes');
		   			console.log(data);
		   			if(data){
		   				$("#league2pic").attr("src","resources/images/leagues_continents/"+data);
		   			}
		   			else{
		   				$("#league2pic").attr("src","resources/images/NoImage.JPG");
		   			}
		   		},
		   		error:function(er, st, msg) { 
		   			console.log("ERROR: ", msg);
		   			console.log("ER: ", er);
		   			
		   	    }
		   	});
		 
});
//	$('#team1').on('change', function(){
//	
//		var id = $(this).val();
//		
//		 $.ajax({
//	   		url : "/pes/team/getTeamEmblem?teamId="+id,
//	   		type : 'GET',
//	   		dataType: 'json',
//	   		contentType : 'application/json; charset=utf-8',
//	   		success: function(data){  
//	   			console.log('succes');
//	   			console.log(data);
//	   			$("#team1pic").attr("src","resources/images/teams/"+data);
//	   		},
//	   		error:function(er, st, msg) { 
//	   			console.log("ERROR: ", msg);
//	   			console.log("ER: ", er);
//	   			
//	   	    }
//	   	});
//	});
	
	$('#player1').on('change', function(){
		
		var id = $(this).val();
//		var link="<a href='player/getStats?playerId="+id+"'>Stats</a>";
//		console.log(link);
//		$("#viewStats").html(link)
		 $.ajax({
	   		url : "/pes/player/getPlayerImage?playerId="+id,
	   		type : 'GET',
	   		dataType: 'text',
	   		contentType : 'application/json; charset=utf-8',
	   		success: function(data){  
	   			console.log('succes');
	   			console.log(data);
	   			if(data){
	   				$("#player1pic").attr("src","resources/images/players/"+data);
	   			}
	   			else{
	   				$("#player1pic").attr("src","resources/images/NoImage.JPG");
	   			}
	   		},
	   		error:function(er, st, msg) { 
	   			console.log("ERROR: ", msg);
	   			console.log("ER: ", er);
	   			
	   	    }
	   	});
	});
$('#player2').on('change', function(){
		
		var id = $(this).val();
		
		 $.ajax({
	   		url : "/pes/player/getPlayerImage?playerId="+id,
	   		type : 'GET',
	   		dataType: 'text',
	   		contentType : 'application/json; charset=utf-8',
	   		success: function(data){  
	   			console.log('succes');
	   			console.log(data);
	   			if(data){
	   				$("#player2pic").attr("src","resources/images/players/"+data);
	   			}
	   			else{
	   				$("#player2pic").attr("src","resources/images/NoImage.JPG");
	   			}
	   		},
	   		error:function(er, st, msg) { 
	   			console.log("ERROR: ", msg);
	   			console.log("ER: ", er);
	   			
	   	    }
	   	});
	});
	
	
	});
function changeTeamEmblem(index){
	
	var id = $('#team'+index).val();
	
	 $.ajax({
   		url : "/pes/team/getTeamEmblem?teamId="+id,
   		type : 'GET',
   		dataType: 'text',
   		contentType : 'application/json; charset=utf-8',
   		success: function(data){  
   			console.log('succes');
   			console.log(data);
   			if(data){
   				$("#team"+index+"pic").attr("src","resources/images/teams/"+data);
   			}
   			else{
   				$("#team"+index+"pic").attr("src","resources/images/NoImage.JPG");
   			}
   		},
   		error:function(er, st, msg) { 
   			console.log("ERROR: ", msg);
   			console.log("ER: ", er);
   			
   	    }
   	});
}
function getPlayerImage(playerId, oneOrTwo){
	
//	var link="<a href='player/getStats?playerId="+id+"'>Stats</a>";
//	console.log(link);
//	$("#viewStats").html(link)
	 $.ajax({
   		url : "/pes/player/getPlayerImage?playerId="+playerId,
   		type : 'GET',
   		dataType: 'text',
   		contentType : 'application/json; charset=utf-8',
   		success: function(data){  
   			console.log('succes');
   			console.log(data);
   			if(data){
   				$("#player"+oneOrTwo+"pic").attr("src","resources/images/players/"+data);
   			}
   			else{
   				$("#player"+oneOrTwo+"pic").attr("src","resources/images/NoImage.JPG");
   			}
   		},
   		error:function(er, st, msg) { 
   			console.log("ERROR: ", msg);
   			console.log("ER: ", er);
   			
   	    }
   	});
};

function  getLeagueEmblem(leagueName, oneOrTwo){
	
	$("#team"+oneOrTwo+" option").remove();
	 $.ajax({
  		url : "/pes/team/getTeamsByLeagueOrContinentName?leagueOrContinentName="+leagueName,
  		type : 'GET',
  		dataType: 'json',
  		contentType : 'application/json; charset=utf-8',
  		success: function(data){  
  			console.log('succes');
  			console.log(data);
  			if(data!=null&&data.length>0){
  				var team=$('#team'+oneOrTwo+'name').val();
  				
  				var counter=0;
  			for(i=0;i<data.length;i++){
  				
  				if(team==data[i].id){
  					$("#team"+oneOrTwo).append( // Append an object to the inside of the select box
  	  			            $("<option selected></option>") // Yes you can do this.
  	  			                .text(data[i].name)
  	  			                .val(data[i].id));
  					counter=i;
  			}
  				else{
  					$("#team"+oneOrTwo).append( // Append an object to the inside of the select box
  	  			            $("<option></option>") // Yes you can do this.
  	  			                .text(data[i].name)
  	  			                .val(data[i].id));}
  				}
  			
  			}   			
  			if(data.length>0&&data[counter].emblem!=null){
  				$("#team"+oneOrTwo+"pic").attr("src","resources/images/teams/"+data[counter].emblem);
  			}
  			else{
  				$("#team"+oneOrTwo+"pic").attr("src","resources/images/NoImage.JPG");
  			}
  		},
  		error:function(er, st, msg) { 
  			console.log("ERROR: ", msg);
  			console.log("ER: ", er);
  			
  	    }
  	});
	
	 $.ajax({
	   		url : "/pes/match/getLeagueOrContinentEmblem?leagueOrContinentName="+leagueName,
	   		type : 'GET',
	   		dataType: 'text',
	   		contentType : 'application/json; charset=utf-8',
	   		success: function(data){  
	   			console.log('succes');
	   			console.log(data);
	   			if(data){
	   				$("#league"+oneOrTwo+"pic").attr("src","resources/images/leagues_continents/"+data);
	   			}
	   			else{
	   				$("#league"+oneOrTwo+"pic").attr("src","resources/images/NoImage.JPG");
	   			}
	   		},
	   		error:function(er, st, msg) { 
	   			console.log("ERROR: ", msg);
	   			console.log("ER: ", er);
	   			
	   	    }
	   	});
}
