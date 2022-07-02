package assignment.src.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import assignment.src.model.entity.Comic;
import assignment.src.model.entity.type.ComicType;

public interface IComicRepository extends JpaRepository<Comic, Long>{
//	Page<Comic> findByTypeContaining(ComicType type,Pageable pageable);
	Page<Comic> findByComicNameContaining(String comicName,Pageable pageable);
	@Query(value = "Select * from Comic c where c.comic_id = :id", nativeQuery = true)Comic getAComicById(@Param("id")Long id);
	@Query(value = "update comic set current_quantity = :quantity where comic_id = :id ",nativeQuery = true) int updateCurrentQuantityById(@Param("id")Long id,@Param("quantity")Integer quantity);
	List<Comic> findByType(ComicType type);
}
