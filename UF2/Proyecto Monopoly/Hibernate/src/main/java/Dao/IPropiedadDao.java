package Dao;

import Monopoly.Propiedad;

public interface IPropiedadDao extends IGenericDao<Propiedad, Integer> {
	
		public Propiedad getPropietatenCasella(int posicio);

}
