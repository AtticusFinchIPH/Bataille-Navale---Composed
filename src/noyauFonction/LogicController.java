package noyauFonction;

import java.util.List;
import java.util.logging.Logger;

import application.controller.RouteController;
import application.grilles.grilleplacement.IViewGrillePlacement;
import application.grilles.grilleplacement.ViewGrillePlacement;
import application.placementscene.PresentationPlacementScene;
import noyauFonction.caze.CaseNavire;
import noyauFonction.caze.ICase;
import noyauFonction.joueur.Humain;
import noyauFonction.joueur.IJoueur;
import noyauFonction.joueur.Ordinateur;
import noyauFonction.navires.ENavire;
import noyauFonction.navires.attaquesNavire.AttaqueEnCroix;
import noyauFonction.navires.typeNavire.ContreTorpilleur;
import noyauFonction.navires.typeNavire.Croiseur;
import noyauFonction.navires.typeNavire.INavire;
import noyauFonction.navires.typeNavire.PorteAvion;
import noyauFonction.navires.typeNavire.SousMarin;
import noyauFonction.navires.typeNavire.Torpilleur;

public class LogicController {
	
	private Logger LOGGER = Logger.getLogger(LogicController.class.getName());
	
	private RouteController routeController;
	
	private IJoueur player1;
	private IJoueur player2;
	
	private int gameType = 0;
	
	private int turnCounter;
	private int succesHitCounter;
	
	public LogicController(RouteController routeController) {
		// TODO Initialize logical elements
		this.routeController = routeController;
		gameType = 0;
		turnCounter = 0;
		succesHitCounter = 0;
	}
	
	// Receive from Starter
	public void startGame() {
		
		if (routeController.getCurrentView().equals("ViewStarter")) {
			if (routeController.getCurrentEtat().equals("EtatSinglePlayer")) {		
				routeController.setCurrentView(routeController.getPresPlacement().getViewPlacementScene());
				routeController.commandChangeView();
				player1 = new Humain();
				player2 = new Ordinateur();
				gameType = 1;
			};
			if (routeController.getCurrentEtat().equals("EtatOffline")) {
				routeController.setCurrentView(routeController.getPresOnWorking().getViewOnWorkingNotification());
				routeController.commandChangeView();
			};
			if (routeController.getCurrentEtat().equals("EtatOnline")) {
				routeController.setCurrentView(routeController.getPresOnWorking().getViewOnWorkingNotification());
				routeController.commandChangeView();
			};
		}else {
			LOGGER.info("startGame with wrong View!!!");
		}
	}
	
	// Receive from OnWorking, Placement
	public void backToStarter() {
		if (routeController.getCurrentView().equals("ViewOnWorkingNotification")) {
			routeController.setCurrentView(routeController.getPresStarter().getViewStarter());
			routeController.setCurrentEtat(routeController.getPresStarter().getEtatVide());
			routeController.commandSwitchEtatInitial();
			routeController.commandChangeView();
		} else if (routeController.getCurrentView().equals("ViewPlacementScene")
				&& routeController.getCurrentEtat().equals("EtatSleepingPlace")) {
			routeController.setCurrentView(routeController.getPresStarter().getViewStarter());
			routeController.setCurrentEtat(routeController.getPresStarter().getEtatVide());
			routeController.commandSwitchEtatInitial();
			routeController.commandChangeView();
		} else {
			LOGGER.info("backToStarter with wrong View or Etat!!!");
		}
	}
	
	// Place ships manually 
	public void startPlaceShips() {
		Boolean pass = false;
		int nbPlacedShips = 0;
		
	}
	
