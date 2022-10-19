import com.sist.vo.BookVO;

public class mainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookVO b = new BookVO();
		b.setBookid(10);
		b.setBookname("fun java");
		System.out.println(b.getBookid());
		System.out.println(b.getBookname());
	}

}
