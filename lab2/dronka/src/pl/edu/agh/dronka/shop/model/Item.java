package pl.edu.agh.dronka.shop.model;

import java.time.LocalDate;
import java.util.Date;

public class Item {

	private String name;

	private Category category;

	private int price;

	private int quantity;
	private int bookPages;
	private boolean hardCover;
	private boolean mobile;
	private boolean guarantee;
	private Date expirationDate;
	private MusicGenre genre;
	private boolean videoAttached;

	private boolean secondhand;

	private boolean polish;

	public Item(String name, Category category, int price, int quantity) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	public Item() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setBookPages(int pages){
		this.bookPages = pages;
	}
	public int getPages(){
		return bookPages;
	}

	public void setHardCover(boolean cover){
		this.hardCover = cover;
	}
	public boolean getCover(){
		return hardCover;
	}
	public void setExpirationDate(Date date){this.expirationDate = date;}
	public Date getExpirationDate(){return expirationDate;}
	public void setMusicGenre(MusicGenre genre){this.genre = genre;}
	public MusicGenre getMusicGenre(){return genre;}

	public void setMobile(boolean mobile){
		this.mobile = mobile;
	}
	public boolean getMobile(){
		return mobile;
	}

	public void setGuarantee(boolean guar){
		this.guarantee = guar;
	}
	public boolean getGuarantee(){
		return guarantee;
	}

	public void setVideoAttached(boolean att){
		this.videoAttached = att;
	}
	public boolean getVA(){
		return videoAttached;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setSecondhand(boolean secondhand) {
		this.secondhand = secondhand;
	}

	public boolean isSecondhand() {
		return secondhand;
	}

	public void setPolish(boolean polish) {
		this.polish = polish;
	}

	public boolean isPolish() {
		return polish;
	}

	@Override
	public String toString() {
		return getName();
	}
}
