package api.EndPoints;

/**
 * This class contains all the API URIS used in the project.
 * 
 * SWAGGER PETSTORE: USER MODULE
 * CRUD OPERATIONS:
 * POST: https://petstore.swagger.io/v2/user
 * GET: https://petstore.swagger.io/v2/user/{username}
 * PUT: https://petstore.swagger.io/v2/user/{username}
 * DELETE: https://petstore.swagger.io/v2/user/{username}
 * 
 */

public class Routes {
	
	//Base URL for all the modules.
	public static String base_url = "https://petstore.swagger.io/v2/";
	
	//USER MODULE URIS
	public static String post_URI = base_url + "user";
	public static String get_URI = base_url + "user/{username}";
	public static String put_URI = base_url + "user/{username}";
	public static String delete_URI = base_url + "user/{username}";
}
