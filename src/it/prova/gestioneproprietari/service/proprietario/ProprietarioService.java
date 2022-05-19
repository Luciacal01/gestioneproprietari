package it.prova.gestioneproprietari.service.proprietario;

import java.util.List;

import it.prova.gestioneproprietari.model.Proprietario;

public interface ProprietarioService {
	public List<Proprietario> listAllPropietari() throws Exception;

	public Proprietario caricaSingoloProprietario(Long id) throws Exception;

	public void aggiorna(Proprietario proprietarioInstance) throws Exception;

	public void inserisciNuovo(Proprietario proprietarioInstance) throws Exception;

	public void rimuovi(Long idAutomobileInstance) throws Exception;
}
