package konami.pes.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import konami.pes.domain.Club;
import konami.pes.domain.League;
import konami.pes.services.LeagueService;
import konami.pes.services.NationService;

@Controller
@RequestMapping(value="/league")
public class LeagueController {
	
	@Autowired
	LeagueService leagueService;
	@Autowired
	NationService nationService;
	@Autowired
	ServletContext servletContext;
	

	@RequestMapping(value="/saveOrUpdateLeague", method=RequestMethod.POST)
	public String saveOrUpdateLeague(@RequestParam("leagueId") String leagueId,@RequestParam("leagueName") String leagueName,@RequestParam("leagueNation") Integer leagueNationId,@RequestParam("file") MultipartFile file){
		
		League l=new League();
		if(leagueId!=null && !leagueId.isEmpty()){
	    l=leagueService.getLeagueById(Integer.valueOf(leagueId));
		}
		l.setName(leagueName);
		l.setNation(nationService.getNationById(leagueNationId));
		
		
		if(!file.isEmpty()){
			String realPath=servletContext.getRealPath("/");
			File dir=new File(realPath+leagueService.LEAGUES_CONTINENTS_IMAGES_PATH);
			try {
				//byte[] bytes=file.getBytes();
		        String finalPath=dir+File.separator+file.getOriginalFilename();
		        if(l.getEmblem()!=null){
		        	File f=new File(dir+File.separator+l.getEmblem());
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
		        l.setEmblem(file.getOriginalFilename());
		       
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		 leagueService.saveOrUpdateLeague(l);
		return "redirect:/team";
	}
	@RequestMapping(value="/getLeagueById")
	@ResponseBody
	public League getLeagueById(@RequestParam("leagueId") Integer leagueId){
		
		return leagueService.getLeagueById(leagueId);
	}
}
