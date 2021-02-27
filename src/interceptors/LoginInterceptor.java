package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//The implementation of interface org.springframework.web.servlet.HandlerInterceptor 
//is used to intercept requests to the controllers.
//Interceptors working with the HandlerMapping on the framework
 //must implement the HandlerInterceptor interface.


//nota And a quick note – the main difference between HandlerInterceptor and HandlerInterceptorAdapter is that
//in the first one we need to override all three methods: preHandle(), postHandle() and afterCompletion(),
//whereas in the second we may implement only required methods

public class LoginInterceptor implements HandlerInterceptor {

	// :prehandle() – called before the actual handler is executed, but the view is not generated yet
	// If this method returns false, further processing is abandoned i.e. the
	// handler method is not called.

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//Notice the method returns a boolean value – 
		//which tells Spring if the request should be further processed by a handler 
		//(true) or not (false).

		HttpSession session = request.getSession();

		boolean isLogged = session.getAttribute("user") != null;
		boolean isLoginURL = request.getRequestURI().endsWith("login");
		boolean isPost = request.getMethod().equals("POST");

		String ctx = request.getContextPath();

		if (!isLogged && !isLoginURL) {
			response.sendRedirect(ctx + "/area-riservata/login");
			return false;

		}
		System.out.println("=== PRE HANDLE ===");
		System.out.println("Request URI: " + request.getRequestURI());
		System.out.println("Request Method: " + request.getMethod());
		System.out.println("Request Query String: " + request.getQueryString());
		return true;

	}

	// postHandle: postHandle() – called after the handler is executed

	// Good for post processing of what we started in preHandler method e.g.
	// performance logging.

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	//afterCompletion called after the complete request has finished and view was generated
	//Good for resource cleanups

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

		System.out.println("=== AFTER COMPLETION ===");
		System.out.println("Response ContentType: " + response.getContentType());
	}
}