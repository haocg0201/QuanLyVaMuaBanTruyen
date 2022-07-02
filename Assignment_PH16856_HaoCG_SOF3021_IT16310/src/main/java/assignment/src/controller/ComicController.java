package assignment.src.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import assignment.src.common.CommonConst;
import assignment.src.model.entity.Comic;
import assignment.src.model.entity.type.ComicType;
import assignment.src.repository.IComicRepository;
import assignment.src.service.impl.ComicService;


@Controller
@RequestMapping("/admin/comics")
public class ComicController {
	@Autowired
	private ComicService comicService;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest req;
	
	@Autowired
	HttpServletResponse res;
	
	@GetMapping()
	public String getAll(
			Model model,
		    @RequestParam(name="pageNumber",defaultValue = "0",required=false)int pageNmber,
		    @RequestParam(name="name",required=false)String comicName ){	
		Page<Comic> comicPage = null;
		
		if(org.springframework.util.StringUtils.hasText(comicName)) {
			Pageable pageable = PageRequest.of(pageNmber,CommonConst.PAGE_SIZE);
			comicPage =  comicService.findByComicNameContaining(comicName,pageable);
			model.addAttribute("page",comicPage);
		}else {
			comicPage =  comicService.getByPage(pageNmber, CommonConst.PAGE_SIZE);
			model.addAttribute("page",comicPage);
		}
		return "/templates/admin/comics";
	}	
	
	@GetMapping("/delete/{id}")
	public String deleteByComicId(@PathVariable("id")Long id) {
		comicService.delateByComicId(id);
		return "forward:/admin/comics?pageNumber=0&&name=";
	}
	

	
	@GetMapping("/comic-creator")
	public String comicCreator(Model model) {
		model.addAttribute("comic",new Comic());
		ComicType[] arrType = ComicType.values();
		for(ComicType type : arrType) {
			System.out.println(type);
		}			
		model.addAttribute("arrType",arrType);
		return "/templates/admin/comic-creator";
	}	
	
	@PostMapping("/store")
	public String storeNewComic(@ModelAttribute("comic")Comic comic) {
		comicService.insertNewComic(comic);
		return "redirect:/admin/comics?pageNumber=0&&name=";
	}
	
	@GetMapping("/edit/{id}")
	public String editComic(@PathVariable("id")Long id,
							Model model) {		
		Optional<Comic> optionalComic = comicService.getAComicByComicId(id);
		model.addAttribute("comic",optionalComic.get());
		ComicType[] arrType = ComicType.values();
		model.addAttribute("arrType",arrType);
		
		return "/templates/admin/comic-editor";
	}
	
	@PostMapping("/update/{id}")
	public String updateAComic(@PathVariable("id")Long id,
							   @ModelAttribute("comic")Comic comic
								) {
		if(comic.getImage().length() == 0) {
			Comic c = comicService.getAComicById(id);
			comic.setImage(c.getImage());
		}
		comic.setComicId(id);
		System.out.println(comic.toString());
		comicService.updateComic(comic);
		return "redirect:/admin/comics?pageNumber=0&&name=";
	}
	
//	@GetMapping("/{type}")
//	public String getAllByType(Model model,
//						 @PathVariable("type")ComicType type
//					     ){	
//		Pageable pageable = PageRequest.of(0,CommonConst.PAGE_SIZE);
//		Page<Comic> comicPage =  comicService.findByTypeContaining(type,pageable);
//		model.addAttribute("page",comicPage);
//		return "redirect:/templates/admin/comics";
//	}
}
