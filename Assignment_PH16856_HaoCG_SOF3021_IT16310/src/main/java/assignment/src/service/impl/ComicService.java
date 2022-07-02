package assignment.src.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import assignment.src.model.entity.Comic;
import assignment.src.model.entity.type.ComicType;
import assignment.src.repository.IComicRepository;
import assignment.src.service.IComicService;

@Service
public class ComicService implements IComicService{
	@Autowired
	private IComicRepository comicRepository;
	
	@Override
	public Page<Comic> getByPage(int pageNumber, int maxRecord) {
		Pageable pageable = PageRequest.of(pageNumber,maxRecord);
		Page<Comic> page = comicRepository.findAll(pageable);
		return page;
	}

	@Override
	public Comic insertNewComic(Comic comic) {
		comic.setComicId(null);
		return comicRepository.save(comic);		
	}

	@Override
	public String delateByComicId(Long id) {
		if(id != null) {
			Optional<Comic> optionalComic = comicRepository.findById(id);
			if(optionalComic.isPresent()) {
				comicRepository.deleteById(id);
				return optionalComic.get().toString();
			}
		}
		return "nịt";
	}

	@Override
	public void updateComic(Comic comic) {
		try {
			Long id = comic.getComicId();
			if(id != null) {
				Optional<Comic> optionalComic = comicRepository.findById(id);
			if(optionalComic.isPresent()) {
				comicRepository.save(comic);
			}
		}	
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

	@Override
	public Optional<Comic> getAComicByComicId(Long id) {
		return comicRepository.findById(id);
	}

//	@Override
//	public Page<Comic> findByTypeContaining(ComicType type,Pageable pageable) {
//		Pageable pageableType = null;
//		Page<Comic> page = comicRepository.findByTypeContaining(type, pageableType);
//		return page;
//	} 
	
	@Override
	public Page<Comic> findByComicNameContaining(String name,Pageable pageable) {
		Page<Comic> page = comicRepository.findByComicNameContaining(name, null);
		return page;
	}

	@Override
	public List<Comic> findAll() {
		return comicRepository.findAll();
	}

	@Override
	public Comic getAComicById(Long id) {
		return comicRepository.getAComicById(id);
	}
	
	public Optional<Comic> getAComicTypeOptional(Long id) {
		return comicRepository.findById(id);
	}

	@Override
	public int updateCurrentQuantityById(Long id, Integer quantity) {
		comicRepository.updateCurrentQuantityById(id, quantity);
		return quantity;
	}

	@Override
	public List<Comic> findByType(ComicType type) {
		return comicRepository.findByType(type);
	}
	
}
