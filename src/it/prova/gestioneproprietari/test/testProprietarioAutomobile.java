package it.prova.gestioneproprietari.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.prova.gestioneproprietari.dao.EntityManagerUtil;
import it.prova.gestioneproprietari.model.Automobile;
import it.prova.gestioneproprietari.model.Proprietario;
import it.prova.gestioneproprietari.service.MyServiceFactory;
import it.prova.gestioneproprietari.service.automobile.AutomobileService;
import it.prova.gestioneproprietari.service.proprietario.ProprietarioService;

public class testProprietarioAutomobile {

	public static void main(String[] args) {
		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();

		try {
			System.out.println(
					"in tabella Proprietari ci sono " + proprietarioService.listAllPropietari().size() + " elementi");

			System.out.println(
					"in tabellaAutomobili ci sono " + automobileService.listAllAutomobili().size() + " elementi");
			// testInserisciNuocoProprietario(proprietarioService);
			// System.out.println(
			// "in tabella Proprietari ci sono " +
			// proprietarioService.listAllPropietari().size() + " elementi");

			// testInserisciNuovaAuto(proprietarioService, automobileService);
			// System.out.println(
			// "in tabellaAutomobili ci sono " +
			// automobileService.listAllAutomobili().size() + " elementi");

			testModificaProprietario(proprietarioService);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}
	}

	public static void testInserisciNuocoProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("..........testInserisciNuovoProprietario inizio.........");

		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("23-05-1986");

		Proprietario nuovoProprietario = new Proprietario("Giovanna", "guglio", "GVNGGL86F918NSAJKAXSNX", dataNascita);

		proprietarioService.inserisciNuovo(nuovoProprietario);

		if (nuovoProprietario.getId() == null)
			throw new RuntimeException(" testInserisciNuovoProprietario FAILED");

		System.out.println("testInserisciNuovoProprietario PASSED");

	}

	public static void testInserisciNuovaAuto(ProprietarioService proprietarioService,
			AutomobileService automobileService) throws Exception {
		System.out.println("...........testInserisciNuovaAutomobile............ ");

		List<Proprietario> listaProprietari = proprietarioService.listAllPropietari();
		Automobile nuovaAutomobile = new Automobile("Volkswagen", "Tiguan", "GH609HK", 1998);
		nuovaAutomobile.setProprietario(listaProprietari.get(1));

		automobileService.inserisciNuova(nuovaAutomobile);

		if (nuovaAutomobile.getId() == null)
			throw new RuntimeException("testInserisciNuovaAuto fallito");

		System.out.println("............testInserisciNuovoProprietario PASSED...........");
	}

	public static void testModificaProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println("..........testModificaProprietario inizio........");
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("04-11-1956");
		Proprietario proprietarioDaModificare = new Proprietario("Francesca", "verdi", "FRNVRD56T9145DGFHS",
				dataNascita);
		proprietarioDaModificare.setId(3L);

		proprietarioService.aggiorna(proprietarioDaModificare);
		if (proprietarioDaModificare.getId() == null)
			throw new RuntimeException("testModificaProprietario FAILED");

		System.out.println("..........testModificaProprietario PASSED............");

	}

}
//Proprietario nuovoProprietario2= new Proprietario("Giovanna", "guglio", "GVNGGL86F918NSAJKAXSNX", dataNascita2);
//Date dataNascita2= new SimpleDateFormat("dd-MM-yyyy").parse("23-05-1986");