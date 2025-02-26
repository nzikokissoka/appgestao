package ao.co.appgestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ao.co.appgestao.model.HabilitacaoLiteraria;

@Repository
public interface HabilitacaoLiterariaRepository extends JpaRepository<HabilitacaoLiteraria, Integer>{

	//--- funcões func100: contagens -------------------------
	@Query(value="SELECT count(*) "
			   + "FROM tb_habilitacoes_literarias", nativeQuery=true)
	public int func101Count_Registros();
	
	
	//--- funcões func200: Seleciona objecto -----------------
	
	//--- funcões func300: Seleciona lista -------------------
	@Query(value="SELECT * "
			   + "FROM tb_habilitacoes_literarias "
			   + "ORDER BY id", nativeQuery=true)
	public List<HabilitacaoLiteraria> func301FindAll_OrdenarPorNome();
	
}