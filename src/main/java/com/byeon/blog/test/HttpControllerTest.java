package com.byeon.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller : 사용자가 요청 -> 응답(HTML 파일)

//@RestController : 사용자가 요청 -> 응답(Data)

// --- view 에서 값을 받아 오는 방법
//@RequestParam : view에서 Query String 으로 받는 값 (단일 값)

//@RequestBody : view에서 오브젝트(객체)로 Mapping해서 값을 받아 올때 (복수 값)

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest : ";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		//Member m = new Member(1, "byeon", "1234", "byeon@email");
		
		// build 패턴(lombok) : 내가 어떤 값을 넣을때 순서를 안지켜도 된다. 
		Member m = Member.builder().username("byeon").password("1234").email("byeon@email").build();
		System.out.println(TAG + "getter : " + m.getUsername());
		m.setUsername("Wook");
		System.out.println(TAG + "getter : " + m.getUsername());
		return "lombok test 완료";
	}
	
	// 인터넷 브라우저 요청은 무조건 GET 요청 밖에 할 수 없다.
	// http://localhost:8080/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) { // http://localhost:8080/http/get?id=1&username=ssar&password=1234&email=byeon@naver.com // MessageConverter (스프링부트)

		
		return "get 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8080/http/post (insert)
	// JSON
	@PostMapping("/http/post") // MIME Type --> raw : text/plain, application : json
	public String postTest(@RequestBody Member m) { // MessageConverter (스프링부트) -- 자동으로 파싱해서 값을 넣어주는 일을 해준다.
		return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail(); 
	}
	
	// http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	// http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
	
}
