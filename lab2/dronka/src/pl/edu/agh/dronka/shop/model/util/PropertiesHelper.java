package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		
		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName()); 
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("Używany", item.isSecondhand());

		switch(item.getCategory()){
			case BOOKS -> {
				propertiesMap.put("Liczba stron", item.getPages());
				propertiesMap.put("Twarda oprawa", item.getCover());}
			case ELECTRONICS -> {
				propertiesMap.put("Mobilny", item.getMobile());
				propertiesMap.put("Gwarancja", item.getGuarantee());
			}
			case MUSIC -> {
				propertiesMap.put("Gatunek muzyczny", item.getMusicGenre());
				propertiesMap.put("Dołączone video", item.getVA());
			}
			case FOOD -> {
				propertiesMap.put("Data przydatności do spożycia", item.getExpirationDate());
			}
		}




		
		return propertiesMap;
	}
}
