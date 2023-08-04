package Generic_Utilities;

import java.util.Random;

public class Java_Utility {
/**
 * This method is used to avoid Duplicates
 * @return
 * @author Shobha
 */
	public int getRandomNum()
	{
		Random r = new Random();
	int ranNum = r.nextInt(1000);
	return ranNum;
}
}
