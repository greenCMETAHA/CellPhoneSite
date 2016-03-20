/**
 * %W% %E% Gleb Vasilchenko
 * 15.2.2015 
 * Singleton class for string constants, used in this project
 *
 */
package workset.services;

/**
 * Singleton class for string constants, used in this project
 *
 * @version 1.0,  15 Feb 2015
 * @author Gleb Vasilchenko
 */
public class ConstantsGroup {
	/* variable for working with class. Pattern Singleton*/
	private static ConstantsGroup constantsGroup;

	/* for format data in text */
	public static final boolean SQL_DATA =true;   //data format: YEAR-MONTH-DATA

	/* for format data in text */
	public static final boolean STANDART_DATA =false; //Standart format: .getTime().toString();

	/* a string constant for a field "id" in database tables */
	public static final String ID="id";

	/* a string constant for a field "parentID" (ID for categories) in database tables */
	public static final String PARENT_ID="parentId";

	/* a string constant for a field "title" in database tables */
	public static final String TITLE="title";
	
	/* a string constant for a field "keywords" in database tables */
	public static final String KEYWORDS="keywords";

	/* a  for a field "description" in database tables */
	public static final String DESCRIPTION="description";

	/* a string constant for a field "maintext" in database tables */
	public static final String MAINTEXT="maintext";
	
	/* a string constant for a field "articledate" (date of article) in database tables */
	public static final String ARTICLE_DATE="articledate";

	/* a string constant for a field "email" in database tables */
	public static final String EMAIL="email";
	
	/* a string constant for a field "password" in database tables */
	public static final String PASSWORD="password";

	/* a string constant for a field "name" in database tables */
	public static final String NAME="name";

	/* a string constant for a get a category's name at the creation of a bean "Category" */
	public static final String CATEGORY_NAME="categoryname";

	/* a string constant for a field "host" (for for database) */
	public final static String HOST = "host";

	/* a string constant for a field "database" (for for database) */
	public final static String DB = "database";
	public final static String DB_POOL = "databasePool";

	/* a string constant for a field "user" (for for database) */
	public final static String USER = "user";

	/* a string constant for empty strings in queries */
	public final static String EMPTY_STRING = "<?>";


	/* String constants for SQL-queries  */
	public static final String EXIST_USER			="existUser";
	public static final String GET_ARTICLE			="getArticle";
	public static final String GET_ARTICLES_CATEGORY	="getArticlesCategory";
	public static final String GET_ARTICLES_ALL		="getArticlesAll";
	public static final String ADD_ARTICLE			="addArticle";
	public static final String DELETE_ARTICLE		="deleteArticle";
	public static final String GET_CATEGORY		="getCategory";
	public static final String GET_CATEGORY_ID		="getCategoryId";
	public static final String GET_CATEGORIES		="getCategories";

	/* String constants for servlets  */
	public static final String SHOW_NEW_PAGE		="ShowNewPage";
	public static final String SHOW_ALL			="showAll";
	public static final String SHOW				="show";
	public static final String COMBOBOX_CATEGORIES		="combobox_Categories";
	public static final String CREATE_NEW_ARTICLE		="CreateNewArticle";
	public static final String EDIT_ARTICLE		="EditArticle";
	public static final String SUBMIT		="submit";

	/* String constants for cookies  */
	public static final String USER_PASSWORD = "userPassword";
	public static final String SITE_USER = "newssiteUser";
	public static final String SITE_PASSWORD = "newssitePassword";

	/* String constants for user information  */
	public static final String USER_INFO = "userInfo";

	/* String constants for pagination  */
	public static final byte ARTICLES_ON_PAGE = 3;
	public static final byte ALL_ARTICLES=0;

	/* constructor */
	public ConstantsGroup() {}

	/* Method for realization of pattern Singleton */
	public static ConstantsGroup start(){
		if(constantsGroup == null)
			constantsGroup = new ConstantsGroup();
			
		if (constantsGroup==null) //ooops...
			WorkLog.writeInLog("Can not create class ConstantsGroup()");
		
		return constantsGroup;
	}

	@Override
	public String toString(){
		return "Class with contstans";
	}	

}