	// Place ships automatically
	public void placeShipsRandomly() {	
		if(routeController.getCurrentView().equals("ViewPlacementScene")
		&& routeController.getCurrentEtat().equals("EtatPlayer1Place")) {				
			this.player1.initialiserRandomGrilleP();
			routeController.setCurrentEtat(routeController.getPresPlacement().getEtatPlayer1());

//			for(int i=0; i<10; i++) {
//				for(int j=0; j<10; j++) {
//					ICase caze = this.player1.getGrillep().getCaze(i, j);
//					if(caze instanceof CaseNavire) {
//						routeController.commandShowTorpilleurShips(i, j);
//					}
//				}
//			}
			
//			for(int i=0; i<10; i++) {
//				for(int j=0; j<10; j++) {				
//						routeController.commandDrawOcean(i, j);
//				}
//			}
			
//			routeController.commandDrawInitAllShips();
//			for(ENavire enavire: this.player1.getGrillep().getMapnavire().keySet()) {
//				// List all ENavires		
//				int sizeNavire = this.player1.getGrillep().getMapnavire().get(enavire).size();
//				for(int i = 0; i<sizeNavire; i++) {
//					// List all caseNavire
//					List<CaseNavire> lcaseNavire = this.player1.getGrillep().getMapnavire().get(enavire.ContreTorpilleur).get(i).getLcaseNav();
//					for (CaseNavire caseNavire: lcaseNavire) {
//						ENavire enaContreTorpilleur = enavire.ContreTorpilleur;
//						ENavire enaCroiseur = enavire.Croiseur;
//						ENavire enaPorteAvion = enavire.PorteAvion;
//						ENavire enaSousMarin = enavire.SousMarin;
//						ENavire enaTorpilleur = enavire.Torpilleur;
//						int posX = caseNavire.getPosX();
//						int posY = caseNavire.getPosY();
//						if(enavire.equals(enaContreTorpilleur)) {
//							System.out.println(" ContreTorpilleur-3");
//							routeController.commandShowContreTorpilleurShips(posX, posY);
//						}
//						if(enavire.equals(enaCroiseur)) {
//							System.out.println("Croiseur-4");
//							routeController.commandShowCroisseurShips(posX, posY);
//						}
//						if(enavire.equals(enaPorteAvion)) {
//							System.out.println("PorteAvion-8");
//							routeController.commandShowPorteAvionShips(posX, posY);
//						}
//						if(enavire.equals(enaSousMarin)) {
//							System.out.println("SousMarin-3");
//							routeController.commandShowSousMarinShips(posX, posY);
//						}
//						if(enavire.equals(enaTorpilleur)) {
//							System.out.println("Torpilleur-2");
//							routeController.commandShowTorpilleurShips(posX, posY);
//						}
//					}
//				}
//			}
			
			showPlacedShips();
			routeController.commandStopAutoPlace();
		} else if(routeController.getCurrentView().equals("ViewPlacementScene")
		&& routeController.getCurrentEtat().equals("EtatPlayer2Place")) {
			LOGGER.info("We haven't created this part!!!");
		} else {
			LOGGER.info("placeShipsRandomly with wrong View or Etat!!!");
		}
	}
	
	public void showPlacedShips() {
		ENavire enaContreTorpilleur = ENavire.ContreTorpilleur;
		ENavire enaCroiseur = ENavire.Croiseur;
		ENavire enaPorteAvion = ENavire.PorteAvion;
		ENavire enaSousMarin = ENavire.SousMarin;
		ENavire enaTorpilleur = ENavire.Torpilleur;
		
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaContreTorpilleur).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			routeController.commandShowContreTorpilleurShips(posX, posY);
			System.out.println("ContreTorpilleur-Purple:" +posX+", "+posY);
		}
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaCroiseur).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			routeController.commandShowCroisseurShips(posX, posY);
			System.out.println("Croisseur-Yellow:" +posX+", "+posY);
		}
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaPorteAvion).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			routeController.commandShowPorteAvionShips(posX, posY);
			System.out.println("PorteAvion-Gray:" +posX+", "+posY);
		}
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaSousMarin).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			routeController.commandShowSousMarinShips(posX, posY);
			System.out.println("SousMarin-GreenYellow:" +posX+", "+posY);
		}
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaTorpilleur).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			routeController.commandShowTorpilleurShips(posX, posY);
			System.out.println("Torpilleur-Green:" +posX+", "+posY);
		}
		
