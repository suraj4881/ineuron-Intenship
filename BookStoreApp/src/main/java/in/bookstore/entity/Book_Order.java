package in.bookstore.entity;

public class Book_Order {

	private int id;
	private String orderid;
	private String username;
	private String email;
	private String phno;
	private String fulladd;
	private String bookname;
	/**
	 * @return the bookname
	 */
	public String getBookname() {
		return bookname;
	}
	/**
	 * @param bookname the bookname to set
	 */
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	private String author;
	private String price;
	private String paymentType;
	public Book_Order() {
		super();
		
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the orderid
	 */
	public String getOrderid() {
		return orderid;
	}
	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phno
	 */
	public String getPhno() {
		return phno;
	}
	/**
	 * @param phno the phno to set
	 */
	public void setPhno(String phno) {
		this.phno = phno;
	}
	/**
	 * @return the fulladd
	 */
	public String getFulladd() {
		return fulladd;
	}
	/**
	 * @param fulladd the fulladd to set
	 */
	public void setFulladd(String fulladd) {
		this.fulladd = fulladd;
	}
	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}
	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	@Override
	public String toString() {
		return "Book_Order [id=" + id + ", orderid=" + orderid + ", username=" + username + ", email=" + email
				+ ", phno=" + phno + ", fulladd=" + fulladd + ", bookname=" + bookname + ", author=" + author
				+ ", price=" + price + ", paymentType=" + paymentType + "]";
	}
	
	
}
