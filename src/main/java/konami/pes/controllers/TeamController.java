package konami.pes.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import konami.pes.domain.Club;
import konami.pes.domain.Continent;
import konami.pes.domain.League;
import konami.pes.domain.Nation;
import konami.pes.domain.Player;
import konami.pes.domain.Team;
import konami.pes.services.ClubService;
import konami.pes.services.ContinentService;
import konami.pes.services.LeagueService;
import konami.pes.services.NationService;
import konami.pes.services.TeamService;

@Controller
@RequestMapping(value="/team")
public class TeamController {

	@Autowired
	ClubService clubService;
	@Autowired
	NationService nationService;
	@Autowired
	TeamService teamService;
	@Autowired
	LeagueService leagueService;
	@Autowired
	ServletContext servletContext;
	@Autowired
	ContinentService continentService;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String showClubs(Model model){
		List<League> leagues=leagueService.getAllLeagues();
		List<Club> clubs=clubService.getAllClubs();
		List<Continent> continents=continentService.getAllContinents();
		List<Nation> nations=nationService.getAllNations();
		model.addAttribute("leagues", leagues);
		model.addAttribute("clubs",clubs);
		model.addAttribute("continents",continents);
		model.addAttribute("nations",nations);
		return "teams";
	}
	@RequestMapping(value="/saveOrUpdateClub",method=RequestMethod.POST)
	public String saveOrUpdateClub(@RequestParam("clubId") String clubId,@RequestParam("clubName") String clubName,@RequestParam("clubLeague") Integer clubLeagueId,@RequestParam("file") MultipartFile file){
		
		Club c=new Club();
		if(clubId!=null && !clubId.isEmpty()){
	    c=clubService.getClubById(Integer.valueOf(clubId));
		}
		c.setName(clubName);
		c.setLeague(leagueService.getLeagueById(clubLeagueId));
		
		
		if(!file.isEmpty()){
			String realPath=servletContext.getRealPath("/");
			File dir=new File(realPath+clubService.CLUB_IMAGES_PATH);
			try {
				//byte[] bytes=file.getBytes();
		        String finalPath=dir+File.separator+file.getOriginalFilename();
		        if(c.getEmblem()!=null){
		        	File f=new File(dir+File.separator+c.getEmblem());
		        	if(f.exists()){
		        		f.delete();	 
		        	}
		        }
//		        BufferedOutputStream bout=new BufferedOutputStream(  
//		                 new FileOutputStream(finalPath));  
//		        bout.write(bytes);  
//		        bout.flush();  
//		        bout.close(); 
		        file.transferTo(new File(finalPath));
		        c.setEmblem(file.getOriginalFilename());
		       
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		 clubService.saveClub(c);
		return "redirect:/team";
	}
	@RequestMapping(value="/saveOrUpdateNation",method=RequestMethod.POST)
	public String saveOrUpdateNation(@RequestParam("nationId") String nationId,@RequestParam("nationName") String nationName,@RequestParam("nationContinent") Integer nationContinentId,@RequestParam("file") MultipartFile file){
		
		Nation n=new Nation();
		if(nationId!=null && !nationId.isEmpty()){
	    n=nationService.getNationById(Integer.valueOf(nationId));
		}
		n.setName(nationName);
		n.setContinent(continentService.getContinentById(nationContinentId));
		
		
		if(!file.isEmpty()){
			String realPath=servletContext.getRealPath("/");
			File dir=new File(realPath+nationService.NATION_IMAGES_PATH);
			try {
				byte[] bytes=file.getBytes();
		        String finalPath=dir+File.separator+file.getOriginalFilename();
		        if(n.getEmblem()!=null){
		        	File f=new File(dir+File.separator+n.getEmblem());
		        	if(f.exists()){
		        		f.delete();	 
		        	}
		        }
		        BufferedOutputStream bout=new BufferedOutputStream(  
		                 new FileOutputStream(finalPath));  
		        bout.write(bytes);  
		        bout.flush();  
		        bout.close(); 
		        n.setEmblem(file.getOriginalFilename());
		       
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		 nationService.saveOrUpdateNation(n);
		return "redirect:/team";
	}
	
	@RequestMapping(value="/getClubById",method=RequestMethod.GET)
	@ResponseBody
	public Club getClubById(@RequestParam("clubId") Integer clubId){
		
		return clubService.getClubById(clubId);
	}
	@RequestMapping(value="/getNationById",method=RequestMethod.GET)
	@ResponseBody
	public Nation getNationById(@RequestParam("nationId") Integer nationId){
		
		return nationService.getNationById(nationId);
	}
	
	@RequestMapping(value="/getTeamsByLeagueOrContinentName",method=RequestMethod.GET)
	@ResponseBody
	public List<Team> getTeamsByLeagueOrContinentName(@RequestParam("leagueOrContinentName") String name){
		
		List<Team> teams=new ArrayList<Team>();
		List<Club> clubs=new ArrayList<Club>();
		List<Nation> nations=new ArrayList<Nation>();
		clubs=clubService.getClubsByLeagueName(name);
		if(!clubs.isEmpty()){
			for(Club c:clubs){
				teams.add(c);
			}
		}
		else{
			nations=nationService.getNationsByContinentName(name);
			for(Nation n:nations){
				teams.add(n);
			}
		}
		return teams;
	}
	@RequestMapping(value="/getTeamEmblem",method=RequestMethod.GET)
	@ResponseBody
	public String getTeamEmblem(@RequestParam("teamId") Integer teamId){
		
		return teamService.getTeamEmblem(teamId);
	}
}
