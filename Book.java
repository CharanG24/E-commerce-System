




/* A book IS A product that has additional information - e.g. title, author

 	 A book also comes in different formats ("Paperback", "Hardcover", "EBook")

 	 The format is specified as a specific "stock type" in get/set/reduce stockCount methods.

 */
public class Book extends Product implements Comparable<Book>
{
	private String author;
	private String title;
	private int year;// added year for bonus BooksByAuthor action

	// Stock related information NOTE: inherited stockCount variable is used for EBooks
	int paperbackStock;
	int hardcoverStock;

	public Book(String name, String id, double price, int paperbackStock, int hardcoverStock, String title, String author, int year)
	{
		// Make use of the constructor in the super class Product. Initialize additional Book instance variables. 
  	 	// Set category to BOOKS 
		super(name, id, price, 100000, Product.Category.BOOKS);
		this.title = title;
		this.author = author;
		this.year =  year;
		this.paperbackStock = paperbackStock;
		this.hardcoverStock = hardcoverStock;
	}

	public String getAuthor()
	{
		return author;
	}

	// Check if a valid format  
	public boolean validOptions(String productOptions)
	{
		// check productOptions for "Paperback" or "Hardcover" or "EBook"
  		// if it is one of these, return true, else return false
		return productOptions.equalsIgnoreCase("PaperBack") || productOptions.equals("EBook") || productOptions.equals("Hardcover");
	}

	// Override getStockCount() in super class.
	// This method assumes validOptions() has been called
	public int getStockCount(String productOptions)
	{
		// Use the productOptions to check for (and return) the number of stock for "Paperback" etc
  		// Use the variables paperbackStock and hardcoverStock at the top. 
  		// For "EBook", use the inherited stockCount variable.
		if (productOptions == null) return super.getStockCount(productOptions); 

		if (productOptions.equalsIgnoreCase("paperback")) //Using If statement to check if string value equals "Paperback" 
			return paperbackStock;
		else if (productOptions.equalsIgnoreCase("hardcover"))//Using If statement to check if string value equals "Hardcover"
			return hardcoverStock;
		else
			return super.getStockCount(productOptions); //using getStockCount() from product to get the stock of Ebook
	}

	public void setStockCount(int stockCount, String productOptions)
	{
		// Use the productOptions to check for (and set) the number of stock for "Paperback" etc
   		// Use the variables paperbackStock and hardcoverStock at the top. 
   		// For "EBook", set the inherited stockCount variable.
		if (productOptions == null) return;

		if (productOptions.equalsIgnoreCase("Paperback"))//Using If statement to check if string value equals "Paperback" 
			paperbackStock = stockCount;
		else if (productOptions.equalsIgnoreCase("Hardcover"))//Using If statement to check if string value equals "Hardcover"
			hardcoverStock = stockCount;
		else
			super.setStockCount(stockCount, null);//using setStockCount() from product to set the stock of Ebook
	}

	/*
	 * When a book is ordered, reduce the stock count for the specific stock type
	 */
	public void reduceStockCount(String productOptions)
	{
		// Use the productOptions to check for (and reduce) the number of stock for "Paperback" etc
   		// Use the variables paperbackStock and hardcoverStock at the top. 
   		// For "EBook", set the inherited stockCount variable.
		if (productOptions == null) super.reduceStockCount(null);

		if (productOptions.equalsIgnoreCase("Paperback"))//Using If statement to check if string value equals "Paperback" 
			paperbackStock--;
		else if (productOptions.equalsIgnoreCase("Hardcover"))//Using If statement to check if string value equals "Hardcover"
			hardcoverStock--;
		else
			super.reduceStockCount(null);//using reduceStockCount() from product to set the stock of Ebook
	}
	/*
	 * Print product information in super class and append Book specific information title and author
	 */
	public void print()
	{
		super.print(); 
		System.out.print(" Book Title: " + title +  " Author: " + author);
	}

	public void printSecond()
	{
		super.print();
		System.out.print(" Title: " + title + " Author: " + author + " Year Published: " + year);
	}

	public int compareTo(Book otherBook)
	{	// Using Integer.compare(x,y) to compare year published
		return this.year - otherBook.year;
	}
}
