package assignment.src.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import assignment.src.model.entity.Comic;
import assignment.src.model.entity.type.ComicType;

public interface IComicService {
	
	Page<Comic> getByPage(int pageNumber, int maxRecord);
	
	Comic insertNewComic(Comic comic);
	
	String delateByComicId(Long id);
	
	void updateComic(Comic comic);
	
	List<Comic> findAll();
	
	Optional<Comic> getAComicByComicId(Long id);
	
//	Page<Comic> findByTypeContaining(ComicType type,Pageable pageable);
	
	Page<Comic> findByComicNameContaining(String comicName,Pageable pageable);
	
	Comic getAComicById(Long id);
	
	int updateCurrentQuantityById(Long id,Integer quantity);
	
	List<Comic> findByType(ComicType type);
	
}
