package Dao;

import java.util.ArrayList;

import Monopoly.Ferrocarril;

public interface IFerrocarrilDao extends IGenericDao<Ferrocarril, Integer> {
	
		public ArrayList<Ferrocarril> ferrocarrilsVeins(int idFerrocarril);
		
		public boolean isFerrocarrilVei(int idF1, int idF2);
}
