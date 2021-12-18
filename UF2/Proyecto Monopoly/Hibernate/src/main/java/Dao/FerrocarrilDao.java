package Dao;

import java.util.ArrayList;

import Monopoly.Ferrocarril;

public class FerrocarrilDao extends GenericDao<Ferrocarril, Integer> implements IFerrocarrilDao {

		public ArrayList<Ferrocarril> ferrocarrilsVeins(int idFerrocarril) {
			
			Ferrocarril f = this.get(idFerrocarril);
			
			return (ArrayList<Ferrocarril>) f.getVecinos();
		}
		
		public boolean isFerrocarrilVei(int idF1, int idF2){
			
			Ferrocarril f = this.get(idF1);
			Ferrocarril f2 = this.get(idF2);
			
			if(f.getVecinos().contains(f2)){
				return true;
			}else{
				return false;
			}
			
		}
}
