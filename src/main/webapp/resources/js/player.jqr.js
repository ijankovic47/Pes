$(function() {
	
	$('.playerEditBtn').on('click', function(){
		
		var playerId = $(this).val();
		
		 $.ajax({
		   		url : "/pes/player/getPlayerById?playerId="+playerId,
		   		type : 'GET',
		   		dataType: 'json',
		   		contentType : 'application/json; charset=utf-8',
		   		success: function(data){  
		   			$('#playerId').val(data.id);
		   			$('#playerId').show();
		   			$('#playerName').val(data.name);
		   			$('#playerEditForm').css("visibility",'visible');
		   			
		   		},
		   		error:function(er, st, msg) { 
		   			console.log("ERROR: ", msg);
		   			console.log("ER: ", er);
		   			
		   	    }
		   	});
		
	});
	
	$('#addPlayerBtn').on('click', function(){
		
		console.log('success');
			$('#playerId').val(null);
			$('#playerId').hide();
			$('#playerName').val(null);
			$('#playerEditForm').css("visibility",'visible');
	});
	
$('.playerStatsBtn').on('click', function(){
		
		var playerId = $(this).val();
		
		 $.ajax({
		   		url : "/pes/exhibition/getPlayerStats?playerId="+playerId,
		   		type : 'GET',
		   		dataType: 'json',
		   		contentType : 'application/json; charset=utf-8',
		   		success: function(data){  
		   			var table1='<table border="1"><tr><th>Total matches</th><th>Total wins</th><th>Total draws</th><th>Total loses</th><th>Goals scored per game</th><th>Goals conceded per game</th></tr>';
		   			table1+='<tr><td>'+data.totalMatches+'</td><td>'+data.totalWins+'('+data.winPercentage+'%)</td><td>'+
		   			data.totalDraws+'('+data.drawPercentage+'%)</td><td>'+data.totalLoses+'('+data.losePercentage+'%)</td><td>'+data.goalsScoredPerMatch+'</td><td>'+data.goalsConcededPerMatch+
		   			'</td></tr></table>';
	
		   			var map=data.playerStatsPerTeam;
		   			var out='<table border="1"><tr><th>Team</th><th>Total matches</th><th>Wins</th><th>Draws</th><th>Loses</th><th>Goals scored per match</th><th>Goals conceded per match</th></tr>';
		   			$.each(map, function(teamJson, playerStatsPerTeam) {
		   				var team=JSON.parse(teamJson);
		   				var image='<img alt="/images/NoImage.JPG" src="'+team.emblem+'" style="height: 80px;width: 80px;">';
		   				out+='<tr><td>'+image+team.name+'</td><td>'+playerStatsPerTeam.totalMatches+'</td><td>'+playerStatsPerTeam.totalWins+
		   				'('+playerStatsPerTeam.winPercentage+'%)</td><td>'+playerStatsPerTeam.totalDraws+
		   				'('+playerStatsPerTeam.drawPercentage+'%)</td><td>'+playerStatsPerTeam.totalLoses+'('+playerStatsPerTeam.losePercentage+'%)</td><td>'+playerStatsPerTeam.goalsScoredPerMatch+
		   				'</td><td>'+playerStatsPerTeam.goalsConcededPerMatch+'</td></tr>';
		   			});
		   			out+='</table>';
		   			$('#playerStatsPerTeam').html(out);
		   			$('#playerStats').html(table1);
		   			
		   		},
		   		error:function(er, st, msg) { 
		   			console.log("ERROR: ", msg);
		   			console.log("ER: ", er);
		   			
		   	    }
		   	});
		
		 $.ajax({
		   		url : "/pes/exhibition/getPlayerExhibitions?playerId="+playerId,
		   		type : 'GET',
		   		dataType: 'json',
		   		contentType : 'application/json; charset=utf-8',
		   		success: function(data){  
		   			var table='<table border="1"><tr><th>Player1</th><th>Team1</th><th>Score1</th><th>Score2</th><th>Team2</th><th>Player2</th><th>Date</th><th>Interrupted</th></tr>';
		   			for(var ex in data){
		   				var date=new Date(data[ex].date);
		   				var month = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
		   				var d = date.getDate() + " " + month[date.getMonth()] + ", " + date.getFullYear();
		   				var time = date.toLocaleTimeString().toLowerCase();
		   				var formattedDate=d+" "+time;
		   				console.log(d + " " + time);
		   				var player1Img='<img alt="/images/NoImage.JPG" src="'+data[ex].player1.image+'" style="height: 80px;width: 80px;">';
		   				var player2Img='<img alt="/images/NoImage.JPG" src="'+data[ex].player2.image+'" style="height: 80px;width: 80px;">';
		   				var team1Img='<img alt="/images/NoImage.JPG" src="'+data[ex].team1.emblem+'" style="height: 80px;width: 80px;">';
		   				var team2Img='<img alt="/images/NoImage.JPG" src="'+data[ex].team2.emblem+'" style="height: 80px;width: 80px;">';
		   				table+='<tr><td>'+player1Img+data[ex].player1.name+'</td><td>'+team1Img+data[ex].team1.name+'</td><td>'+data[ex].score1
		   				+'</td><td>'+data[ex].score2+'</td><td>'+team2Img+data[ex].team2.name+'</td><td>'+player2Img+data[ex].player2.name+'</td><td>'+formattedDate+'</td>';
		   				if(data[ex].interrupted!=null){
		   					table+='<td>true</td>';
		   				}
		   				else{
		   					table+='<td></td>';
		   				}
		   			}
		   			table+='</tr></table>';
		   			$('#playerMatches').html(table);
		   			
		   		},
		   		error:function(er, st, msg) { 
		   			console.log("ERROR: ", msg);
		   			console.log("ER: ", er);
		   			
		   	    }
		   	});
		
	});
});