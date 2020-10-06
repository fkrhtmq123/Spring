package kr.co.kmarket.controller;

import java.security.MessageDigest;

import kr.co.kmarket.vo.MemberVO;

public class Sha256 {
	
	public static String SHA256(String pass) {
		MemberVO vo = new MemberVO();
		String encPass = "";
		
		try {
			pass = vo.getPass();
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(pass.getBytes());
			byte byteData[] = digest.digest();
			StringBuffer sp = new StringBuffer();
			
			for(int i=0; i<byteData.length; i++) {
				sp.append(Integer.toString(byteData[i] & 0xff + 0x100, 16).substring(1));
			}
			
			encPass = sp.toString();
			
		} catch(Exception e) {
			encPass = null;
		}
		return encPass;
	}

}
