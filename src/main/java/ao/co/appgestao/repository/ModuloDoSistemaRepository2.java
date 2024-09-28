package ao.co.appgestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ao.co.appgestao.model.ModuloDoSistema2;

@Repository
public interface ModuloDoSistemaRepository2 extends JpaRepository<ModuloDoSistema2, Integer>{

	//--- funcões func100: contagens -------------------------
	@Query(value = "SELECT count(*) as repeticoes " + 
				   "FROM tb_modulos_do_sistema2 " + 
				   "WHERE LEN(codigo) = 3 and " +
			       "      descricao = :descricaoSTR", nativeQuery = true)
	public int func101Count_RepeticoesPorDescricaoLen3(@Param("descricaoSTR") String descricaoSTR);
	
	
	@Query(value = "SELECT MAX(codigo) as max_codigo3 " + 
			       "FROM tb_modulos_do_sistema2 " + 
			       "WHERE LEN(codigo) = 3", nativeQuery = true)
	public String func102MaxCod_Len3();
	
	
	@Query(value = "SELECT count(*) as repeticoes " + 
				   "FROM tb_modulos_do_sistema2 " + 
				   "WHERE LEN(codigo) = 6 and " +
			       "      descricao = :descricaoSTR", nativeQuery = true)
	public int func103Count_RepeticoesPorDescricaoLen6(@Param("descricaoSTR") String descricaoSTR);
	
	
	@Query(value = "SELECT MAX(codigo) as max_codigo6 " + 
			       "FROM tb_modulos_do_sistema2 " + 
			       "WHERE LEN(codigo) = 6 and codigo_pai = :codigoPaiSTR", nativeQuery = true)
	public String func104MaxCod_Len6(@Param("codigoPaiSTR") String codigoPaiSTR);
	
	
	@Query(value = "SELECT MAX(codigo) as max_codigo9 " + 
			       "FROM tb_modulos_do_sistema2 " + 
			       "WHERE LEN(codigo) = 9 and codigo_pai = :codigoPaiSTR", nativeQuery = true)
	public String func105MaxCod_Len9(@Param("codigoPaiSTR") String codigoPaiSTR);
	
	
	@Query(value = "SELECT count(*) as repeticoes " + 
				   "FROM tb_modulos_do_sistema2 " + 
				   "WHERE LEN(codigo) = 9 and " +
			       "      descricao = :descricaoSTR", nativeQuery = true)
	public int func106Count_RepeticoesPorDescricaoLen9(@Param("descricaoSTR") String descricaoSTR);
	
	
	//--- funcões func200: Seleciona objecto -----------------
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE id = :moduloDoSistemaID", nativeQuery = true)
	public ModuloDoSistema2 func201FindOne_PorId(@Param("moduloDoSistemaID") Integer moduloDoSistemaID);	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE codigo_pai is null and LEN(codigo) = 3 and descricao = :descricaoSTR", nativeQuery = true)
	public ModuloDoSistema2 func202FindOne_PorDescricao(@Param("descricaoSTR") String descricaoSTR);
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE codigo_pai is null and LEN(codigo) = 3 and codigo = :codigoSTR", nativeQuery = true)
	public ModuloDoSistema2 func203FindOne_PorCodigo(@Param("codigoSTR") String codigoSTR);
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE codigo = :codigoSTR", nativeQuery = true)
	public ModuloDoSistema2 func204FindOne_PorCodigoStr(@Param("codigoSTR") String codigoSTR);
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE codigo = (select codigo_pai from  tb_modulos_do_sistema2 where codigo = :codigoSTR6)", nativeQuery = true)
	public ModuloDoSistema2 func205FindOne_CodigoLen3PorCodigoLen6(@Param("codigoSTR6") String codigoSTR6);
	
	
	
