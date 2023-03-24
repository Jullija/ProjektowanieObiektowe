package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Item;

public class ItemFilter {

	private Item itemSpec = new Item();

	public Item getItemSpec() {
		return itemSpec;
	}
	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}

		// applies filter only if the flag (hardCover) is true)
		if (itemSpec.getCover() && !item.getCover()){
			return false;
		}

		// applies filter only if the flag (mobile) is true)
		if (itemSpec.getMobile() && !item.getMobile()){
			return false;
		}

		// applies filter only if the flag (guarantee) is true)
		if (itemSpec.getGuarantee() && !item.getGuarantee()){
			return false;
		}
		// applies filter only if the flag (video) is true)
		if (itemSpec.getVA() && !item.getVA()){
			return false;
		}

		return true;
	}

}