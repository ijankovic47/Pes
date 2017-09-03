package konami.pes.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import konami.pes.domain.Player;

import konami.pes.services.PlayerService;

@Controller
@RequestMapping(value="/player")
public class PlayerController {

	@Autowired
	PlayerService playerService;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value="/getPlayerImage",method=RequestMethod.GET)
	@ResponseBody
	public String getPlayerImage(@RequestParam("playerId") Integer playerId){
		
		return playerService.getPlayerImage(playerId);
	}
	@RequestMapping(method=RequestMethod.GET)
	public String showPlayers(Model model){
		
		List<Player> players=playerService.getAllPlayers();
		model.addAttribute("players", players);
		return "players";
	}
	@RequestMapping(value="/saveOrUpdatePlayer",method=RequestMethod.POST)
	public String saveOrUpdatePlayer(@RequestParam("playerId") String playerId,@RequestParam("playerName") String playerName,@RequestParam("file") MultipartFile file){
	
		Player p=new Player();
		if(playerId!=null && !playerId.isEmpty()){
	    p=playerService.getPlayerById(Integer.valueOf(playerId));
		}
		p.setName(playerName);
		
		
		if(!file.isEmpty()){
			String realPath=servletContext.getRealPath("/");
			File dir=new File(realPath+playerService.PLAYER_IMAGES_PATH);
			try {
				//byte[] bytes=file.getBytes();
		        String finalPath=dir+File.separator+file.getOriginalFilename();
		        if(p.getImage()!=null){
		        	File f=new File(dir+File.separator+p.getImage());
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
		        p.setImage(file.getOriginalFilename());
		       
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
		 playerService.savePlayer(p);
		return "redirect:/player";
	}
	
	@RequestMapping(value="/getPlayerById",method=RequestMethod.GET)
	@ResponseBody
	public Player getPlayerById(@RequestParam("playerId") Integer playerId){
		
		return playerService.getPlayerById(playerId);
	}
}
