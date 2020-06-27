package kr.or.connect.guestbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuessNumberController {
	@GetMapping("/guess")
	public String guess(@RequestParam(name="number",required=false)Integer number,HttpSession session,ModelMap model) {
		String message=null;
		if(number==null) {
			session.setAttribute("count", 0);
			session.setAttribute("randomNumber", (int)(Math.random()*100)+1);
			message="내가 제시한 숫자를 맞춰봐";
		}else {
			int count = (int)session.getAttribute("count");
			int randomNumber = (Integer)session.getAttribute("randomNumber");
			if(number<randomNumber) {
				message = "입력한 값은 답보다 작아";
				session.setAttribute("count", ++count);
			}else if(number>randomNumber) {
				message="입력한 값은 더 커";
				session.setAttribute("count", ++count);
			}else {
				message="맞았어" + ++count + "번째 맞춤";
				session.removeAttribute("count");
				session.removeAttribute("randomNumber");
			}

		}
		model.addAttribute("message",message);
		return "guess";
	}
}
