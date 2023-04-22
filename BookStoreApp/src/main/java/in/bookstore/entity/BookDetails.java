package in.bookstore.entity;

public class BookDetails {
	
	private int book_Id;
	private String book_Name;
	private String book_Author;
	private String book_Price;
	private String book_Category;
	private String book_Status;
	private String book_Photo;
	private String book_Email;
	
	
	public BookDetails(String book_Name, String book_Author, String book_Price, String book_Category,
			String book_Status, String book_Photo, String book_Email) {
		super();
		
		this.book_Name = book_Name;
		this.book_Author = book_Author;
		this.book_Price = book_Price;
		this.book_Category = book_Category;
		this.book_Status = book_Status;
		this.book_Photo = book_Photo;
		this.book_Email = book_Email;
	}
	
	public int getBook_Id() {
		return book_Id;
	}
	
	public void setBook_Id(int book_Id) {
		this.book_Id = book_Id;
	}
	
	public String getBook_Name() {
		return book_Name;
	}
	
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	/**
	 * @return the book_Author
	 */
	public String getBook_Author() {
		return book_Author;
	}
	
	public void setBook_Author(String book_Author) {
		this.book_Author = book_Author;
	}
	
	public String getBook_Price() {
		return book_Price;
	}
	
	public void setBook_Price(String book_Price) {
		this.book_Price = book_Price;
	}
	
	public String getBook_Category() {
		return book_Category;
	}
	
	public void setBook_Category(String book_Category) {
		this.book_Category = book_Category;
	}
	
	public String getBook_Status() {
		return book_Status;
	}
	
	public void setBook_Status(String book_Status) {
		this.book_Status = book_Status;
	}
	
	public String getBook_Photo() {
		return book_Photo;
	}
	
	public void setBook_Photo(String book_Photo) {
		this.book_Photo = book_Photo;
	}
	/**
	 * @return the book_Email
	 */
	public String getBook_Email() {
		return book_Email;
	}
	
	public void setBook_Email(String book_Email) {
		this.book_Email = book_Email;
	}
	@Override
	public String toString() {
		return "BookDetails [book_Id=" + book_Id + ", book_Name=" + book_Name + ", book_Author=" + book_Author
				+ ", book_Price=" + book_Price + ", book_Category=" + book_Category + ", book_Status=" + book_Status
				+ ", book_Photo=" + book_Photo + ", book_Email=" + book_Email + "]";
	}
	
}
