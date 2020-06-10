package br.com.massenan.gestaodefinancas.domain;

public enum EstadosEnum {
	
	SAO_PAULO("SP"), 
	RIO_DE_JANEIRO("RJ"),
	RIO_GRANDE_DO_NORTE("RN"),
	RIO_GRANDE_DO_SUL("RS"),
	PARAIBA("PB"),
	AMAPA("AP"),
	RORAIMA("RR"),
	AMAZONAS("AM"),
	MATO_GROSSO_DO_SUL("MS"),
	MATO_GROSSO("MT"),
	PERNAMBUCO("PE"),
	ALAGOAS("AL"),
	PIAUI("PI"),
	TOCANTINS("TO"),
	PARANA("PR"),
	MINAS_GERAIS("MG"),
	SANTA_CATARINA("SC"),
	ESPIRITO_SANTO("ES"),
	ACRE("AC"),
	DISTRITO_FEDERAL("DF"),
	GOIAS("GO"),
	PARA("PA"),
	RONDONIA("RO"),
	MARANHAO("MA"),
	BAHIA("BA"),
	CEARA("CE"),
	SERGIPE("SE");

	private final String sigla;
	
	private EstadosEnum(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}
	
	
	
	
	
	

}
