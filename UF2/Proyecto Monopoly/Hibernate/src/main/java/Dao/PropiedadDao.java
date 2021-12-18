package Dao;

import java.util.ArrayList;

import Monopoly.Propiedad;

public class PropiedadDao extends GenericDao<Propiedad, Integer> implements IPropiedadDao {

		public Propiedad getPropietatenCasella(int posicio){
			
			ArrayList<Propiedad> propiedades = (ArrayList<Propiedad>) this.list();
			for (Propiedad propiedad : propiedades) {
				if(propiedad.getPosicion() == posicio) {
					return propiedad;
				}
			}
			return null;
		}

}
