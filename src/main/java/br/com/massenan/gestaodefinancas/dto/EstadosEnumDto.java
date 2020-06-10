package br.com.massenan.gestaodefinancas.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.massenan.gestaodefinancas.domain.EstadosEnum;

public class EstadosEnumDto {
	
	private int ordinal;
	private String sigla;
	
	public static List<EstadosEnumDto> parse() {
		List<EstadosEnumDto> dtos = new ArrayList<EstadosEnumDto>();
		
		for(EstadosEnum st : EstadosEnum.values()) {
			EstadosEnumDto dto = new EstadosEnumDto();
			dto.setOrdinal(st.ordinal());
			dto.setSigla(st.getSigla());
			dtos.add(dto);
		}
		return dtos;
	}
	
	public int getOrdinal() {
		return ordinal;
	}
	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
