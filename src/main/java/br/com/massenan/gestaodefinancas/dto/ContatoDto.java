package br.com.massenan.gestaodefinancas.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.massenan.gestaodefinancas.domain.Contato;
import br.com.massenan.gestaodefinancas.domain.EstadosEnum;

public class ContatoDto {
	
	private Long id;
	private String nome;
	private String telefone;
	private String email;
	private String cidade;
	private boolean ativo;
	private String estado;
	
	public static List<ContatoDto> parse(List<Contato> contatos) {
		List<ContatoDto> lista = new ArrayList<ContatoDto>();
		contatos.forEach(c -> lista.add(parse(c)));
		return lista;
	}
	
	public static Contato parse(ContatoDto contatoDto) {
		Contato con = new Contato();
		con.setNome(contatoDto.getNome());
		con.setTelefone(contatoDto.getTelefone());
		con.setEmail(contatoDto.getEmail());
		con.setCidade(contatoDto.getCidade());
		con.setAtivo(contatoDto.isAtivo());
		con.setEstado(EstadosEnum.valueOf(contatoDto.getEstado()));
		return con;
	}
	
	public static ContatoDto parse(Contato contato) {
		ContatoDto dto = new ContatoDto();
		dto.setNome(contato.getNome());
		dto.setTelefone(contato.getTelefone());
		dto.setEmail(contato.getEmail());
		dto.setCidade(contato.getCidade());
		dto.setAtivo(contato.isAtivo());
		return dto;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
