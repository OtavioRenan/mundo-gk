package br.com.mundogk.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import br.com.mundogk.modells.Artigo;


public interface ArtigoRepository extends JpaRepository<Artigo, Long>{

}
