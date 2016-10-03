package annotation;

@Controller(value="AAA")
public class AAAController {

	@RequestMapping("/aaa")
	public String doA()  {
		return "aaa.jsp";
	}
}
