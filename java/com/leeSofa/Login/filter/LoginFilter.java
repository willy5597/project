/*package com.leeSofa.Login.filter;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Map;

import com.leeSofa.WebKeyUtil;
import com.leeSofa.dao.UserDao;
import com.leeSofa.model.po.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginFilter implements Filter{



@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	
	HttpServletRequest req = (HttpServletRequest)request;
	HttpServletResponse resp = (HttpServletResponse)response;
	HttpSession session = req.getSession();
	
	// 判斷使用者是否已經登入 ?
	Object loginStatue = session.getAttribute("loginStatue");
	if(loginStatue != null && Boolean.valueOf(loginStatue+"")) {
		// 放行
		chain.doFilter(request, response);
	} else {
		// 驗證 username & password
		String useremail = req.getParameter("useremail");
		String password = req.getParameter("password");
		// 判斷是否有輸入 username
		if(useremail == null || useremail.trim().length() == 0) {
			resp.sendRedirect("/login");
			return;
		}
		// 是否有此 username ?
		UserDao user = User.get(useremail);
		if(user == null) {
			System.out.println("無此使用者");
			resp.sendRedirect("/login");
			return;
		}
		// 判斷 password
		// 得到使用者的 hash 與 salt
		String hash = user.get("hash"); // 使用者的 hash
		byte[] salt = WebKeyUtil.hexStringToByteArray(user.get("salt")); // 使用者的 salt
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.reset(); // 重制
			messageDigest.update(salt); // 加鹽
			byte[] inputHashedBytes = messageDigest.digest(password.getBytes());
			// 根據使用者輸入的 password 與已知的 salt 來產出 comparedHash
			String comparedHash = WebKeyUtil.bytesToHexString(inputHashedBytes);
			// 比較 comparedHash(運算的) 與 hash(已儲存的) 是否相等
			
			if(comparedHash.equals(hash)) {
				// 儲存登入狀態
				session.setAttribute("loginStatue", true);
				// 放行
				chain.doFilter(request, response);
				return;
			} else {
				System.out.println("登入失敗");
				resp.sendRedirect("/login");
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/login");
		}
		
	}
	
  }
}*/