package br.com.estudo.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {
	
	private Integer idUsuario;
	private String usuario;
	private String senha;
	private Date dataCadastro;
	private String nomeCompleto;
	private Boolean sexo;
	private Date dataNascimento;
	private String email;
	public String cpf;
	private Boolean ativo;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public Boolean getSexo() {
		return sexo;
	}
	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", usuario=" + usuario
				+ ", senha=" + senha + ", dataCadastro=" + dataCadastro
				+ ", nomeCompleto=" + nomeCompleto + ", sexo=" + sexo
				+ ", dataNascimento=" + dataNascimento + ", email=" + email
				+ ", cpf=" + cpf + ", ativo=" + ativo + "]";
	}
	
	public String dtFormatada(Date dt){
		SimpleDateFormat dataBR = new SimpleDateFormat("dd/MM/yyyy");  						        
		
		return dataBR.format(dt);	
	}
	
}
