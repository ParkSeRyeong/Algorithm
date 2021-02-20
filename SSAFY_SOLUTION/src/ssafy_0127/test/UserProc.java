package ssafy_0127.test;


//데이타베이스 연동(비즈니스로직 처리)
public class UserProc {
	
	/*   getLoginUser 메서드를 만드시오
	 *   
	 *   (1)매개변수로 들어온 pororo와 1234를 비교하여
	 *      맞으면  아래와 같이 entity 객체를 만드시오 
	 *      User entity=new User();
	 *   (2) setter를 통해 id, pw, "뽀로로", 89.97를 대입하시오
	 *   (3) entity를 리턴하시오
	 */
	
	public User getLoginUser(String id, String pw) {
		if(id.equals("pororo")&&pw.equals("1234")) {
			User entity=new User();
			entity.setId(id);
			entity.setPw(pw);
			entity.setName("뽀로로");
			entity.setPoint(89.97);
			return entity;
		}else {
			return null;
		}
	}
}
