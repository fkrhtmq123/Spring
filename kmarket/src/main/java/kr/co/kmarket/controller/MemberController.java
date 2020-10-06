package kr.co.kmarket.controller;

import java.security.MessageDigest;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.kmarket.persistence.MemberRepo;
import kr.co.kmarket.persistence.TermsRepo;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.TermsVO;

@Controller
public class MemberController {
	
	@Autowired
	private TermsRepo termsrepo;
	
	@Autowired
	private MemberRepo memberrepo;
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String login(MemberVO vo, HttpSession sess) {
		return "/member/login";
	}
	
	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}
	
	@GetMapping("/member/signup")
	public String signup(String type, Model model) {
		
		TermsVO vo = termsrepo.findById(0).get();
		model.addAttribute("type", type);
		model.addAttribute(vo); //vo의 객체를 뷰에서 씀(소문자로)
		
		return "/member/signup";
	}
	
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(MemberVO vo, HttpServletRequest req, String encPass) {

		/*try {
			String pass = vo.getPass();
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(pass.getBytes("UTF-8"));
			StringBuffer encPass = new StringBuffer();
			
			for(int i=0; i<hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) encPass.append('0');
				encPass.append(hex);
			}
			
			return encPass.toString();
			
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		vo.setPass(encPass);*/
		vo.setIp(req.getRemoteAddr());
		vo.setRdate(LocalDateTime.now().toString());
		memberrepo.save(vo);
		
		return "redirect:/member/login";
	}
	
	@GetMapping("/member/register-seller")
	public String registerSeller() {
		return "/member/register-seller";
	}
	
	@PostMapping("/member/register-seller")
	public String registerSeller(MemberVO vo, HttpServletRequest req) {
		
		vo.setIp(req.getRemoteAddr());
		vo.setRdate(LocalDateTime.now().toString());
		memberrepo.save(vo);
		
		return "redirect:/member/login";
	}
}
