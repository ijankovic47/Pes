package konami.pes.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import konami.pes.domain.Continent;
import konami.pes.domain.League;
import konami.pes.services.ContinentService;

@Controller
@RequestMapping(value="/continent")
public class ContinentController {
	
	@Autowired
	ContinentService continentService;
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value="/getContinentById")
	@ResponseBody
	public Continent getContinentById(@RequestParam("continentId") Integer continentId){

		return continentService.getContinentById(continentId);
		
	}
	@RequestMapping(value="/saveOrUpdateContinent", method=RequestMethod.POST)
	public String saveOrUpdateContinent(@RequestParam("continentId") String continentId,@RequestParam("continentName") String continentName,@RequestParam("file") MultipartFile file){
		
		Continent c=new Continent();
		if(continentId!=null && !continentId.isEmpty()){
	    c=continentService.getContinentById(Integer.valueOf(continentId));
		}
		c.setName(continentName);
		
		if(!file.isEmpty()){
			String realPath=servletContext.getRealPath("/");
			File dir=new File(realPath+continentService.LEAGUES_CONTINENTS_IMAGES_PATH);
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
		 continentService.saveOrUpdateContinent(c);
		return "redirect:/team";
	}
}