	//--- funcões func300: Seleciona lista -------------------
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE codigo_pai is null and LEN(codigo) = 3", nativeQuery = true)
	public List<ModuloDoSistema2> func301FindAll_PorCodigoLen3();
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE LEN(codigo) = 6 and codigo_pai = :codigoPaiLen3STR", nativeQuery = true)
	public List<ModuloDoSistema2> func302FindAll_PorCodigoPaiLen3(@Param("codigoPaiLen3STR") String codigoPaiLen3STR);
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE LEN(codigo) = 9 and codigo_pai = :codigoPaiLen6STR", nativeQuery = true)
	public List<ModuloDoSistema2> func303FindAll_PorCodigoPaiLen6(@Param("codigoPaiLen6STR") String codigoPaiLen6STR);
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE LEN(codigo) = 6 " +
		           "ORDER BY descricao", nativeQuery = true)
	public List<ModuloDoSistema2> func304FindAll_PorLen6OrdemPorDescricao();
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE codigo_pai = :codigoPaiSTR and LEN(codigo) = 6 " +
		           "ORDER BY descricao", nativeQuery = true)
	public List<ModuloDoSistema2> func305FindAll_PorCodigoLen6OrdemPorDescricao(@Param("codigoPaiSTR") String codigoPaiSTR);
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE codigo_pai = :codigoPaiSTR and LEN(codigo) = 6 " +
		           "      AND id NOT IN (select modulo_do_sistema_id from tb_grupos_de_privilegios2 where grupo_id = :grupoID) " +
		           "ORDER BY descricao", nativeQuery = true)
	public List<ModuloDoSistema2> func306FindAll_PorCodigoPaiEGrupo(@Param("codigoPaiSTR") String codigoPaiSTR, 
			                                                        @Param("grupoID") Integer grupoID);
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE codigo_pai LIKE :codigoPaiSTR% " +
		           "      AND caminho_ficheiro_xhtml is not null " +
		           "      AND id NOT IN (select modulo_do_sistema_id from tb_grupos_de_privilegios2 where grupo_id = :grupoID) " +
		           "ORDER BY descricao", nativeQuery = true)
	public List<ModuloDoSistema2> func307FindAll_PorCodigoPaiEGrupo(@Param("codigoPaiSTR") String codigoPaiSTR, 
			                                                        @Param("grupoID") Integer grupoID);
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE caminho_ficheiro_xhtml is not null " +
		           "ORDER BY descricao", nativeQuery = true)
	public List<ModuloDoSistema2> func308FindAll_SubModulos();
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE codigo = :codigoSTR and LEN(codigo) = 3 " +
		           "      AND codigo_pai is null " +
		           "ORDER BY descricao", nativeQuery = true)
	public List<ModuloDoSistema2> func309FindAll_PorCodigoLen3(@Param("codigoSTR") String codigoSTR);
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE codigo = :codigoSTR and LEN(codigo) = 6 " +
		           "ORDER BY descricao", nativeQuery = true)
	public List<ModuloDoSistema2> func310FindAll_PorCodigoLen6(@Param("codigoSTR") String codigoSTR);
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE codigo = :codigoSTR and LEN(codigo) = 9 " +
		           "ORDER BY descricao", nativeQuery = true)
	public List<ModuloDoSistema2> func311FindAll_PorCodigoLen9(@Param("codigoSTR") String codigoSTR);
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
		           "WHERE codigo = :codigoSTR3 or (LEN(codigo) = 6 and codigo_pai = :codigoSTR3) or (LEN(codigo) = 9 and codigo like :codigoSTR3%) " +
		           "ORDER BY descricao", nativeQuery = true)
	public List<ModuloDoSistema2> func311FindAll_PorCodigoLen3E6E9(@Param("codigoSTR3") String codigoSTR3);
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
			       "WHERE codigo = :codigoSTR6 or (LEN(codigo) = 9 and codigo_pai = :codigoSTR6) " +
		           "ORDER BY descricao", nativeQuery = true)
	public List<ModuloDoSistema2> func312FindAll_PorCodigoLen6E9(@Param("codigoSTR6") String codigoSTR6);
	
	
	
	@Query(value = "SELECT * " + 
			       "FROM tb_modulos_do_sistema2 " + 
			       "WHERE codigo_pai = :codigoSTR6 " +
		           "ORDER BY descricao", nativeQuery = true)
	public List<ModuloDoSistema2> func313FindAll_CodigoLen9PorCodigoLen6(@Param("codigoSTR6") String codigoSTR6);
	
	
}