//		for(int i=0; i<10; i++) {
//			for(int j=0; j<10; j++) {
//				ICase caze = this.player1.getGrillep().getCaze(i, j);
//				if(caze instanceof CaseNavire) {
//					System.out.println(i+", "+j);
//				}
//			}
//		}
	}

	// Auto place ships for computer
	public void placeShipsPlayer2() {
		if(routeController.getCurrentView().equals("ViewPlacementScene")
				&& routeController.getCurrentEtat().equals("EtatPlayer2Place") 
				&& gameType == 1) {
			this.player2.initialiserRandomGrilleP();
			routeController.commandEndPlacement();
			routeController.setCurrentView(routeController.getPresPlay().getViewPlayScene());
			routeController.commandChangeView();
			showPlacedShips();
			showComputerShips();
		}
	}
	
	private void showComputerShips() {
		ENavire enaContreTorpilleur = ENavire.ContreTorpilleur;
		ENavire enaCroiseur = ENavire.Croiseur;
		ENavire enaPorteAvion = ENavire.PorteAvion;
		ENavire enaSousMarin = ENavire.SousMarin;
		ENavire enaTorpilleur = ENavire.Torpilleur;
		
		System.out.println();
		System.out.println("Computer Placement Ships :");
		for(CaseNavire caseNav: this.player2.getGrillep().getNavire(enaContreTorpilleur).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();;
			System.out.println("ContreTorpilleur-Purple:" +posX+", "+posY);
		}
		for(CaseNavire caseNav: this.player2.getGrillep().getNavire(enaCroiseur).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			System.out.println("Croisseur-Yellow:" +posX+", "+posY);
		}
		for(CaseNavire caseNav: this.player2.getGrillep().getNavire(enaPorteAvion).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			System.out.println("PorteAvion-Gray:" +posX+", "+posY);
		}
		for(CaseNavire caseNav: this.player2.getGrillep().getNavire(enaSousMarin).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			System.out.println("SousMarin-GreenYellow:" +posX+", "+posY);
		}
		for(CaseNavire caseNav: this.player2.getGrillep().getNavire(enaTorpilleur).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			System.out.println("Torpilleur-Green:" +posX+", "+posY);
		}
	}
	
	// Identify which Ship is chosen for this attacking
	public String identifyShip(int chosenX, int chosenY, String chosenAction) {
		if(routeController.getCurrentPlayer() == 1 
				&& routeController.getCurrentView().equals("ViewPlayScene")
				&& routeController.getCurrentEtat().equals("EtatChosenShip")
				&& gameType == 1) {
			System.out.println(chosenX+", "+chosenY+" : "+chosenAction);
			String chosenShip = findShip(chosenX, chosenY);
			System.out.println(chosenShip);
			if(chosenShip == null) {
				routeController.commandLeadToEtatSleeping();
				routeController.commandSetInfoLabel("Invalid Case!!!"+"\n"+"Chosen case must belong to a ship!");
			} else if (chosenShip != null && chosenAction.equals("Normal Attack")) {
				routeController.commandSetInfoLabel(chosenShip+" prepares for "+chosenAction);				
			} else if (chosenShip != null && chosenAction.equals("Cross Attack")) {
				routeController.commandSetInfoLabel(chosenShip+" prepares for "+chosenAction+"."
						+"\n"+"Attention, you will lose 3 turns for this type of attack!");
			} else if(chosenShip != null && chosenAction.equals("Flare Shot")) {
				if(chosenShip.equals("SousMarin")) {
					routeController.commandSetInfoLabel(chosenShip+" prepares for "+chosenAction+"."
							+"\n"+"Attention, you will lose 5 turns for this!");
				} else {
					routeController.commandLeadToEtatSleeping();
					routeController.commandSetInfoLabel("Invalid Case!!!"+"\n"+chosenAction+" begins only from a Sous Marin!");
				}
			} else if (chosenShip != null && chosenAction.equals("Shift Ship")) {
				// TODO : Check shift condition
				routeController.commandLeadToEtatSleeping();
//				routeController.commandSetInfoLabel(chosenShip+" prepares for "+chosenAction
//							+"\n"+"Choose case to move to");
				routeController.commandSetInfoLabel("This function is on working process. \n Please choose other action!");
				// TODO : Function to shift ship
			} else if (chosenShip != null && chosenAction.equals("Rotate Ship")) {
				// TODO : Rotate ship
				routeController.commandLeadToEtatSleeping();
				routeController.commandSetInfoLabel("This function is on working process. \n Please choose other action!");
			}
			return chosenShip;
			// TODO : Consider case when ship couldn't attack
		} else {
			LOGGER.info("Problem at identifyShip function!!!");
			return null;
		}
	}
	
	public String findShip(int chosenX, int chosenY) {
		// TODO : Consider case when ship couldn't attack
		
		ENavire enaContreTorpilleur = ENavire.ContreTorpilleur;
		ENavire enaCroiseur = ENavire.Croiseur;
		ENavire enaPorteAvion = ENavire.PorteAvion;
		ENavire enaSousMarin = ENavire.SousMarin;
		ENavire enaTorpilleur = ENavire.Torpilleur;
		
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaContreTorpilleur).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			if(chosenX == posX && chosenY == posY) {
				return "ContreTorpilleur";
			}
		}
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaCroiseur).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			if(chosenX == posX && chosenY == posY) {
				return "Croiseur";
			}
		}
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaPorteAvion).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			if(chosenX == posX && chosenY == posY) {
				return "PorteAvion";
			}
		}
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaSousMarin).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			if(chosenX == posX && chosenY == posY) {
				return "SousMarin";
			}
		}
		for(CaseNavire caseNav: this.player1.getGrillep().getNavire(enaTorpilleur).getLcaseNav()) {
			int posX = caseNav.getPosX();
			int posY = caseNav.getPosY();
			if(chosenX == posX && chosenY == posY) {
				return "Torpilleur";
			}
		}
		return null;
	}
	
	// Execution the attack
	public void shootExecution(String attackingShip, int posX, int posY, String chosenAction) {
		if(routeController.getCurrentPlayer() == 1 
				&& routeController.getCurrentView().equals("ViewPlayScene")
				&& routeController.getCurrentEtat().equals("EtatAttacked")
				&& gameType == 1) {
			switch (chosenAction) {
			case "Normal Attack":
				player1NormalAttack(attackingShip, posX, posY);
				if (isEndGame(player2)) {
					showWinner("You win !!!");
				} else {
					// Computer plays 1 turn
					computerRandomAttack();
				}			
				break;
			case "Cross Attack":
				player1CrossAttack(attackingShip, posX, posY);
				if (isEndGame(player2)) {
					showWinner("You win !!!");
				} else {
					// Computer plays 3 turns
					for(int i=0; i<3; i++) {
						computerRandomAttack();
					}
				}
				break;
			case "Flare Shot" :
				player1FlareShot(attackingShip, posX, posY);
				// Computer plays 5 turns
				for(int i=0; i<5; i++) {
					computerRandomAttack();				
				}
				break;
			default:
				break;
			}
		}
		// If game continues...
		if(!isEndGame(player1) && !isEndGame(player2)) {
			// TODO : Back to EtatSleeping, Back to PlayScene, Show new Grilles
			routeController.commandLeadToEtatSleeping();
			routeController.commandChangeView();		
			showPlacedShips();
			showPlacementShot();
			showMemoireShot();
		}
	}
	
	private void player1NormalAttack(String attackingShip, int posX, int posY) {
		INavire iContreTorpilleur = new ContreTorpilleur();
		INavire iCroiseur = new Croiseur();
		INavire iPOrteAvion = new PorteAvion();
		INavire iSousMarin = new SousMarin();
		INavire iTorpilleur = new Torpilleur();
		
		switch (attackingShip) {
		case "ContreTorpilleur":
			player1.alAttaque(iContreTorpilleur, player2, posX, posY);
			break;
		case "Croiseur":
			player1.alAttaque(iCroiseur, player2, posX, posY);
			break;
		case "PorteAvion":
			player1.alAttaque(iPOrteAvion, player2, posX, posY);
			break;
		case "SousMarin":
			player1.alAttaque(iSousMarin, player2, posX, posY);
			break;
		case "Torpilleur":
			player1.alAttaque(iTorpilleur, player2, posX, posY);
			break;
		default:
			break;
		}
	}
	
	private void player1CrossAttack(String attackingShip, int posX, int posY) {
		INavire iContreTorpilleur = new ContreTorpilleur();
		INavire iCroiseur = new Croiseur();
		INavire iPOrteAvion = new PorteAvion();
		INavire iSousMarin = new SousMarin();
		INavire iTorpilleur = new Torpilleur();
		
		switch (attackingShip) {
		case "ContreTorpilleur":
			iContreTorpilleur.setCompoAttaque(new AttaqueEnCroix());
			player1.alAttaque(iContreTorpilleur, player2, posX, posY);
			break;
		case "Croiseur":
			iCroiseur.setCompoAttaque(new AttaqueEnCroix());
			player1.alAttaque(iCroiseur, player2, posX, posY);
			break;
		case "PorteAvion":
			iPOrteAvion.setCompoAttaque(new AttaqueEnCroix());
			player1.alAttaque(iPOrteAvion, player2, posX, posY);
			break;
		case "SousMarin":
			iSousMarin.setCompoAttaque(new AttaqueEnCroix());
			player1.alAttaque(iSousMarin, player2, posX, posY);
			break;
		case "Torpilleur":
			iTorpilleur.setCompoAttaque(new AttaqueEnCroix());
			player1.alAttaque(iTorpilleur, player2, posX, posY);
			break;
		default:
			break;
		}
	}
	
	private void player1FlareShot(String attackingShip, int posX, int posY) {
			player1.aLEclair( player2, posX, posY);
	}
	
	private void computerRandomAttack() {
		turnCounter++;
		player2.alAttaqueRandom(player1);
		if (isEndGame(player1)) {
			showWinner("Computer wins !!!");
		}
	}
	
	private Boolean isEndGame(IJoueur player) {
		ENavire enaContreTorpilleur = ENavire.ContreTorpilleur;
		ENavire enaCroiseur = ENavire.Croiseur;
		ENavire enaPorteAvion = ENavire.PorteAvion;
		ENavire enaSousMarin = ENavire.SousMarin;
		ENavire enaTorpilleur = ENavire.Torpilleur;

		if(player.getGrillep().getNavire(enaTorpilleur) == null
				&& player.getGrillep().getNavire(enaContreTorpilleur) == null
				&& player.getGrillep().getNavire(enaCroiseur) == null
				&& player.getGrillep().getNavire(enaPorteAvion) == null
				&& player.getGrillep().getNavire(enaSousMarin) == null) {
			return true;
		}
		return false;
	}
	
	private void showWinner(String winner) {
		routeController.setCurrentView(routeController.getPresEnd().getViewEnd());
		routeController.commandChangeView();
		routeController.commandShowWinner(winner);
	}
	
	// Show ships are shot on GrillePlacement
	private void showPlacementShot() {
		// TODO Auto-generated method stub

	}
	
	// Show shot place on GrilleMemoire
	private void showMemoireShot() {
		// TODO Auto-generated method stub

	}
}
