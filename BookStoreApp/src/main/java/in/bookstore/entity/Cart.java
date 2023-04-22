package in.bookstore.entity;

public class Cart {
	
	private int cid;
	private int bid;
	private int uid;
	private String book_Name;
	private String author_Name;
	private Double price;
	private Double total_price;
	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}
	/**
	 * @return the bid
	 */
	public int getBid() {
		return bid;
	}
	/**
	 * @param bid the bid to set
	 */
	public void setBid(int bid) {
		this.bid = bid;
	}
	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	/**
	 * @return the book_Name
	 */
	public String getBook_Name() {
		return book_Name;
	}
	/**
	 * @param book_Name the book_Name to set
	 */
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	/**
	 * @return the author_Name
	 */
	public String getAuthor_Name() {
		return author_Name;
	}
	/**
	 * @param author_Name the author_Name to set
	 */
	public void setAuthor_Name(String author_Name) {
		this.author_Name = author_Name;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the total_price
	 */
	public Double getTotal_price() {
		return total_price;
	}
	/**
	 * @param total_price the total_price to set
	 */
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}
	
	

}
